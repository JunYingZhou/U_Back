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

package top.continew.admin.news.service;

import top.continew.admin.news.model.AnswersDO;
import top.continew.admin.news.model.AntiUserDO;
import top.continew.admin.news.model.CommentDO;
import top.continew.admin.news.model.Req.QuestionsReq;
import top.continew.admin.news.model.VO.AnswersLikeVO;
import top.continew.admin.news.model.VO.AnswersVO;
import top.continew.admin.news.model.VO.CommentLikeVO;
import top.continew.admin.news.model.VO.CommentVO;
import top.continew.admin.news.model.resp.QuestionsResp;

import java.util.List;

public interface CommentService {

    List<CommentVO> queryAllCommentById(Long articleId);


    List<AnswersVO> queryAllAnswersById(Long questionId);

    Long addComment(CommentDO commentDO);

    Long addAnswers(AnswersDO answersDO);

    Long updateComment(CommentDO commentDO);

    Long updateAnswers(AnswersDO answersDO);

    Long deleteComment(Long commentId);

    Long delAnswers(Long commentId);

    Boolean addCommentLike(Long commentId, Long userId, Long articleId);

    Boolean addAnswersLike(Long commentId, Long userId, Long questionId);


    Long addQuestions(QuestionsResp questionsReq);

    List<CommentLikeVO> queryCommentByUserId(Long userId, Long articleId);

    List<AnswersLikeVO> queryAnswersByUserId(Long userId, Long articleId);

}
