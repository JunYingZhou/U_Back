package top.continew.admin.news.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.continew.admin.news.model.resp.QuestionsResp;
import top.continew.starter.data.mp.base.BaseMapper;
import top.continew.admin.news.model.entity.QuestionsDO;

import java.util.List;

/**
* 社区问题 Mapper
*
* @author RyanChow
* @since 2025/04/03 00:34
*/
@Mapper
public interface QuestionsMapper extends BaseMapper<QuestionsDO> {
    List<QuestionsResp> getQuestionsListByCommunityId(Long communityId);
}