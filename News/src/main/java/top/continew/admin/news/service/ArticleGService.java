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

import top.continew.admin.news.model.ArticleFileDO;
import top.continew.admin.news.model.ArticleGDO;
import top.continew.admin.news.model.LikeStarDO;
import top.continew.admin.news.model.Req.ArticleGReq;
import top.continew.admin.news.model.resp.QuestionsResp;

import java.util.List;

public interface ArticleGService {

    List<ArticleGDO> getAllArticle(Long id);


    List<ArticleGDO> getArticleById(Long id);

    List<ArticleGDO> getArticleListByTitle(String title);

    List<ArticleGDO> getArticleStarListByUser(Long userId, String type);


    List<ArticleGDO> getArticleByUserId(Long id);

    List<ArticleFileDO> getArticleContentImages(Long articleId);

    Long addArticle(ArticleGReq articleDO);

    Long updateStatus(Long status, Long id);

    Long upArticle(ArticleGDO articleGReq);
    Long updateQuestions(QuestionsResp questionsResp);


    Long delArticle(Long id);

    Long delQuestions(Long id);


    Long getArticleLikeCountByUserId(Long userId);

    Long updateArticle(Long articleId, String imageBase64);

    LikeStarDO getArticleLikeStarStatus(String s, String s1, String type);

    Long delArticleLikeStarStatus(String s, String s1, String type);

    Long getArticleLikeStarStatusCount(Long articleId, String type);

    Long getArticleCommentCount(Long articleId);


    List<QuestionsResp> getQuestionByUserId(Long userId);



    Boolean insertArticleLikeStarStatus(String s, String s1, String type);
}
