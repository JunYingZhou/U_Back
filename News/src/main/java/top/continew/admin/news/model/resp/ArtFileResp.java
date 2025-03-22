package top.continew.admin.news.model.resp;

import java.io.Serial;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.extension.crud.model.resp.BaseResp;

/**
 * 文章文件信息
 *
 * @author RyanChow
 * @since 2025/03/18 21:43
 */
@Data
@Schema(description = "文章文件信息")
public class ArtFileResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 地址路径
     */
    @Schema(description = "地址路径")
    private String artFileUrl;

    /**
     * 更新人
     */
    @Schema(description = "更新人")
    private LocalDateTime modifyTime;
}