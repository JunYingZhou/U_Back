package top.continew.admin.news.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.service.impl.BaseServiceImpl;
import top.continew.admin.news.mapper.QuestionRepoMapper;
import top.continew.admin.news.model.entity.QuestionRepoDO;
import top.continew.admin.news.model.query.QuestionRepoQuery;
import top.continew.admin.news.model.Req.QuestionRepoReq;
import top.continew.admin.news.model.resp.QuestionRepoDetailResp;
import top.continew.admin.news.model.resp.QuestionRepoResp;
import top.continew.admin.news.service.QuestionRepoService;

/**
 * 题库管理业务实现
 *
 * @author RyanChow
 * @since 2025/04/23 23:58
 */
@Service
@RequiredArgsConstructor
public class QuestionRepoServiceImpl extends BaseServiceImpl<QuestionRepoMapper, QuestionRepoDO, QuestionRepoResp, QuestionRepoDetailResp, QuestionRepoQuery, QuestionRepoReq> implements QuestionRepoService {}