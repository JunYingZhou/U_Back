package top.continew.admin.news.model;

import lombok.Data;

import java.util.Date;

@Data
public class AnswersDO {

    private Long commentId;
    private Long questionId;
    private String commentContent;
    private Long userId;
    private Long toUserId;
    private Long commentRootId;
    private Long commentLikeCount;
    private Long commentType;
    private Date createTime;
    private Date modifyTime;
}
