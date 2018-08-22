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
package com.tubatao.eagle.util;

import com.tubatao.eagle.core.exception.CheckedException;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Description:
 * 数据校验
 *
 * @author liuzhiheng
 * @date 8/1/2018 2:33 PM
 */
public class Assert {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     * @param object        待校验对象
     * @param groups        待校验的组
     * @throws CheckedException  校验不通过，则报RRException异常
     */
    public static void validateEntity(Object object, Class<?>... groups)
            throws CheckedException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for(ConstraintViolation<Object> constraint:  constraintViolations){
                msg.append(constraint.getMessage()).append("<br>");
            }
            throw new CheckedException(msg.toString());
        }
    }

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new CheckedException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new CheckedException(message);
        }
    }
}
