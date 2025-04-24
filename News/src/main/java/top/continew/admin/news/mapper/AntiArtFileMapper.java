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
import org.apache.ibatis.annotations.Select;

import top.continew.admin.news.model.resp.ArtFileResp;
import top.continew.starter.data.mp.base.BaseMapper;

import java.util.List;

@Mapper
public interface AntiArtFileMapper extends BaseMapper<ArtFileResp> {

    @Select("select * from af_art_file where article_id = #{articleId}")
    List<ArtFileResp> getArtFileByArticleId(@Param("articleId") Long articleId);

    @Select("select count(*) from af_art_file where article_id = #{articleId}")
    Long checkArtFile(@Param("articleId") Long articleId);
    @Select("delete from af_art_file where article_id = #{articleId}")
    Long delArtFile(@Param("articleId") Long articleId);

}
