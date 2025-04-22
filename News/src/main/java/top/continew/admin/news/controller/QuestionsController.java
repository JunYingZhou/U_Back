package top.continew.admin.news.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import top.continew.admin.news.model.Req.QuestionsReq;
import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.controller.BaseController;
import top.continew.admin.news.model.query.QuestionsQuery;
import top.continew.admin.news.model.resp.QuestionsDetailResp;
import top.continew.admin.news.model.resp.QuestionsResp;
import top.continew.admin.news.service.QuestionsService;

/**
 * 社区问题管理 API
 *
 * @author RyanChow
 * @since 2025/04/03 00:34
 */
@Tag(name = "社区问题管理 API")
@RestController
@SaIgnore
@CrudRequestMapping(value = "/news/questions", api = {Api.PAGE, Api.GET, Api.ADD, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class QuestionsController extends BaseController<QuestionsService, QuestionsResp, QuestionsDetailResp, QuestionsQuery, QuestionsReq> {}