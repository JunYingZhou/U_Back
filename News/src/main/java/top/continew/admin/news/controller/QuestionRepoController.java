package top.continew.admin.news.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.controller.BaseController;
import top.continew.admin.news.model.query.QuestionRepoQuery;
import top.continew.admin.news.model.Req.QuestionRepoReq;
import top.continew.admin.news.model.resp.QuestionRepoDetailResp;
import top.continew.admin.news.model.resp.QuestionRepoResp;
import top.continew.admin.news.service.QuestionRepoService;

/**
 * 题库管理管理 API
 *
 * @author RyanChow
 * @since 2025/04/23 23:58
 */
@Tag(name = "题库管理管理 API")
@RestController
@CrudRequestMapping(value = "/repo/questionRepo", api = {Api.PAGE, Api.GET, Api.ADD, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class QuestionRepoController extends BaseController<QuestionRepoService, QuestionRepoResp, QuestionRepoDetailResp, QuestionRepoQuery, QuestionRepoReq> {}