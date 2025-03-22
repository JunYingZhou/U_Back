package top.continew.admin.news.model.query;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;
import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;


/**
 * 文章管理查询条件
 *
 * @author RyanChow
 * @since 2025/02/16 03:46
 */
@Data
@Schema(description = "文章管理查询条件")
public class ArticleQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 文章标题
     */
    @Schema(description = "文章标题")
    @Query(type = QueryType.EQ)
    private String articleTitle;

    /**
     * 分类id
     */
    @Schema(description = "分类id")
    @Query(type = QueryType.EQ)
    private Integer categoryId;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @Query(type = QueryType.EQ)
    private Long userId;

    /**
     * 是否官方推文 0-不是 1-是

     */
    @Schema(description = "是否官方推文 0-不是 1-是 ")
    @Query(type = QueryType.EQ)
    private Integer isOfficial;

    /**
     * 是否匿名
     */
    @Schema(description = "是否匿名")
    @Query(type = QueryType.EQ)
    private Integer isNoname;

    /**
     * 1-审核中 2-审核通过 3-不通过
     */
    @Schema(description = "1-审核中 2-审核通过 3-不通过")
    @Query(type = QueryType.EQ)
    private Long status;

    /**
     * 0-不是社区文章 1-社区文章
     */
    @Schema(description = "0-不是社区文章 1-社区文章")
    @Query(type = QueryType.EQ)
    private Long isCommunity;

    /**
     * 社区id
     */
    @Schema(description = "社区id")
    @Query(type = QueryType.EQ)
    private Integer communityId;
}