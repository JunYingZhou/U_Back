package top.continew.admin.news.service;

import top.continew.admin.news.model.Req.QuestionsReq;
import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.news.model.query.QuestionsQuery;
import top.continew.admin.news.model.resp.QuestionsDetailResp;
import top.continew.admin.news.model.resp.QuestionsResp;

/**
 * 社区问题业务接口
 *
 * @author RyanChow
 * @since 2025/04/03 00:34
 */
public interface QuestionsService extends BaseService<QuestionsResp, QuestionsDetailResp, QuestionsQuery, QuestionsReq> {}