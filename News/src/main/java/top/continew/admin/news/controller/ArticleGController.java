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

package top.continew.admin.news.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.continew.admin.news.mapper.AntiArtFileMapper;
import top.continew.admin.news.model.ArticleGDO;
import top.continew.admin.news.model.LikeStarDO;
import top.continew.admin.news.model.Req.ArtFileReq;
import top.continew.admin.news.model.Req.ArticleGReq;
import top.continew.admin.news.service.ArtFileService;
import top.continew.admin.news.service.ArticleGService;
import top.continew.starter.core.constant.StringConstants;
import top.continew.starter.core.util.validate.CheckUtils;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/anti/article")
public class ArticleGController {

    private final ArticleGService articleService;
    private final ArtFileService artFileService;
    @Value("${avatar.support-suffix}")
    private String[] avatarSupportSuffix;

    @GetMapping("/list/{id}")
    public List<ArticleGDO> getArticleList(@PathVariable Long id) {
        return articleService.getAllArticle(id);
    }


    @SaIgnore
    @PostMapping("/addArticle")
    public String addArticle(@RequestBody ArticleGReq article) {
        System.out.println("文章"+article);
        Long l = articleService.addArticle(article);
        return l+"."+article.getId();
    }


    @PostMapping("/coverImageUpload/{articleId}")
    public void updateArticleImage(@PathVariable Long articleId, MultipartFile coverImage) throws IOException {
        String avatarImageType = FileNameUtil.extName(coverImage.getOriginalFilename());
        CheckUtils.throwIf(!StrUtil.equalsAnyIgnoreCase(avatarImageType, avatarSupportSuffix), "仅支持 {} 格式的图片", String
                .join(StringConstants.CHINESE_COMMA, avatarSupportSuffix));
        // 更新用户头像
        String base64 = ImgUtil.toBase64DataUri(ImgUtil.scale(ImgUtil.toImage(coverImage
                .getBytes()), 100, 100, null), avatarImageType);
        articleService.updateArticle(articleId, base64);
    }

    @PostMapping("/contentImagesUpload/{articleId}")
    public void addArticle1(@PathVariable Long articleId, MultipartFile contentImage) throws IOException {
        String avatarImageType = FileNameUtil.extName(contentImage.getOriginalFilename());
        CheckUtils.throwIf(!StrUtil.equalsAnyIgnoreCase(avatarImageType, avatarSupportSuffix), "仅支持 {} 格式的图片", String
                .join(StringConstants.CHINESE_COMMA, avatarSupportSuffix));
        // 更新用户头像
        String base64 = ImgUtil.toBase64DataUri(ImgUtil.scale(ImgUtil.toImage(contentImage
                .getBytes()), 100, 100, null), avatarImageType);
        ArtFileReq artFileReq = new ArtFileReq();
        artFileReq.setArtFileUrl(base64);
        artFileReq.setArticleId(articleId);
        artFileService.add(artFileReq);
    }

    @GetMapping("/getArticleLikeStarStatus/{queryIds}/{type}")
    public LikeStarDO getArticleLikeStarStatus(@PathVariable String queryIds, @PathVariable String type) {
        String[] tempArr = queryIds.split(",");
        return articleService.getArticleLikeStarStatus(tempArr[0], tempArr[1], type);
    }

    @GetMapping("/insertArticleLikeStarStatus/{queryIds}/{type}")
    public Boolean insertArticleLikeStarStatus(@PathVariable String queryIds, @PathVariable String type) {
        String[] tempArr = queryIds.split(",");
        return articleService.insertArticleLikeStarStatus(tempArr[0], tempArr[1], type);
    }
}
