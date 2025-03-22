package top.continew.admin.news.model.resp;

import java.io.Serial;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.continew.starter.extension.crud.model.resp.BaseDetailResp;

/**
 * 文章文件详情信息
 *
 * @author RyanChow
 * @since 2025/03/18 21:43
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "文章文件详情信息")
public class ArtFileDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 文件表id
     */
    @Schema(description = "文件表id")
    @ExcelProperty(value = "文件表id")
    private Integer artFileId;

    /**
     * 文章id
     */
    @Schema(description = "文章id")
    @ExcelProperty(value = "文章id")
    private Integer articleId;

    /**
     * 地址路径
     */
    @Schema(description = "地址路径")
    @ExcelProperty(value = "地址路径")
    private String artFileUrl;

    /**
     * 更新人
     */
    @Schema(description = "更新人")
    @ExcelProperty(value = "更新人")
    private LocalDateTime modifyTime;
}