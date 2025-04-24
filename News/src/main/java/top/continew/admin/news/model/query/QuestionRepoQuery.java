package top.continew.admin.news.model.query;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

/**
 * 题库管理查询条件
 *
 * @author RyanChow
 * @since 2025/04/23 23:58
 */
@Data
@Schema(description = "题库管理查询条件")
public class QuestionRepoQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @Schema(description = "")
    @Query(type = QueryType.EQ)
    private Long categoryId;
}