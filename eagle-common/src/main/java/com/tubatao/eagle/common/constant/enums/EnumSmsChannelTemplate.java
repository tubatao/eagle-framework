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
 * 8/1/2018  1.0         liuzhiheng         Creation File
 */
package com.tubatao.eagle.common.constant.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * Description:
 * SMS channel template
 *
 * @author liuzhiheng
 * @date 8/1/2018 2:16 PM
 */
public enum EnumSmsChannelTemplate {
    /**
     * Login authentication
     */
    LOGIN_NAME_LOGIN("loginCodeChannel", "登录验证"),
    /**
     * Service exception reminder
     */
    SERVICE_STATUS_CHANGE("serviceStatusChange", "Eagle4Cloud");


    /**
     * Template name
     */
    @Getter
    @Setter
    private String template;
    /**
     * Template signature
     */
    @Getter
    @Setter
    private String signName;

    EnumSmsChannelTemplate(String template, String signName) {
        this.template = template;
        this.signName = signName;
    }
}
