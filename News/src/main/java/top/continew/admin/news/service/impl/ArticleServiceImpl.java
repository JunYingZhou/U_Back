package top.continew.admin.news.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.admin.news.model.Req.ArticleReq;
import top.continew.starter.extension.crud.service.impl.BaseServiceImpl;
import top.continew.admin.news.mapper.ArticleMapper;
import top.continew.admin.news.model.entity.ArticleDO;
import top.continew.admin.news.model.query.ArticleQuery;
import top.continew.admin.news.model.resp.ArticleDetailResp;
import top.continew.admin.news.model.resp.ArticleResp;
import top.continew.admin.news.service.ArticleService;

/**
 * 文章管理业务实现
 *
 * @author RyanChow
 * @since 2025/02/16 03:46
 */
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl extends BaseServiceImpl<ArticleMapper, ArticleDO, ArticleResp, ArticleDetailResp, ArticleQuery, ArticleReq> implements ArticleService {}