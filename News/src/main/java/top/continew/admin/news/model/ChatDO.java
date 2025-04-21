package top.continew.admin.news.model;


import lombok.Data;

import java.util.Date;

@Data
public class ChatDO {

    private Long chatId;
    private Long userId;
    private Long categoryId;
    private Long chatLevel;
    private String ChatMessagesJson;
    private String chatAdvise;
    private Date createTime;
    private Date modifyTime;


}
