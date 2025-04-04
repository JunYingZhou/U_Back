package top.continew.admin.news.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.admin.news.model.Req.QuestionsReq;
import top.continew.starter.extension.crud.service.impl.BaseServiceImpl;
import top.continew.admin.news.mapper.QuestionsMapper;
import top.continew.admin.news.model.entity.QuestionsDO;
import top.continew.admin.news.model.query.QuestionsQuery;
import top.continew.admin.news.model.resp.QuestionsDetailResp;
import top.continew.admin.news.model.resp.QuestionsResp;
import top.continew.admin.news.service.QuestionsService;

/**
 * 社区问题业务实现
 *
 * @author RyanChow
 * @since 2025/04/03 00:34
 */
@Service
@RequiredArgsConstructor
public class QuestionsServiceImpl extends BaseServiceImpl<QuestionsMapper, QuestionsDO, QuestionsResp, QuestionsDetailResp, QuestionsQuery, QuestionsReq> implements QuestionsService {}