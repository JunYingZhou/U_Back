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
import top.continew.admin.news.model.ArticleFileDO;
import top.continew.admin.news.model.ArticleGDO;
import top.continew.admin.news.model.LikeStarDO;
import top.continew.admin.news.model.Req.ArticleGReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.continew.admin.news.mapper.ArticleGMapper;
import top.continew.admin.news.model.Req.ArticleReq;
import top.continew.admin.news.model.resp.QuestionsResp;
import top.continew.admin.news.service.ArticleGService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleGServiceImpl implements ArticleGService {

    // 设置常量名
    private static final String CACHE_NAME = "articleCache";

    private final ArticleGMapper articleMapper;

    @Override
    public List<ArticleGDO> getAllArticle(Long id) {
        List<ArticleGDO> articleDOList = articleMapper.getAllArticle(id);
        System.out.println("articleDOList = " + articleDOList);
        return articleDOList;
    }

    @Override
    public List<ArticleGDO> getArticleById(Long id) {
        return articleMapper.getArticleById(id);
    }

    @Override
    public List<ArticleGDO> getArticleListByTitle(String title) {
        return articleMapper.getArticleListByTitle(title);
    }

    @Override
    public List<ArticleGDO> getArticleStarListByUser(Long userId, String type) {
        return articleMapper.getArticleStarListByUser(userId, type);
    }

    @Override
    public List<ArticleGDO> getArticleByUserId(Long id) {




        return articleMapper.getArticleByUserId(id);
    }

    @Override
    public List<ArticleFileDO> getArticleContentImages(Long articleId) {
        return articleMapper.getArticleContentImages(articleId);
    }

    @Override
    public Long addArticle(ArticleGReq articleDO) {
        return articleMapper.addArticle(articleDO);
    }

    @Override
    public Long updateStatus(Long status, Long id) {
        return articleMapper.updateStatus(status, id);
    }

    @Override
    public Long upArticle(ArticleGDO articleGReq) {
        return articleMapper.upArticle(articleGReq);
    }

    @Override
    public Long updateQuestions(QuestionsResp questionsResp) {
        return articleMapper.updateQuestions(questionsResp);
    }


    @Override
    public Long delArticle(Long id) {
        return articleMapper.delArticle(id);
    }

    @Override
    public Long delQuestions(Long id) {
        return articleMapper.delQuestions(id);
    }

    @Override
    public Long getArticleLikeCountByUserId(Long userId) {
        return articleMapper.getArticleLikeCountByUserId(userId);
    }

    @Override
    public Long updateArticle(Long articleId, String imageBase64) {
        ArticleGDO articleGDO = new ArticleGDO();
        articleGDO.setId(articleId);
        articleGDO.setArticleCoverUrl(imageBase64);
        System.out.println("articleGDO = " + articleGDO);
        return articleMapper.updateArticle(articleGDO);
    }

    @Override
    public LikeStarDO getArticleLikeStarStatus(String articleId, String userId, String type) {
        return articleMapper.getArtLikeAndStar(Long.parseLong(articleId), Long.parseLong(userId), type);
    }

    @Override
    public Long delArticleLikeStarStatus(String s, String s1, String type) {
        return articleMapper.delArticleLikeStarStatus(Long.parseLong(s), Long.parseLong(s1), type);
    }

    @Override
    public Long getArticleLikeStarStatusCount(Long articleId, String type) {
        return articleMapper.getArticleLikeCount(articleId, "like");
    }

    @Override
    public Long getArticleCommentCount(Long articleId) {
        return articleMapper.getArticleCommentCount(articleId);
    }

    @Override
    public List<QuestionsResp> getQuestionByUserId(Long userId) {
        return articleMapper.getQuestionByUserId(userId);
    }

    @Override
    public Boolean insertArticleLikeStarStatus(String articleId, String userId, String type) {
        Long artLikeAndStar = articleMapper.insertArtLikeAndStar(Long.parseLong(articleId), Long.parseLong(userId), type);
        return artLikeAndStar > 0;
    }


}
