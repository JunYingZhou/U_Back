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

package top.continew.admin.news.model.VO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Data
@Setter
public class CommentVO {
    private Long commentId;
    private Long articleId;
    private String commentContent;
    private Long userId;
    private Long toUserId;
    private Long commentRootId;
    private Long commentLikeCount;
    private Long commentType;
    private Date createTime;
    private String avatar;
    private String nickname;
    private Date modifyTime;
}
