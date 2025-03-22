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

package top.continew.admin.news.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Data
@Setter
public class AntiUserDO {
    private Long userId;
    private String userPhone;
    private String userNickName;
    private Long userGender;
    private String userBrief;
    private String userHeadUrl;
    private Date userBirth;
    private String userCity;
    private String userName;
    private String userPassword;
    private Long userRole;
    private String userJob;
    private String userEmail;
    private Long state;
    private String loginIp;
    private Date loginTime;
    private Date createTime;
    private Date modifyTime;
}
