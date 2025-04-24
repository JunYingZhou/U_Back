package top.continew.admin.news.model.resp;

import java.io.Serial;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.continew.starter.extension.crud.model.resp.BaseDetailResp;

/**
 * 题库管理详情信息
 *
 * @author RyanChow
 * @since 2025/04/23 23:58
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "题库管理详情信息")
public class QuestionRepoDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private Long repoId;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private Long categoryId;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private String repoContentOne;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private String repoContentTwo;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private String repoContentThree;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private String repoContentFour;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private String repoContentFive;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private String repoContentSix;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private String repoContentSeven;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private String repoContentEight;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private String repoContentNine;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private String repoContentTen;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private LocalDateTime modifyTime;
}