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
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 * 动态路由配置表
 *
 * @author liuzhiheng
 * @date 7/11/18 4:43 PM
 */
@TableName("sys_zuul_route")
@Data
public class SysZuulRoute extends com.baomidou.mybatisplus.activerecord.Model<SysZuulRoute> {

    private static final long serialVersionUID = 1L;

    /**
     * router Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 路由路径
     */
    private String path;

    /**
     * 服务名称
     */
    @TableField("service_id")
    private String serviceId;

    /**
     * url代理
     */
    private String url;

    /**
     * 转发去掉前缀
     */
    @TableField("strip_prefix")
    private String stripPrefix;

    /**
     * 是否重试
     */
    private String retryable;

    /**
     * 是否启用
     */
    private String enabled;

    /**
     * 敏感请求头
     */
    @TableField("sensitiveHeaders_list")
    private String sensitiveheadersList;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 删除标识（0-正常,1-删除）
     */
    @TableField("del_flag")
    private String delFlag;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
