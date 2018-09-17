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
 * 8/29/2018  1.0         liuzhiheng         Creation File
 */
package com.tubatao.eagle.gateway.service.impl;

import com.tubatao.eagle.gateway.service.PermissionService;
import com.xiaoleilu.hutool.collection.CollectionUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Description:
 *
 * @author liuzhiheng
 * @date 8/29/2018 3:59 PM
 */
@Slf4j
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
//    @Autowired
//    private MenuService menuService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        //ele-admin options 跨域配置，现在处理是通过前端配置代理，不使用这种方式，存在风险
//        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(request.getMethod())) {
//            return true;
//        }
        Object principal = authentication.getPrincipal();
        List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        boolean hasPermission = false;

        if (principal != null) {
            if (CollectionUtil.isEmpty(grantedAuthorityList)) {
                log.warn("角色列表为空：{}", authentication.getPrincipal());
                return hasPermission;
            }

            //TODO: 校验权限
            for (SimpleGrantedAuthority authority : grantedAuthorityList) {
                if (!StrUtil.equals(authority.getAuthority(), "ROLE_USER")) {
                    String ss=authority.getAuthority();
                }
            }

//            Set<MenuVO> urls = new HashSet<>();
//            for (SimpleGrantedAuthority authority : grantedAuthorityList) {
//                if (!StrUtil.equals(authority.getAuthority(), "ROLE_USER")) {
//                    Set<MenuVO> menuVOSet = menuService.findMenuByRole(authority.getAuthority());
//                    if (CollUtil.isNotEmpty(menuVOSet)) {
//                        CollUtil.addAll(urls, menuVOSet);
//                    }
//                }
//            }
//
//            for (MenuVO menu : urls) {
//                if (StringUtils.isNotEmpty(menu.getUrl()) && antPathMatcher.match(menu.getUrl(), request.getRequestURI())
//                        && request.getMethod().equalsIgnoreCase(menu.getMethod())) {
//                    hasPermission = true;
//                    break;
//                }
//            }
        }
        return hasPermission;
    }
}