package top.continew.admin.news.model.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.admin.news.model.ArticleGDO;
import top.continew.admin.news.model.resp.ArticleResp;
import top.continew.admin.news.model.resp.QuestionsResp;
import top.continew.starter.extension.crud.model.resp.BaseResp;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 社区管理信息
 *
 * @author RyanChow
 * @since 2025/02/15 04:37
 */
@Data
@Schema(description = "社区试图数据对象")
public class CommunityVO extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 社区ID
     */
    @Schema(description = "社区ID")
    private Long id;

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


    /**
     * 社区文章
     */
    @Schema(description = "社区文章")
    private List<ArticleGDO> articleList;

    /**
     * 社区问题
     */
    @Schema(description = "社区问题")
    private List<QuestionsResp> questionsRespList;

}