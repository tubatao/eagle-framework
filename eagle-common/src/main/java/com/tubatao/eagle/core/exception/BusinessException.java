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
 * @date 8/2/2018 3:00 PM
 */
@Getter
public class BusinessException extends BaseException {
    private int errorCode;
    @Deprecated
    public BusinessException() {
        super();
    }

    @Deprecated
    public BusinessException(String message) {
        super(message);
    }

    @Deprecated
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    @Deprecated
    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    protected BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}