package top.continew.admin.news.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.continew.admin.news.model.ChatDO;
import top.continew.admin.news.model.RepoDO;
import top.continew.admin.news.model.VO.ChatVO;

import java.util.List;

@Mapper
public interface ChatMapper {

    List<ChatDO> getChatById(Long categoryId, Long userId);

    RepoDO getQuestionByCategory(Long categoryId);


    Long addChatInfo(ChatVO chatDO);
}
