package top.continew.admin.news.model.Req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import top.continew.starter.extension.crud.model.req.BaseReq;

import java.io.Serial;
import java.util.Map;

/**
 * 模型数据分析
 *
 * @author RyanChow
 * @since 2025/03/18 21:43
 */
@Data
@Schema(description = "题目数据")
public class AntiMessageReq extends BaseReq {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 地址路径
     */
    @Schema(description = "题目分类")
//    @Length(max = 255, message = "地址路径长度不能超过 {max} 个字符")
    private String questionCategory;

    /**
     * 文章ID
     */
    @Schema(description = "题目数据")
//    @NotNull(message = "用户id不能为空")
    private Map<String, String> questionContent;
}