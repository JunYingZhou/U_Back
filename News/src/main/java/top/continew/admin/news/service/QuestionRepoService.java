package top.continew.admin.news.service;

import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.news.model.query.QuestionRepoQuery;
import top.continew.admin.news.model.Req.QuestionRepoReq;
import top.continew.admin.news.model.resp.QuestionRepoDetailResp;
import top.continew.admin.news.model.resp.QuestionRepoResp;

/**
 * 题库管理业务接口
 *
 * @author RyanChow
 * @since 2025/04/23 23:58
 */
public interface QuestionRepoService extends BaseService<QuestionRepoResp, QuestionRepoDetailResp, QuestionRepoQuery, QuestionRepoReq> {}