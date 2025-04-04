package top.continew.admin.news.model.resp;

import java.io.Serial;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.continew.starter.extension.crud.model.resp.BaseDetailResp;

/**
 * 社区问题详情信息
 *
 * @author RyanChow
 * @since 2025/04/03 00:34
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "社区问题详情信息")
public class QuestionsDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 问题标题
     */
    @Schema(description = "问题标题")
    @ExcelProperty(value = "问题标题")
    private String questionsTitle;

    /**
     * 问题内容
     */
    @Schema(description = "问题内容")
    @ExcelProperty(value = "问题内容")
    private String questionsContent;

    /**
     * 问题状态 0-未回答 1-已回答
     */
    @Schema(description = "问题状态 0-未回答 1-已回答")
    @ExcelProperty(value = "问题状态 0-未回答 1-已回答")
    private Integer questionsState;

    /**
     * 问题点赞数量
     */
    @Schema(description = "问题点赞数量")
    @ExcelProperty(value = "问题点赞数量")
    private Integer questionsLikeCount;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @ExcelProperty(value = "用户id")
    private Integer userId;

    /**
     * 0-未 1-已
     */
    @Schema(description = "0-未 1-已")
    @ExcelProperty(value = "0-未 1-已")
    private Integer isDel;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private LocalDateTime modifyTime;

    /**
     * 社区id
     */
    @Schema(description = "社区id")
    @ExcelProperty(value = "社区id")
    private Long communityId;
}