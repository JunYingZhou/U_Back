package top.continew.admin.news.model.query;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

/**
 * 文章文件查询条件
 *
 * @author RyanChow
 * @since 2025/03/18 21:43
 */
@Data
@Schema(description = "文章文件查询条件")
public class ArtFileQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}