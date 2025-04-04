package top.continew.admin.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import top.continew.admin.news.model.ArticleGDO;
import top.continew.admin.news.model.Req.CommunityReq;
import top.continew.admin.news.model.VO.CommunityVO;
import top.continew.admin.news.model.query.CommunityQuery;
import top.continew.admin.news.model.resp.CommunityDetailResp;
import top.continew.admin.news.model.resp.CommunityResp;
import top.continew.admin.news.service.CommunityService;
import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.controller.BaseController;

import java.util.List;


/**
 * 社区管理管理 API
 *
 * @author RyanChow
 * @since 2025/02/15 04:37
 */
@Tag(name = "社区管理管理 API")
@RestController
@CrudRequestMapping(value = "/News/community", api = {Api.PAGE, Api.GET, Api.ADD, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class CommunityController extends BaseController<CommunityService, CommunityResp, CommunityDetailResp, CommunityQuery, CommunityReq> {

    @Autowired
    private CommunityService communityService;

    @GetMapping("/list/{id}")
    public CommunityVO getArticleList(@PathVariable Long id) {
        return communityService.getCommunityListByCommunityId(id);
    }
}