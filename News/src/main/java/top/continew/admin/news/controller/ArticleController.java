package top.continew.admin.news.controller;

import top.continew.admin.news.model.Req.ArticleReq;
import top.continew.admin.news.service.ArticleService;
import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.controller.BaseController;
import top.continew.admin.news.model.query.ArticleQuery;
import top.continew.admin.news.model.resp.ArticleDetailResp;
import top.continew.admin.news.model.resp.ArticleResp;

/**
 * 文章管理管理 API
 *
 * @author RyanChow
 * @since 2025/02/16 03:46
 */
@Tag(name = "文章管理管理 API")
@RestController
@CrudRequestMapping(value = "/news/article", api = {Api.PAGE, Api.GET, Api.ADD, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class ArticleController extends BaseController<ArticleService, ArticleResp, ArticleDetailResp, ArticleQuery, ArticleReq> {}