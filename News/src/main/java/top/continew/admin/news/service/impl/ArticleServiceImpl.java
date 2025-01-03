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
import top.continew.starter.cache.redisson.util.RedisUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.continew.admin.news.mapper.ArticleMapper;
import top.continew.admin.news.model.ArticleDO;
import top.continew.admin.news.service.ArticleService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    // 设置常量名
    private static final String CACHE_NAME = "articleCache";

    private final ArticleMapper articleMapper;

    @Override
    public List<ArticleDO> getAllArticle() {
        List<ArticleDO> articleDOList = articleMapper.getAllArticle();
        // 是否需要存入缓存
//        List<ArticleDO> cacheArticleDOList = RedisUtils.get(CACHE_NAME);
//        // 用lambda表达式判断是否为空
//        if (cacheArticleDOList == null) {
//            RedisUtils.setList(CACHE_NAME,  articleDOList);
//        }
        return articleDOList;
    }
}
