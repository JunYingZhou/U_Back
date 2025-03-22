package top.continew.admin.news.model.resp;

import java.io.Serial;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.continew.starter.extension.crud.model.resp.BaseDetailResp;

/**
 * 文章种类详情信息
 *
 * @author RyanChow
 * @since 2025/02/14 00:54
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "文章种类详情信息")
public class CategoryDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 种类表id
     */
    @Schema(description = "种类表id")
    @ExcelProperty(value = "种类表id")
    private Integer categoryId;

    /**
     * 种类名称
     */
    @Schema(description = "种类名称")
    @ExcelProperty(value = "种类名称")
    private String categoryName;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private LocalDateTime modifyTime;
}