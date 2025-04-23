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
import cn.dev33.satoken.annotation.SaIgnore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.continew.admin.news.mapper.AntiUserMapper;
import top.continew.admin.news.mapper.CommentMapper;
import top.continew.admin.news.model.AnswersDO;
import top.continew.admin.news.model.AntiUserDO;
import top.continew.admin.news.model.CommentDO;
import top.continew.admin.news.model.Req.QuestionsReq;
import top.continew.admin.news.model.VO.AnswersLikeVO;
import top.continew.admin.news.model.VO.AnswersVO;
import top.continew.admin.news.model.VO.CommentLikeVO;
import top.continew.admin.news.model.VO.CommentVO;
import top.continew.admin.news.model.resp.QuestionsResp;
import top.continew.admin.news.service.AntiUserService;
import top.continew.admin.news.service.CommentService;

import java.util.List;

import static top.continew.admin.common.context.UserContextHolder.getUserId;

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
    public List<AnswersVO> queryAllAnswersById(Long questionId) {
        return mapper.queryAllAnswersById(questionId);
    }

    @Override
    public Long addComment(CommentDO commentDO) {
        return mapper.addComment(commentDO);
    }

    @Override
    public Long addAnswers(AnswersDO answersDO) {
        return mapper.addAnswers(answersDO);
    }

    @Override
    public Long updateComment(CommentDO commentDO) {
        return mapper.updateComment(commentDO);
    }

    @Override
    public Long updateAnswers(AnswersDO answersDO) {
        return mapper.updateAnswers(answersDO);
    }

    @Override
    public Long deleteComment(Long commentId) {
        return mapper.deleteComment(commentId);
    }

    @Override
    public Long delAnswers(Long commentId) {
        return mapper.delAnswers(commentId);
    }

    @Transactional
    @Override
    public Boolean addCommentLike(Long commentId, Long userId, Long articleId) {
        Long l = mapper.updateCommentLike(commentId);
        Long l1 = mapper.addCommentLike(commentId, userId, articleId);
        return l1 > 0 & l > 0;
    }

    @Override
    public Boolean addAnswersLike(Long commentId, Long userId, Long questionId) {
        long l = mapper.updateAnswersLike(commentId);
        long l1 = mapper.addAnswersLike(commentId, userId, questionId);
        return null;
    }

    @Override
    public Long addQuestions(QuestionsResp questionsReq) {
        return mapper.addQuestions(questionsReq);
    }

    @Override
    public List<CommentLikeVO> queryCommentByUserId(Long userId, Long articleId) {
        return mapper.queryCommentLikeByUserId(userId, articleId);
    }

    @Override
    public List<AnswersLikeVO> queryAnswersByUserId(Long userId, Long articleId) {
        return mapper.queryAnswersByUserId(userId, articleId);
    }

}
