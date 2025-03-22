package top.continew.admin.news.model.Req;

import java.io.Serial;
import java.time.*;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import top.continew.starter.extension.crud.model.req.BaseReq;

/**
 * 创建或修改文章文件信息
 *
 * @author RyanChow
 * @since 2025/03/18 21:43
 */
@Data
@Schema(description = "创建或修改文章文件信息")
public class ArtFileReq extends BaseReq {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 地址路径
     */
    @Schema(description = "地址路径")
//    @Length(max = 255, message = "地址路径长度不能超过 {max} 个字符")
    private String artFileUrl;

    /**
     * 文章ID
     */
    @Schema(description = "文章ID")
    @NotNull(message = "用户id不能为空")
    private Long articleId;
}