package top.continew.admin.news.model.VO;

import lombok.Data;

import java.util.Date;


@Data
public class AnswersVO {

    private Long commentId;
    private Long questionId;
    private String commentContent;
    private Long userId;
    private Long toUserId;
    private Long commentRootId;
    private Long commentLikeCount;
    private Long commentType;
    private Date createTime;
    private String avatar;
    private String nickname;
    private Date modifyTime;
}
