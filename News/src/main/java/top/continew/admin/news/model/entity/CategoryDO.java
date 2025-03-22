package top.continew.admin.news.model.entity;

import java.io.Serial;
import java.time.*;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.starter.extension.crud.model.entity.BaseDO;

/**
 * 文章种类实体
 *
 * @author RyanChow
 * @since 2025/02/14 00:54
 */
@Data
@TableName("af_category")
public class CategoryDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 种类表id
     */
    private Integer categoryId;

    /**
     * 种类名称
     */
    private String categoryName;

    /**
     * 
     */
    private LocalDateTime modifyTime;
}