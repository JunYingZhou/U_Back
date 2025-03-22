package top.continew.admin.news.model.query;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

/**
 * 社区管理查询条件
 *
 * @author RyanChow
 * @since 2025/02/15 04:37
 */
@Data
@Schema(description = "社区管理查询条件")
public class CommunityQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 社区名称
     */
    @Schema(description = "社区名称")
    @Query(type = QueryType.LIKE)
    private String communityName;

    /**
     * 社区种类
     */
    @Schema(description = "社区种类")
    @Query(type = QueryType.EQ)
    private Long categoryId;
}