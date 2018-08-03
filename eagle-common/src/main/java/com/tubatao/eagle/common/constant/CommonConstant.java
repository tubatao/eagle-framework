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
 * @date 7/11/18 5:00 PM
 */
public interface CommonConstant {
    /**
     * Token request header name
     */
    String REQ_HEADER = "Authorization";

    /**
     * Token separator
     */
    String TOKEN_SPLIT = "Bearer ";

    /**
     * Jwt signature
     */
    String SIGN_KEY = "EAGLE";
    /**
     * Delete
     */
    String STATUS_DEL = "1";
    /**
     * Normal
     */
    String STATUS_NORMAL = "0";

    /**
     * Lock
     */
    String STATUS_LOCK = "9";

    /**
     * Menu
     */
    String MENU = "0";

    /**
     * Button
     */
    String BUTTON = "1";

    /**
     * Delete tag
     */
    String DEL_FLAG = "del_flag";

    /**
     * Encoding
     */
    String UTF8 = "UTF-8";

    /**
     * JSON resources
     */
    String CONTENT_TYPE = "application/json; charset=utf-8";

    /**
     * ALIYUN_SMS
     */
    String ALIYUN_SMS = "aliyun_sms";

    /**
     * 路由信息Redis保存的key
     */
    String ROUTE_KEY = "_ROUTE_KEY";
}