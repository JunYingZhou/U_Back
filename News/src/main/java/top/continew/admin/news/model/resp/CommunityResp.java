package top.continew.admin.news.model.resp;

import java.io.Serial;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.extension.crud.model.resp.BaseResp;

/**
 * 社区管理信息
 *
 * @author RyanChow
 * @since 2025/02/15 04:37
 */
@Data
@Schema(description = "社区管理信息")
public class CommunityResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 社区详情
     */
    @Schema(description = "社区详情")
    private String communityDesc;

    /**
     * 社区人数
     */
    @Schema(description = "社区人数")
    private Long communityPeoples;

    /**
     * 
     */
    @Schema(description = "")
    private LocalDateTime updateTime;

    /**
     * 
     */
    @Schema(description = "")
    private Long updateUser;

    /**
     * 社区封面
     */
    @Schema(description = "社区封面")
    private String communityCoverUrl;

    /**
     * 社区名称
     */
    @Schema(description = "社区名称")
    private String communityName;

    /**
     * 社区种类
     */
    @Schema(description = "社区种类")
    private Long categoryId;
}