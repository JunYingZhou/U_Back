package top.continew.admin.news.service;

import top.continew.admin.news.model.Req.ArtFileReq;
import top.continew.starter.extension.crud.model.query.SortQuery;
import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.news.model.query.ArtFileQuery;
import top.continew.admin.news.model.resp.ArtFileResp;
import top.continew.admin.news.model.resp.ArtFileDetailResp;
import top.continew.admin.news.model.resp.ArtFileResp;

import java.util.List;

/**
 * 文章文件业务接口
 *
 * @author RyanChow
 * @since 2025/03/18 21:43
 */
public interface ArtFileService extends BaseService<ArtFileResp, ArtFileDetailResp, ArtFileQuery, ArtFileReq> {

//    List<ArtFileResp> getArtFileByArticleId();

    List<ArtFileResp> getArtFile(Long articleId);

}