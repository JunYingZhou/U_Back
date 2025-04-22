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
import top.continew.admin.news.model.ArticleGDO;
import top.continew.admin.news.model.LikeStarDO;
import top.continew.admin.news.model.Req.ArticleGReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.continew.admin.news.mapper.ArticleGMapper;
import top.continew.admin.news.model.Req.ArticleReq;
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
    public Long addArticle(ArticleGReq articleDO) {
        return articleMapper.addArticle(articleDO);
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
    public Long getArticleLikeStarStatusCount(Long articleId, String type) {
        return articleMapper.getArticleLikeCount(articleId, "like");
    }

    @Override
    public Long getArticleCommentCount(Long articleId) {
        return articleMapper.getArticleCommentCount(articleId);
    }

    @Override
    public Boolean insertArticleLikeStarStatus(String articleId, String userId, String type) {
        Long artLikeAndStar = articleMapper.insertArtLikeAndStar(Long.parseLong(articleId), Long.parseLong(userId), type);
        return artLikeAndStar > 0;
    }


}
