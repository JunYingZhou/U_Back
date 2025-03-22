package top.continew.admin.news.model.entity;

import java.io.Serial;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.starter.extension.crud.model.entity.BaseDO;

/**
 * 文章管理实体
 *
 * @author RyanChow
 * @since 2025/02/16 03:46
 */
@Data
@TableName("af_article")
public class ArticleDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章主要内容
     */
    private String articleMain;

    /**
     * 分类id
     */
    private Integer categoryId;

    /**
     * 文章封面地址
     */
    private String articleCoverUrl;

    /**
     * 文章摘要
     */
    private String articleAbstract;

    /**
     * 文章收藏数
     */
    private Integer articleStarCount;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 是否官方推文 0-不是 1-是

     */
    private Integer isOfficial;

    /**
     * 是否匿名
     */
    private Integer isNoname;

    /**
     * 1-审核中 2-审核通过 3-不通过
     */
    private Long status;

    /**
     * 0-不是社区文章 1-社区文章
     */
    private Long isCommunity;

    /**
     * 社区id
     */
    private Integer communityId;
}