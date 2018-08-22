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
 * 6/19/18  1.0         liuzhiheng         Creation File
 */
package com.tubatao.eagle.common.constant;

import java.nio.charset.Charset;

/**
 * Description:
 *
 * @author liuzhiheng
 * @date 6/19/18 3:58 PM
 */
public class Constant {
    public static final String DefultCharsetName = "utf-8";
    public static final Charset DefultCharset = Charset.forName(DefultCharsetName);
    public static final String LineSeparator = System.getProperty("line.separator");
    public static final String HTTPSERVICE_RESULT = "resultStatus";
    public static final String HTTPSERVICE_DESCRIPTION = "errorMessage";
    public static final String HTTPSERVICE_DATA = "data";
    public static final Integer RESULT_SUCCESS = Integer.valueOf(0);
    public static final Integer RESULT_FAILURE = Integer.valueOf(1);
    public static final String HTTPSERVICE_UNKNOWN = "Unknown error.";
    public static final String PAGE_REQUEST_SIZE = "size";
    public static final String PAGE_REQUEST_PAGE = "page";
    public static final int DEFAULT_PAGE_SIZE = 20;
    /**
     * 签名key
     */
    public static final String SIGNING_KEY = "spring-security-@Jwt!&Secret^#";

    public static final String JSON="application/json";

}