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
package com.tubatao.eagle.common.bean;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Description:
 * Paging response object
 *
 * @author liuzhiheng
 * @date 8/2/2018 11:20 AM
 */
@Data
public class PageResp<T> {
    private List<T> rows;

    private int page;

    private int pagesize;

    private long total;

    public PageResp(Page<T> page) {
        this.rows = page.getContent();
        this.page = page.getNumber() + 1;
        this.pagesize = page.getSize();
        this.total = page.getTotalElements();
    }

}
