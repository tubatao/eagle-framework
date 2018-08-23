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
package com.tubatao.eagle.authorization.config.properties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @author liuzhiheng
 * @date 7/27/2018 3:40 PM
 */
@Configuration
@ConfigurationProperties(prefix = "token")
@ConditionalOnProperty(prefix = "token",name = "accessTokenValiditySeconds")
public class TokenPropertiesConfig {
    /**
     * Whether to support the refresh token.
     *
     */
    private Boolean supportRefreshToken;
    /**
     * Whether to reuse refresh tokens (until expired).
     *
     */
    private Boolean reuseRefreshToken;
    /**
     * The default validity (in seconds) of the access token. Zero or negative for non-expiring tokens. If a client
     * details service is set the validity period will be read from he client, defaulting to this value if not defined
     * by the client.
     *
     */
    private int accessTokenValiditySeconds;
    /**
     * The validity (in seconds) of the refresh token. If less than or equal to zero then the tokens will be
     * non-expiring.
     *
     */
    private int refreshTokenValiditySeconds;

    public Boolean getSupportRefreshToken() {
        return supportRefreshToken;
    }

    public void setSupportRefreshToken(Boolean supportRefreshToken) {
        this.supportRefreshToken = supportRefreshToken;
    }

    public Boolean getReuseRefreshToken() {
        return reuseRefreshToken;
    }

    public void setReuseRefreshToken(Boolean reuseRefreshToken) {
        this.reuseRefreshToken = reuseRefreshToken;
    }

    public int getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(int accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    public int getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(int refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }
}