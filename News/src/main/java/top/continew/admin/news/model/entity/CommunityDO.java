package top.continew.admin.news.model.entity;

import java.io.Serial;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.starter.extension.crud.model.entity.BaseDO;

/**
 * 社区管理实体
 *
 * @author RyanChow
 * @since 2025/02/15 04:37
 */
@Data
@TableName("af_community")
public class CommunityDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 社区详情
     */
    private String communityDesc;

    /**
     * 社区人数
     */
    private Long communityPeoples;

    /**
     * 社区封面
     */
    private String communityCoverUrl;

    /**
     * 社区名称
     */
    private String communityName;

    /**
     * 社区种类
     */
    private Long categoryId;
}