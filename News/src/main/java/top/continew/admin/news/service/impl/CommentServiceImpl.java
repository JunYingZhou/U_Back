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

package top.continew.admin.news.service.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.continew.admin.news.mapper.AntiUserMapper;
import top.continew.admin.news.mapper.CommentMapper;
import top.continew.admin.news.model.AntiUserDO;
import top.continew.admin.news.model.CommentDO;
import top.continew.admin.news.model.VO.CommentVO;
import top.continew.admin.news.service.AntiUserService;
import top.continew.admin.news.service.CommentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    // 设置常量名
    private static final String CACHE_NAME = "USER_CACHE";

    private final CommentMapper mapper;


    @Override
    public List<CommentVO> queryAllCommentById(Long articId)  {
        return mapper.queryAllComment(articId);
    }

    @Override
    public Long addComment(CommentDO commentDO) {
        return mapper.addComment(commentDO);
    }

    @Override
    public Long updateComment(CommentDO commentDO) {
        return mapper.updateComment(commentDO);
    }

    @Override
    public Long deleteComment(Long commentId) {
        return mapper.deleteComment(commentId);
    }

}
