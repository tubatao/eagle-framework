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
 * 8/2/2018  1.0         liuzhiheng         Creation File
 */
package com.tubatao.eagle.core.exception;

import lombok.Getter;

/**
 * Description:
 *
 * @author liuzhiheng
 * @date 8/2/2018 4:11 PM
 */
@Getter
public class DaoException extends BaseException{
    private String tableName;
    private String sqlStatement;

    public DaoException(String message, String tableName, Throwable cause){
        super(message+": "+tableName,cause);
        this.tableName = tableName;

    }
    public DaoException(String message,String tableName, String sqlStatement, Throwable cause){
        super(message+": "+tableName,cause);
        this.tableName = tableName;
        this.sqlStatement = sqlStatement;
    }
    public DaoException(String message,String tableName){
        super(message+": "+tableName);
        this.tableName = tableName;

    }
    public DaoException(String message,String tableName,String sqlStatement){
        super(message+": "+tableName);
        this.tableName = tableName;
        this.sqlStatement = sqlStatement;
    }
}