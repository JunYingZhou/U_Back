package top.continew.admin.news.controller;

import top.continew.admin.news.model.Req.CategoryReq;
import top.continew.admin.news.model.query.CategoryQuery;
import top.continew.admin.news.model.resp.CategoryDetailResp;
import top.continew.admin.news.model.resp.CategoryResp;
import top.continew.admin.news.service.CategoryService;
import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.controller.BaseController;


/**
 * 文章种类管理 API
 *
 * @author RyanChow
 * @since 2025/02/14 00:54
 */
@Tag(name = "文章种类管理 API")
@RestController
@CrudRequestMapping(value = "/generator/category", api = {Api.PAGE, Api.GET, Api.ADD, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class CategoryController extends BaseController<CategoryService, CategoryResp, CategoryDetailResp, CategoryQuery, CategoryReq> {}