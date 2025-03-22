package top.continew.admin.news.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.admin.news.mapper.CommunityMapper;
import top.continew.admin.news.model.Req.CommunityReq;
import top.continew.admin.news.model.entity.CommunityDO;
import top.continew.admin.news.model.query.CommunityQuery;
import top.continew.admin.news.model.resp.CommunityDetailResp;
import top.continew.admin.news.model.resp.CommunityResp;
import top.continew.admin.news.service.CommunityService;
import top.continew.starter.extension.crud.service.impl.BaseServiceImpl;

/**
 * 社区管理业务实现
 *
 * @author RyanChow
 * @since 2025/02/15 04:37
 */
@Service
@RequiredArgsConstructor
public class CommunityServiceImpl extends BaseServiceImpl<CommunityMapper, CommunityDO, CommunityResp, CommunityDetailResp, CommunityQuery, CommunityReq> implements CommunityService {}