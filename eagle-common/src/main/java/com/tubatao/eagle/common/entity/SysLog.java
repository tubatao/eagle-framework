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
package com.tubatao.eagle.common.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 *
 *
 * @author liuzhiheng
 * @date 7/11/18 4:41 PM
 */
@Data
@Table(name = "sys_log")
public class SysLog implements Serializable{
    private static final long serialVersionUID = -9037460126548024968L;
    /**
     * 编号
     */
    @Id
    private Long id;
    /**
     * 日志类型
     */
    private String type;
    /**
     * 日志标题
     */
    private String title;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 操作IP地址
     */
    private String remoteAddr;
    /**
     * 用户代理
     */
    private String userAgent;
    /**
     * 请求URI
     */
    private String requestUri;
    /**
     * 操作方式
     */
    private String method;
    /**
     * 操作提交的数据
     */
    private String params;
    /**
     * 执行时间
     */
    private Long time;

    /**
     * 删除标记
     */
    private String delFlag;

    /**
     * 异常信息
     */
    private String exception;

    /**
     * 服务ID
     */
    private String serviceId;

    @Override
    public String toString() {
        return "SysLog{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", remoteAddr='" + remoteAddr + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", requestUri='" + requestUri + '\'' +
                ", method='" + method + '\'' +
                ", params='" + params + '\'' +
                ", time=" + time +
                ", delFlag='" + delFlag + '\'' +
                ", exception='" + exception + '\'' +
                ", serviceId='" + serviceId + '\'' +
                '}';
    }
}