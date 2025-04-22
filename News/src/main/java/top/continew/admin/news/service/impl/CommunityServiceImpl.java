package top.continew.admin.news.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.admin.news.mapper.ArticleGMapper;
import top.continew.admin.news.mapper.ArticleMapper;
import top.continew.admin.news.mapper.CommunityMapper;
import top.continew.admin.news.mapper.QuestionsMapper;
import top.continew.admin.news.model.ArticleGDO;
import top.continew.admin.news.model.Req.CommunityReq;
import top.continew.admin.news.model.VO.CommunityVO;
import top.continew.admin.news.model.entity.CommunityDO;
import top.continew.admin.news.model.query.CommunityQuery;
import top.continew.admin.news.model.resp.ArticleResp;
import top.continew.admin.news.model.resp.CommunityDetailResp;
import top.continew.admin.news.model.resp.CommunityResp;
import top.continew.admin.news.model.resp.QuestionsResp;
import top.continew.admin.news.service.CommunityService;
import top.continew.starter.extension.crud.service.impl.BaseServiceImpl;

import java.util.List;

/**
 * 社区管理业务实现
 *
 * @author RyanChow
 * @since 2025/02/15 04:37
 */
@Service
@RequiredArgsConstructor
public class CommunityServiceImpl extends BaseServiceImpl<CommunityMapper, CommunityDO, CommunityResp, CommunityDetailResp, CommunityQuery, CommunityReq> implements CommunityService {

    private final CommunityMapper baseMapper;
    private final ArticleGMapper articleMapper;
    private final QuestionsMapper questionsMapper;

    @Override
    public CommunityVO getCommunityListByCommunityId(Long communityId) {
        // 获取社区列表
        CommunityVO communityData = baseMapper.getCommunityListByCommunityId(communityId);
        // 获取文章列表
        List<ArticleGDO> articleList = articleMapper.getArticleByCommunityId(communityId);
        // 获取问题列表
        List<QuestionsResp> questionsList = questionsMapper.getQuestionsListByCommunityId(communityId);

        // 将文章列表和问题列表添加到社区列表中
        communityData.setArticleList(articleList);
        communityData.setQuestionsRespList(questionsList);
        return communityData;
    }
}