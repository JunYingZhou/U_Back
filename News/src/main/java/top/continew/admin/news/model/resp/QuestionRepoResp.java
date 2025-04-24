package top.continew.admin.news.model.resp;

import java.io.Serial;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.extension.crud.model.resp.BaseResp;

/**
 * 题库管理信息
 *
 * @author RyanChow
 * @since 2025/04/23 23:58
 */
@Data
@Schema(description = "题库管理信息")
public class QuestionRepoResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long repoId;

    /**
     * 
     */
    @Schema(description = "")
    private Long categoryId;

    /**
     * 
     */
    @Schema(description = "")
    private String repoContentOne;

    /**
     * 
     */
    @Schema(description = "")
    private String repoContentTwo;

    /**
     * 
     */
    @Schema(description = "")
    private String repoContentThree;

    /**
     * 
     */
    @Schema(description = "")
    private String repoContentFour;

    /**
     * 
     */
    @Schema(description = "")
    private String repoContentFive;

    /**
     * 
     */
    @Schema(description = "")
    private String repoContentSix;

    /**
     * 
     */
    @Schema(description = "")
    private String repoContentSeven;

    /**
     * 
     */
    @Schema(description = "")
    private String repoContentEight;

    /**
     * 
     */
    @Schema(description = "")
    private String repoContentNine;

    /**
     * 
     */
    @Schema(description = "")
    private String repoContentTen;

    /**
     * 
     */
    @Schema(description = "")
    private LocalDateTime modifyTime;
}