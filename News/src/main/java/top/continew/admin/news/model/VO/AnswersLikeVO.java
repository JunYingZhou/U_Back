package top.continew.admin.news.model.VO;

import lombok.Data;

import java.util.Date;


@Data
public class AnswersLikeVO {
    private Long commentId;
    private Long articleId;
    private Long userId;
    private Date createTime;
    private Date modifyTime;
}
