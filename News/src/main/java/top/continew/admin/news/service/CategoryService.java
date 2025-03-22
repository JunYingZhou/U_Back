package top.continew.admin.news.service;

import top.continew.admin.news.model.Req.CategoryReq;
import top.continew.admin.news.model.query.CategoryQuery;
import top.continew.admin.news.model.resp.CategoryDetailResp;
import top.continew.admin.news.model.resp.CategoryResp;
import top.continew.starter.extension.crud.service.BaseService;


/**
 * 文章种类业务接口
 *
 * @author RyanChow
 * @since 2025/02/14 00:54
 */
public interface CategoryService extends BaseService<CategoryResp, CategoryDetailResp, CategoryQuery, CategoryReq> {}