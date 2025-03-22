package top.continew.admin.news.service;

import top.continew.admin.news.model.Req.ArticleReq;
import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.news.model.query.ArticleQuery;

import top.continew.admin.news.model.resp.ArticleDetailResp;
import top.continew.admin.news.model.resp.ArticleResp;

/**
 * 文章管理业务接口
 *
 * @author RyanChow
 * @since 2025/02/16 03:46
 */
public interface ArticleService extends BaseService<ArticleResp, ArticleDetailResp, ArticleQuery, ArticleReq> {}