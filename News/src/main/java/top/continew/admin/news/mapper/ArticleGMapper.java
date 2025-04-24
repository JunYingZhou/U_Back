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
import org.apache.ibatis.annotations.Param;
import top.continew.admin.news.model.ArticleFileDO;
import top.continew.admin.news.model.ArticleGDO;
import top.continew.admin.news.model.LikeStarDO;
import top.continew.admin.news.model.Req.ArticleGReq;
import top.continew.admin.news.model.Req.QuestionsReq;
import top.continew.admin.news.model.resp.ArticleResp;
import top.continew.admin.news.model.resp.QuestionRepoResp;
import top.continew.admin.news.model.resp.QuestionsResp;
import top.continew.starter.data.mp.base.BaseMapper;

import java.util.List;

@Mapper
public interface ArticleGMapper extends BaseMapper<ArticleGDO> {

    List<ArticleGDO> getAllArticle(Long categoryId);

    List<ArticleGDO> getArticleListByTitle(String title);


    List<ArticleGDO> getArticleByUserId(Long userId);

    List<ArticleGDO> getArticleStarListByUser(Long userId, String type);


    List<ArticleFileDO> getArticleContentImages(Long articleId);

    Long addArticle(@Param("articleReq") ArticleGReq articleReq);

    Long updateArticle(@Param("articleGDO") ArticleGDO articleGDO);

    LikeStarDO getArtLikeAndStar(Long articleId, Long userId, String type);

    Long delArticleLikeStarStatus(Long articleId, Long userId, String type);

    Long getArticleLikeCount(Long articleId, String type);


    Long updateStatus(Long status, Long id);

    Long delArticle(Long id);

    Long upArticle(@Param("articleGDO") ArticleGDO articleGDO);


    Long delQuestions(Long id);

    Long updateQuestions(@Param("questionsResp") QuestionsResp questionsResp);


    Long getArticleLikeCountByUserId(Long articleId);

    Long insertArtLikeAndStar(Long articleId, Long userId, String type);

    Long getArticleCommentCount(Long articleId);

    List<ArticleGDO> getArticleByCommunityId(Long communityId);

    List<QuestionsResp> getQuestionByUserId(Long userId);

    List<ArticleGDO> getArticleById(Long id);
}
