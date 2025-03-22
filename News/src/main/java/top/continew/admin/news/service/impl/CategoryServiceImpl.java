package top.continew.admin.news.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.admin.news.mapper.CategoryMapper;
import top.continew.admin.news.model.Req.CategoryReq;
import top.continew.admin.news.model.entity.CategoryDO;
import top.continew.admin.news.model.query.CategoryQuery;
import top.continew.admin.news.model.resp.CategoryDetailResp;
import top.continew.admin.news.model.resp.CategoryResp;
import top.continew.admin.news.service.CategoryService;
import top.continew.starter.extension.crud.service.impl.BaseServiceImpl;

/**
 * 文章种类业务实现
 *
 * @author RyanChow
 * @since 2025/02/14 00:54
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends BaseServiceImpl<CategoryMapper, CategoryDO, CategoryResp, CategoryDetailResp, CategoryQuery, CategoryReq> implements CategoryService {}