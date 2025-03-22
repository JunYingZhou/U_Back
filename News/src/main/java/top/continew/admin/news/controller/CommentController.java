package top.continew.admin.news.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.continew.admin.news.model.CommentDO;
import top.continew.admin.news.model.VO.CommentVO;
import top.continew.admin.news.service.CommentService;
import top.continew.admin.news.utils.CommentResp;

import java.util.List;
import java.util.Objects;

@Tag(name = "评论 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/anti/comment")
public class CommentController {

    private final CommentService commentService;

    /**
     * 获取评论列表
     */
    @GetMapping("/queryById/{articleId}")
    public CommentResp queryAllCommentById(@PathVariable Long articleId){
        List<CommentVO> commentDOS = commentService.queryAllCommentById(articleId);
        CommentResp commentResp = new CommentResp();
        commentResp.setReadNumber(9999L);
        commentResp.setCommentSize((long) commentDOS.size());
        commentResp.setComment(commentDOS);
        return commentResp;
    }

    /**
     * 获取评论列表
     */
    @SaIgnore
    @PostMapping("/addComment")
    public Boolean addComment(@RequestBody CommentDO commentDO){
        return commentService.addComment(commentDO) > 0;
    }

    /**
     * 获取评论列表
     */
    @PostMapping("/updateComment")
    public Boolean updateComment(@RequestBody CommentDO commentDO){
        return commentService.updateComment(commentDO) > 0;
    }

    /**
     * 获取评论列表
     */
    @GetMapping("/delComment/{commentId}")
    public Boolean updateComment(@PathVariable Long commentId){
        return commentService.deleteComment(commentId) > 0;
    }


}
