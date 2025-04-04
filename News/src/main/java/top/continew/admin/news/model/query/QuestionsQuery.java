package top.continew.admin.news.model.query;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

/**
 * 社区问题查询条件
 *
 * @author RyanChow
 * @since 2025/04/03 00:34
 */
@Data
@Schema(description = "社区问题查询条件")
public class QuestionsQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 问题状态 0-未回答 1-已回答
     */
    @Schema(description = "问题状态 0-未回答 1-已回答")
    @Query(type = QueryType.EQ)
    private Integer questionsState;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @Query(type = QueryType.EQ)
    private Integer userId;

    /**
     * 0-未 1-已
     */
    @Schema(description = "0-未 1-已")
    @Query(type = QueryType.EQ)
    private Integer isDel;

    /**
     * 
     */
    @Schema(description = "")
    @Query(type = QueryType.EQ)
    private LocalDateTime createTime;
}