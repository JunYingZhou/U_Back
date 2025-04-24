package top.continew.admin.news.model.Req;

import java.io.Serial;
import java.time.*;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import top.continew.starter.extension.crud.model.req.BaseReq;

/**
 * 创建或修改题库管理信息
 *
 * @author RyanChow
 * @since 2025/04/23 23:58
 */
@Data
@Schema(description = "创建或修改题库管理信息")
public class QuestionRepoReq extends BaseReq {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long repoId;
    /**
     *
     */
    @Schema(description = "")
    @NotNull(message = "不能为空")
    private Long categoryId;

    /**
     * 
     */
    @Schema(description = "")
    @NotBlank(message = "不能为空")
    @Length(max = 255, message = "长度不能超过 {max} 个字符")
    private String repoContentOne;

    /**
     * 
     */
    @Schema(description = "")
    @NotBlank(message = "不能为空")
    @Length(max = 255, message = "长度不能超过 {max} 个字符")
    private String repoContentTwo;

    /**
     * 
     */
    @Schema(description = "")
    @NotBlank(message = "不能为空")
    @Length(max = 255, message = "长度不能超过 {max} 个字符")
    private String repoContentThree;

    /**
     * 
     */
    @Schema(description = "")
    @NotBlank(message = "不能为空")
    @Length(max = 255, message = "长度不能超过 {max} 个字符")
    private String repoContentFour;

    /**
     * 
     */
    @Schema(description = "")
    @NotBlank(message = "不能为空")
    @Length(max = 255, message = "长度不能超过 {max} 个字符")
    private String repoContentFive;

    /**
     * 
     */
    @Schema(description = "")
    @NotBlank(message = "不能为空")
    @Length(max = 255, message = "长度不能超过 {max} 个字符")
    private String repoContentSix;

    /**
     * 
     */
    @Schema(description = "")
    @NotBlank(message = "不能为空")
    @Length(max = 255, message = "长度不能超过 {max} 个字符")
    private String repoContentSeven;

    /**
     * 
     */
    @Schema(description = "")
    @NotBlank(message = "不能为空")
    @Length(max = 255, message = "长度不能超过 {max} 个字符")
    private String repoContentEight;

    /**
     * 
     */
    @Schema(description = "")
    @NotBlank(message = "不能为空")
    @Length(max = 255, message = "长度不能超过 {max} 个字符")
    private String repoContentNine;

    /**
     * 
     */
    @Schema(description = "")
    @NotBlank(message = "不能为空")
    @Length(max = 255, message = "长度不能超过 {max} 个字符")
    private String repoContentTen;
}