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

package top.continew.admin.news.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.continew.admin.news.model.AntiUserDO;
import top.continew.admin.news.model.CommentDO;
import top.continew.admin.news.model.VO.CommentLikeVO;
import top.continew.admin.news.model.VO.CommentVO;
import top.continew.starter.data.mp.base.BaseMapper;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<AntiUserDO> {

    List<CommentVO> queryAllComment(Long articleId);

    Long addComment(CommentDO commentDO);

    Long updateComment(CommentDO commentDO);

    Long updateCommentLike(Long commentId);

    Long deleteComment(Long id);

    Long addCommentLike(Long commentId,Long userId, Long articleId);

    List<CommentLikeVO> queryCommentLikeByUserId(Long userId, Long articleId);

}
