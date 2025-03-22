package top.continew.admin.news.utils;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import top.continew.admin.news.model.CommentDO;
import top.continew.admin.news.model.VO.CommentVO;

import java.util.List;

@Getter
@Data
@Setter
public class CommentResp {
    private Long readNumber;
    private Long commentSize;
    private List<CommentVO> comment;
}
