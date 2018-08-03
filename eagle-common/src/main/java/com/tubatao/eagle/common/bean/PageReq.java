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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

/**
 * Description:
 * Paging request parameter
 *
 * @author liuzhiheng
 * @date 8/2/2018 11:18 AM
 */
@Data
public class PageReq {

    private int page = 1;

    private int pagesize = 10;

    private String sortfield = "";

    private String sort = "";

    private String keyword = "";

    public PageReq() {
        super();
    }

    public PageReq(int page, int pagesize, String sortfield, String sort,
                   String keyword) {
        super();
        this.page = page;
        this.pagesize = pagesize;
        this.sortfield = sortfield;
        this.sort = sort;
        this.keyword = keyword;
    }

    public PageReq getPageable() {
        return new PageReq(page, pagesize, sortfield, sort, keyword);
    }

    public Pageable toPageable() {
        // The pageable is from page 0.
        Pageable pageable = null;

        if (StringUtils.isEmpty(sortfield)) {
            pageable = new PageRequest(page - 1, pagesize);
        }
        else {
            pageable = new PageRequest(page - 1, pagesize,
                    sort.toLowerCase().startsWith("desc") ? Sort.Direction.DESC
                            : Sort.Direction.ASC,
                    sortfield);
        }

        return pageable;
    }
}
