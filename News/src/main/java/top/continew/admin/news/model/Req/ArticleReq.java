package top.continew.admin.news.model.Req;

import java.io.Serial;
import java.time.*;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import top.continew.starter.extension.crud.model.req.BaseReq;

/**
 * 创建或修改文章管理信息
 *
 * @author RyanChow
 * @since 2025/02/16 03:46
 */
@Data
@Schema(description = "创建或修改文章管理信息")
public class ArticleReq extends BaseReq {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 文章标题
     */
    @Schema(description = "文章标题")
    @NotBlank(message = "文章标题不能为空")
    @Length(max = 255, message = "文章标题长度不能超过 {max} 个字符")
    private String articleTitle;

    /**
     * 文章主要内容
     */
    @Schema(description = "文章主要内容")
    @NotBlank(message = "文章主要内容不能为空")
    @Length(max = 2147483647, message = "文章主要内容长度不能超过 {max} 个字符")
    private String articleMain;

    /**
     * 分类id
     */
    @Schema(description = "分类id")
    @NotNull(message = "分类id不能为空")
    private Integer categoryId;

    /**
     * 文章封面地址
     */
    @Schema(description = "文章封面地址")
    @NotBlank(message = "文章封面地址不能为空")
    @Length(max = 255, message = "文章封面地址长度不能超过 {max} 个字符")
    private String articleCoverUrl;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @NotNull(message = "用户id不能为空")
    private Long userId;

    /**
     * 是否官方推文 0-不是 1-是

     */
    @Schema(description = "是否官方推文 0-不是 1-是 ")
    @NotNull(message = "是否官方推文 0-不是 1-是 不能为空")
    private Integer isOfficial;

    /**
     * 是否匿名
     */
    @Schema(description = "是否匿名")
    private Integer isNoname;

    /**
     * 0-不是社区文章 1-社区文章
     */
    @Schema(description = "0-不是社区文章 1-社区文章")
    @NotNull(message = "0-不是社区文章 1-社区文章不能为空")
    private Long isCommunity;

    /**
     * 社区id
     */
    @Schema(description = "社区id")
    @NotNull(message = "社区id不能为空")
    private Integer communityId;
}