/**
 * Copyright(c) tubatao Technology Co.,Ltd.
 * All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * project: eagle-framework
 * <p>
 * Revision History:
 * Date         Version     Name                Description
 * 7/27/2018  1.0         liuzhiheng         Creation File
 */
package com.tubatao.eagle.authorization.config;

import com.tubatao.eagle.authorization.config.jwt.JksPropertiesConfig;
import com.tubatao.eagle.authorization.config.jwt.MacPropertiesConfig;
import com.tubatao.eagle.authorization.dto.UserDetailsImpl;
import com.tubatao.eagle.authorization.exception.FileException;
import com.tubatao.eagle.common.constant.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author liuzhiheng
 * @date 7/27/2018 9:42 AM
 */
@Configuration
public class TokenEnhancerConfig {

    @Autowired
    private JksPropertiesConfig jksPropertiesConfig;
    @Autowired
    private MacPropertiesConfig macPropertiesConfig;

    @Bean
    @ConditionalOnProperty(prefix = "jwt",name = "encryption",havingValue = "rsa")
    public JwtAccessTokenConverter jwtRsaAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new EagleJwtAccessTokenConverter();
        KeyStoreKeyFactory keyStoreKeyFactory;
        StringBuffer filePath=new StringBuffer();
        if(jksPropertiesConfig.getPath()!=null){
            filePath.append(jksPropertiesConfig.getPath());
            filePath.append(File.separator);
            filePath.append(jksPropertiesConfig.getFileName());
            try{
                keyStoreKeyFactory = new KeyStoreKeyFactory(new FileSystemResource(filePath.toString()), jksPropertiesConfig.getPassword().toCharArray());
            }catch (Exception ex){
                //TODO: 异常错误代码定义
                throw new FileException("file not found!",ex);
            }
        }else {
            filePath.append(jksPropertiesConfig.getFileName());
            keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource(filePath.toString()), jksPropertiesConfig.getPassword().toCharArray());

        }
        jwtAccessTokenConverter.setKeyPair(keyStoreKeyFactory.getKeyPair(jksPropertiesConfig.getAlias()));
        return jwtAccessTokenConverter;
    }

    @Bean
    @ConditionalOnProperty(prefix = "jwt",name = "encryption",havingValue = "mac")
    public JwtAccessTokenConverter jwtShaAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new EagleJwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(macPropertiesConfig.getKey());
        return jwtAccessTokenConverter;
    }

    /**
     * jwt 生成token 定制化处理
     *
     * @return TokenEnhancer
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            final Map<String, Object> additionalInfo = new HashMap<>(2);
            additionalInfo.put("license", SecurityConstants.EAGLE_LICENSE);
            UserDetailsImpl user = (UserDetailsImpl) authentication.getUserAuthentication().getPrincipal();
            if (user != null) {
                additionalInfo.put("userId", user.getUserId());
            }
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        };
    }

    @Bean
    public TokenEnhancerChain tokenEnhancerChain(){
        return new TokenEnhancerChain();
    }
}