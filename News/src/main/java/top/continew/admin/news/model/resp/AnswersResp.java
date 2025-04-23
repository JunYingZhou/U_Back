package top.continew.admin.news.model.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.admin.news.model.VO.AnswersVO;
import top.continew.admin.news.model.VO.CommentVO;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AnswersResp {

    private Long readNumber;
    private Long commentSize;
    private List<AnswersVO> comment;

}
