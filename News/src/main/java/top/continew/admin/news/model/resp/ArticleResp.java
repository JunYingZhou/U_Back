package top.continew.admin.news.model.resp;

import java.io.Serial;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.extension.crud.model.resp.BaseResp;

/**
 * 文章管理信息
 *
 * @author RyanChow
 * @since 2025/02/16 03:46
 */
@Data
@Schema(description = "文章管理信息")
public class ArticleResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 文章标题
     */
    @Schema(description = "文章标题")
    private String articleTitle;

    /**
     * 文章主要内容
     */
    @Schema(description = "文章主要内容")
    private String articleMain;

    /**
     * 文章封面地址
     */
    @Schema(description = "文章封面地址")
    private String articleCoverUrl;

    /**
     * 文章摘要
     */
    @Schema(description = "文章摘要")
    private String articleAbstract;

    /**
     * 文章收藏数
     */
    @Schema(description = "文章收藏数")
    private Integer articleStarCount;

    /**
     * 1-审核中 2-审核通过 3-不通过
     */
    @Schema(description = "1-审核中 2-审核通过 3-不通过")
    private Long status;
}