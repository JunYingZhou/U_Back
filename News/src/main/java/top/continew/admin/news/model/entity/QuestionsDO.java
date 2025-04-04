package top.continew.admin.news.model.entity;

import java.io.Serial;
import java.time.*;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.starter.extension.crud.model.entity.BaseDO;

/**
 * 社区问题实体
 *
 * @author RyanChow
 * @since 2025/04/03 00:34
 */
@Data
@TableName("af_questions")
public class QuestionsDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 问题标题
     */
    private String questionsTitle;

    /**
     * 问题内容
     */
    private String questionsContent;

    /**
     * 问题状态 0-未回答 1-已回答
     */
    private Integer questionsState;

    /**
     * 问题点赞数量
     */
    private Integer questionsLikeCount;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 0-未 1-已
     */
    private Integer isDel;

    /**
     * 
     */
    private LocalDateTime modifyTime;

    /**
     * 社区id
     */
    private Long communityId;
}