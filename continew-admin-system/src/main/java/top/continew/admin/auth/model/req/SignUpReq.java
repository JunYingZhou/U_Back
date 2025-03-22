/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.continew.admin.auth.model.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 账号注册信息
 *
 * @author Charles7c
 * @since 2022/12/21 20:43
 */
@Data
@Schema(description = "账号注册信息")
public class SignUpReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 电话或者邮箱
     */
    @Schema(description = "用户名", example = "zhangsan")
    @NotBlank(message = "用户名不能为空")
    private String account;

    /**
     * 密码（加密）
     */
    @Schema(description = "密码（加密）", example = "HHwZoiBwCfh0xLdWOAd0bHOkEZlIMMOQKJyeFUw9T3ArrhL57od2i42s1o0sSXKkeHPJXvQsninhPFH2lArDDQ==")
    @NotBlank(message = "密码不能为空")
    private String password;

}
