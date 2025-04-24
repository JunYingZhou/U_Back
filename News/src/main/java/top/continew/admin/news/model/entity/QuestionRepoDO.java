package top.continew.admin.news.model.entity;

import java.io.Serial;
import java.time.*;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.starter.extension.crud.model.entity.BaseDO;

/**
 * 题库管理实体
 *
 * @author RyanChow
 * @since 2025/04/23 23:58
 */
@Data
@TableName("af_question_repo")
public class QuestionRepoDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private Long repoId;

    /**
     * 
     */
    private Long categoryId;

    /**
     * 
     */
    private String repoContentOne;

    /**
     * 
     */
    private String repoContentTwo;

    /**
     * 
     */
    private String repoContentThree;

    /**
     * 
     */
    private String repoContentFour;

    /**
     * 
     */
    private String repoContentFive;

    /**
     * 
     */
    private String repoContentSix;

    /**
     * 
     */
    private String repoContentSeven;

    /**
     * 
     */
    private String repoContentEight;

    /**
     * 
     */
    private String repoContentNine;

    /**
     * 
     */
    private String repoContentTen;

    /**
     * 
     */
    private LocalDateTime modifyTime;
}