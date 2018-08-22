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
 * project: eagle-authorization-server
 * <p>
 * Revision History:
 * Date         Version     Name                Description
 * 7/17/18  1.0         liuzhiheng         Creation File
 */
package com.tubatao.eagle.authorization.config;

import com.tubatao.eagle.authorization.config.properties.TokenPropertiesConfig;
import com.tubatao.eagle.authorization.constants.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.util.Arrays;

/**
 * Description:
 *
 *
 * @author liuzhiheng
 * @date 7/17/18 3:41 PM
 */
@Configuration
public class Oauth2TokenConfig
{
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private TokenEnhancerChain tokenEnhancerChain;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private TokenEnhancer tokenEnhancer;
    @Autowired(required = false)
    private TokenPropertiesConfig tokenPropertiesConfig;

    /**
     * <p>注意，自定义TokenServices的时候，需要设置@Primary，否则报错，</p>
     * @return
     */
    @Primary
    @Bean
    public AuthorizationServerTokenServices defaultTokenServices(){
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(redisTokenStore());
        // Token 增强
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer,jwtAccessTokenConverter));
        tokenServices.setTokenEnhancer(tokenEnhancerChain);
        // tokenServices.setClientDetailsService(clientDetails());
        if(tokenPropertiesConfig!=null){
            Boolean supportRefreshToken=tokenPropertiesConfig.getSupportRefreshToken();
            Boolean reuseRefreshToken=tokenPropertiesConfig.getReuseRefreshToken();
            Integer accessTokenValiditySeconds=tokenPropertiesConfig.getAccessTokenValiditySeconds();
            Integer refreshTokenValiditySeconds=tokenPropertiesConfig.getRefreshTokenValiditySeconds();
            if(supportRefreshToken!=null)
                tokenServices.setSupportRefreshToken(supportRefreshToken);
            if(reuseRefreshToken!=null)
                tokenServices.setReuseRefreshToken(reuseRefreshToken);
            if(accessTokenValiditySeconds!=null)
                tokenServices.setAccessTokenValiditySeconds(accessTokenValiditySeconds); // token有效期自定义设置，默认12小时
            if(refreshTokenValiditySeconds!=null)
                tokenServices.setRefreshTokenValiditySeconds(refreshTokenValiditySeconds);//默认30天，这里修改
        }

        return tokenServices;
    }

    /**
     * tokenstore 定制化处理
     *
     * @return TokenStore
     * 1. 如果使用的 redis-cluster 模式请使用 EagleRedisTokenStore
     * EagleRedisTokenStore tokenStore = new EagleRedisTokenStore();
     * tokenStore.setRedisTemplate(redisTemplate);
     */
    @Bean
    public TokenStore redisTokenStore() {
        RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
        tokenStore.setPrefix(SecurityConstants.EAGLE_PREFIX);
        return tokenStore;
    }
}