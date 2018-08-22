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
package com.tubatao.eagle.util.template;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 * 短信消息模板
 *
 * @author liuzhiheng
 * @date 8/1/2018 2:42 PM
 */
@Data
public class MobileMsgTemplate implements Serializable {
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 组装后的模板内容JSON字符串
     */
    private String context;
    /**
     * 短信通道
     */
    private String channel;
    /**
     * 短信类型(验证码或者通知短信)
     * 暂时不用，留着后面存数据库备用吧
     */
    private String type;
    /**
     * 短信签名
     */
    private String signName;
    /**
     * 短信模板
     */
    private String template;

    public MobileMsgTemplate(String mobile, String context, String channel, String signName, String template){
        this.mobile = mobile;
        this.context = context;
        this.channel = channel;
        this.signName = signName;
        this.template = template;
    }
}