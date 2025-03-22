package top.continew.admin.news.model.entity;

import java.io.Serial;
import java.time.*;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.starter.extension.crud.model.entity.BaseDO;

/**
 * 文章文件实体
 *
 * @author RyanChow
 * @since 2025/03/18 21:43
 */
@Data
@TableName("af_art_file")
public class ArtFileDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 文件表id
     */
    private Integer artFileId;

    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 地址路径
     */
    private String artFileUrl;

    /**
     * 更新人
     */
    private LocalDateTime modifyTime;
}