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
import top.continew.admin.news.model.AnswersDO;
import top.continew.admin.news.model.AntiUserDO;
import top.continew.admin.news.model.CommentDO;
import top.continew.admin.news.model.Req.QuestionsReq;
import top.continew.admin.news.model.VO.AnswersLikeVO;
import top.continew.admin.news.model.VO.AnswersVO;
import top.continew.admin.news.model.VO.CommentLikeVO;
import top.continew.admin.news.model.VO.CommentVO;
import top.continew.admin.news.model.resp.QuestionsResp;
import top.continew.starter.data.mp.base.BaseMapper;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<AntiUserDO> {

    List<CommentVO> queryAllComment(Long articleId);

    List<AnswersVO> queryAllAnswersById(Long questionId);

    Long addComment(CommentDO commentDO);

    Long addAnswers(AnswersDO answersDO);

    Long updateComment(CommentDO commentDO);

    Long updateAnswers(AnswersDO answersDO);

    Long updateCommentLike(Long commentId);

    Long updateAnswersLike(Long commentId);

    Long deleteComment(Long id);

    Long delAnswers(Long id);

    Long addCommentLike(Long commentId,Long userId, Long articleId);

    Long addAnswersLike(Long commentId,Long userId, Long questionId);

    List<CommentLikeVO> queryCommentLikeByUserId(Long userId, Long articleId);

    List<AnswersLikeVO> queryAnswersByUserId(Long userId, Long questionId);

    Long addQuestions(QuestionsResp questionsReq);

}
