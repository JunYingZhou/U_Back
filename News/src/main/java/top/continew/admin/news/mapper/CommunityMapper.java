package top.continew.admin.news.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.continew.admin.news.model.VO.CommunityVO;
import top.continew.admin.news.model.entity.CommunityDO;
import top.continew.admin.news.model.resp.CommunityResp;
import top.continew.starter.data.mp.base.BaseMapper;

import java.util.List;


/**
* 社区管理 Mapper
*
* @author RyanChow
* @since 2025/02/15 04:37
*/
@Mapper
public interface CommunityMapper extends BaseMapper<CommunityDO> {
    CommunityVO getCommunityListByCommunityId(Long communityId);
}