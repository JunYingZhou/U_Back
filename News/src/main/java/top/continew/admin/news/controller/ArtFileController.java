package top.continew.admin.news.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.controller.BaseController;
import top.continew.admin.news.model.query.ArtFileQuery;
import top.continew.admin.news.model.Req.ArtFileReq;
import top.continew.admin.news.model.resp.ArtFileDetailResp;
import top.continew.admin.news.model.resp.ArtFileResp;
import top.continew.admin.news.service.ArtFileService;

import java.util.List;

/**
 * 文章文件管理 API
 *
 * @author RyanChow
 * @since 2025/03/18 21:43
 */
@Tag(name = "文章文件管理 API")
@RestController
@CrudRequestMapping(value = "/news/artFile", api = {Api.PAGE, Api.GET, Api.ADD, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class ArtFileController extends BaseController<ArtFileService, ArtFileResp, ArtFileDetailResp, ArtFileQuery, ArtFileReq> {

    private final ArtFileService service;

    public ArtFileController(ArtFileService service) {
        this.service = service;
    }

    @GetMapping("/getArtFile/{articleId}")
    public List<ArtFileResp> getArtFile(@PathVariable Long articleId) {
        return this.service.getArtFile(articleId);
    }
}