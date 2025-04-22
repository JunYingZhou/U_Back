package top.continew.admin.news.model.VO;

import lombok.Data;

import java.util.Date;

@Data
public class ChatVO {

    private Long userId;
    private Long categoryId;
    private String ChatMessagesJson;
    private String chatAdvise;
    private Date createTime;
}
