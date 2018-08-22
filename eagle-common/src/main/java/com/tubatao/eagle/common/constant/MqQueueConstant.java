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
public interface MqQueueConstant {
    /**
     * log rabbit队列名称
     */
    String LOG_QUEUE = "log";

    /**
     * 发送短信验证码队列
     */
    String MOBILE_CODE_QUEUE = "mobile_code_queue";

    /**
     * 短信服务状态队列
     */
    String MOBILE_SERVICE_STATUS_CHANGE = "mobile_service_status_change";

    /**
     * 钉钉服务状态队列
     */
    String DINGTALK_SERVICE_STATUS_CHANGE = "dingtalk_service_status_change";

    /**
     * zipkin 队列
     */
    String ZIPKIN_NAME_QUEUE = "zipkin";

    /**
     * 路由配置状态队列
     */
    String ROUTE_CONFIG_CHANGE = "route_config_change";
}