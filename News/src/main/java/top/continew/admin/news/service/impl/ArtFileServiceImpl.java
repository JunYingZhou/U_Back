package top.continew.admin.news.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.service.impl.BaseServiceImpl;
import top.continew.admin.news.mapper.AntiArtFileMapper;
import top.continew.admin.news.mapper.ArtFileMapper;
import top.continew.admin.news.model.entity.ArtFileDO;
import top.continew.admin.news.model.query.ArtFileQuery;
import top.continew.admin.news.model.Req.ArtFileReq;
import top.continew.admin.news.model.resp.ArtFileDetailResp;
import top.continew.admin.news.model.resp.ArtFileResp;
import top.continew.admin.news.service.ArtFileService;

import java.util.List;

/**
 * 文章文件业务实现
 *
 * @author RyanChow
 * @since 2025/03/18 21:43
 */
@Service
@RequiredArgsConstructor
public class ArtFileServiceImpl extends BaseServiceImpl<ArtFileMapper, ArtFileDO, ArtFileResp, ArtFileDetailResp, ArtFileQuery, ArtFileReq> implements ArtFileService {

    private final AntiArtFileMapper mapper;


    @Override
    public List<ArtFileResp> getArtFile(Long articleId) {
        return mapper.getArtFileByArticleId(articleId);
    }
}