package top.continew.admin.news.model.resp;

import java.io.Serial;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.continew.starter.extension.crud.model.resp.BaseDetailResp;

/**
 * 文章管理详情信息
 *
 * @author RyanChow
 * @since 2025/02/16 03:46
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "文章管理详情信息")
public class ArticleDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 文章标题
     */
    @Schema(description = "文章标题")
    @ExcelProperty(value = "文章标题")
    private String articleTitle;

    /**
     * 文章主要内容
     */
    @Schema(description = "文章主要内容")
    @ExcelProperty(value = "文章主要内容")
    private String articleMain;

    /**
     * 分类id
     */
    @Schema(description = "分类id")
    @ExcelProperty(value = "分类id")
    private Integer categoryId;

    /**
     * 文章封面地址
     */
    @Schema(description = "文章封面地址")
    @ExcelProperty(value = "文章封面地址")
    private String articleCoverUrl;

    /**
     * 文章摘要
     */
    @Schema(description = "文章摘要")
    @ExcelProperty(value = "文章摘要")
    private String articleAbstract;

    /**
     * 文章收藏数
     */
    @Schema(description = "文章收藏数")
    @ExcelProperty(value = "文章收藏数")
    private Integer articleStarCount;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @ExcelProperty(value = "用户id")
    private Long userId;

    /**
     * 是否官方推文 0-不是 1-是

     */
    @Schema(description = "是否官方推文 0-不是 1-是 ")
    @ExcelProperty(value = "是否官方推文 0-不是 1-是 ")
    private Integer isOfficial;

    /**
     * 是否匿名
     */
    @Schema(description = "是否匿名")
    @ExcelProperty(value = "是否匿名")
    private Integer isNoname;

    /**
     * 1-审核中 2-审核通过 3-不通过
     */
    @Schema(description = "1-审核中 2-审核通过 3-不通过")
    @ExcelProperty(value = "1-审核中 2-审核通过 3-不通过")
    private Long status;

    /**
     * 0-不是社区文章 1-社区文章
     */
    @Schema(description = "0-不是社区文章 1-社区文章")
    @ExcelProperty(value = "0-不是社区文章 1-社区文章")
    private Long isCommunity;

    /**
     * 社区id
     */
    @Schema(description = "社区id")
    @ExcelProperty(value = "社区id")
    private Integer communityId;
}