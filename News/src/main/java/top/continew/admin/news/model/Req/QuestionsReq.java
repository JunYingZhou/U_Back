package top.continew.admin.news.model.Req;

import java.io.Serial;
import java.time.*;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import top.continew.starter.extension.crud.model.req.BaseReq;

/**
 * 创建或修改社区问题信息
 *
 * @author RyanChow
 * @since 2025/04/03 00:34
 */
@Data
@Schema(description = "创建或修改社区问题信息")
public class QuestionsReq extends BaseReq {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 问题状态 0-未回答 1-已回答
     */
    @Schema(description = "问题状态 0-未回答 1-已回答")
    @NotNull(message = "问题状态 0-未回答 1-已回答不能为空")
    private Integer questionsState;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

    /**
     * 0-未 1-已
     */
    @Schema(description = "0-未 1-已")
    @NotNull(message = "0-未 1-已不能为空")
    private Integer isDel;

    /**
     * 
     */
    @Schema(description = "")
    @NotNull(message = "不能为空")
    private LocalDateTime createTime;
}