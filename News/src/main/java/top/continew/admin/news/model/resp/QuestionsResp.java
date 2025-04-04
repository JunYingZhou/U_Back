package top.continew.admin.news.model.resp;

import java.io.Serial;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.extension.crud.model.resp.BaseResp;

/**
 * 社区问题信息
 *
 * @author RyanChow
 * @since 2025/04/03 00:34
 */
@Data
@Schema(description = "社区问题信息")
public class QuestionsResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 问题标题
     */
    @Schema(description = "问题标题")
    private String questionsTitle;

    /**
     * 问题内容
     */
    @Schema(description = "问题内容")
    private String questionsContent;

    /**
     * 问题状态 0-未回答 1-已回答
     */
    @Schema(description = "问题状态 0-未回答 1-已回答")
    private Integer questionsState;

    /**
     * 问题点赞数量
     */
    @Schema(description = "问题点赞数量")
    private Integer questionsLikeCount;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private Integer userId;

    /**
     * 0-未 1-已
     */
    @Schema(description = "0-未 1-已")
    private Integer isDel;

    /**
     * 
     */
    @Schema(description = "")
    private LocalDateTime modifyTime;

    /**
     * 
     */
    @Schema(description = "")
    private Long updateUser;

    /**
     * 
     */
    @Schema(description = "")
    private LocalDateTime updateTime;

    /**
     * 社区id
     */
    @Schema(description = "社区id")
    private Long communityId;
}