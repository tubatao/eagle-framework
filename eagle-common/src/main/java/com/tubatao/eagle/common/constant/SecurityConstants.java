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
 * 7/11/18  1.0         liuzhiheng         Creation File
 */
package com.tubatao.eagle.common.constant;

/**
 * Description:
 *
 *
 * @author liuzhiheng
 * @date 7/11/18 4:51 PM
 */
public interface SecurityConstants {
    /**
     * Prefix
     */
    String EAGLE_PREFIX = "eagle_";
    /**
     * User header
     */
    String USER_HEADER = "x-user-header";

    /**
     * role header
     */
    String ROLE_HEADER = "x-role-header";
    /**
     * license for prject
     */
    String EAGLE_LICENSE = "made by eagle";
    /**
     * base role
     */
    String BASE_ROLE = "ROLE_USER";
    /**
     * Authorization code mode
     */
    String AUTHORIZATION_CODE = "authorization_code";
    /**
     * Password mode
     */
    String PASSWORD = "password";
    /**
     * Refresh token
     */
    String REFRESH_TOKEN = "refresh_token";

    /**
     * oauth token
     */
    String OAUTH_TOKEN_URL = "/oauth/token";

    /**
     * The URL for mobile login
     */
    String MOBILE_TOKEN_URL = "/mobile/token";

    /**
     * Verification code url prefix
     */
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    /**
     * The default url prefix for processing the verification code
     */
    String MOBILE_VALIDATE_CODE_URL_PREFIX = "/smsCode";

    /**
     * The width for generated graphic verification code by default
     */
    String DEFAULT_IMAGE_WIDTH = "100";

    /**
     * The high for generated graphic verification code by default
     */
    String DEFAULT_IMAGE_HEIGHT = "40";

    /**
     * The number of generated graphics verification codes by default
     */
    String DEFAULT_IMAGE_LENGTH = "4";

    /**
     * The expiration time of generated graphics verification codes by default
     */
    int DEFAULT_IMAGE_EXPIRE = 60;
    /**
     * Border color , legal value: r,g,b (and optional alpha) or white,black,blue.
     */
    String DEFAULT_COLOR_FONT = "black";

    /**
     * Picture border
     */
    String DEFAULT_IMAGE_BORDER = "no";
    /**
     * Default picture interval
     */
    String DEFAULT_CHAR_SPACE = "5";

    /**
     * Default code prefix
     */
    String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY";
    /**
     * Captcha text size
     */
    String DEFAULT_IMAGE_FONT_SIZE = "30";

    /**
     * token-uservo
     */
    String TOKEN_USER_DETAIL = "token-user-detail";

    /**
     * Default social login address
     */
    String DEFAULT_SOCIAL_PROCESS_URL = "/social";
    /**
     * Default social registered address
     */
    String DEFAULT_SOCIAL_SIGNUP_URL = "/social/signup";

    /**
     * The field of the sys_oauth_client_details table, excluding client_id, client_secret
     */
    String CLIENT_FIELDS = "client_id, client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";

    /**
     *JdbcClientDetailsService query statement
     */
    String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS
            + " from sys_oauth_client_details";

    /**
     * Default query statement
     */
    String DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";

    /**
     * Query by condition client_id
     */
    String DEFAULT_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?";
}