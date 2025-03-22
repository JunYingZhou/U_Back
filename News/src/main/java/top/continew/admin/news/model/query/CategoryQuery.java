package top.continew.admin.news.model.query;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

/**
 * 文章种类查询条件
 *
 * @author RyanChow
 * @since 2025/02/14 00:54
 */
@Data
@Schema(description = "文章种类查询条件")
public class CategoryQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}