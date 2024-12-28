package top.continew.admin.auth.model.req;

import cn.hutool.core.lang.RegexPool;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

@Data
@Schema(description = "微信登录信息")
public class WeiXinLoginReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * openId
     */
    @Schema(description = "openId", example = "\"0c3yz6ll2mWGMe48R0nl2auSLa1yz6lh\"")
    @NotBlank(message = "openId号不能为空")
    private String openId;

    /**
     * 手机号
     */
    @Schema(description = "seesion_key", example = "\"0c3yz6ll2mWGMe48R0nl2auSLa1yz6lh\"")
    @NotBlank(message = "seesion_key")
    private String sessionKey;


}
