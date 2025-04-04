package top.continew.admin.news.service;

import top.continew.admin.news.model.Req.CommunityReq;
import top.continew.admin.news.model.VO.CommunityVO;
import top.continew.admin.news.model.query.CommunityQuery;
import top.continew.admin.news.model.resp.CommunityDetailResp;
import top.continew.admin.news.model.resp.CommunityResp;
import top.continew.starter.extension.crud.service.BaseService;

import java.util.List;


/**
 * 社区管理业务接口
 *
 * @author RyanChow
 * @since 2025/02/15 04:37
 */
public interface CommunityService extends BaseService<CommunityResp, CommunityDetailResp, CommunityQuery, CommunityReq> {

    CommunityVO getCommunityListByCommunityId(Long communityId);
}