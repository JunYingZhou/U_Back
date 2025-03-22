package top.continew.admin.news.model.Req;

import java.io.Serial;
import java.time.*;


import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import top.continew.starter.extension.crud.model.req.BaseReq;

/**
 * 创建或修改社区管理信息
 *
 * @author RyanChow
 * @since 2025/02/15 04:37
 */
@Data
@Schema(description = "创建或修改社区管理信息")
public class CommunityReq extends BaseReq {

    @Serial
    private static final long serialVersionUID = 1L;
}