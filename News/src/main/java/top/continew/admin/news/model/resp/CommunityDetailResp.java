package top.continew.admin.news.model.resp;

import java.io.Serial;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.continew.starter.extension.crud.model.resp.BaseDetailResp;

/**
 * 社区管理详情信息
 *
 * @author RyanChow
 * @since 2025/02/15 04:37
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "社区管理详情信息")
public class CommunityDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 社区详情
     */
    @Schema(description = "社区详情")
    @ExcelProperty(value = "社区详情")
    private String communityDesc;

    /**
     * 社区人数
     */
    @Schema(description = "社区人数")
    @ExcelProperty(value = "社区人数")
    private Long communityPeoples;

    /**
     * 社区封面
     */
    @Schema(description = "社区封面")
    @ExcelProperty(value = "社区封面")
    private String communityCoverUrl;

    /**
     * 社区名称
     */
    @Schema(description = "社区名称")
    @ExcelProperty(value = "社区名称")
    private String communityName;

    /**
     * 社区种类
     */
    @Schema(description = "社区种类")
    @ExcelProperty(value = "社区种类")
    private Long categoryId;
}