package top.continew.admin.news.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.continew.admin.news.mapper.ChatMapper;
import top.continew.admin.news.model.ChatDO;
import top.continew.admin.news.model.NewsDO;
import top.continew.admin.news.model.RepoDO;
import top.continew.admin.news.service.ChatService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatMapper chatMapper;

    @Override
    public List<ChatDO> getChatById(Long categoryId, Long userId) {
        return chatMapper.getChatById(categoryId, userId);
    }

    @Override
    public RepoDO getRepoByCategoryId(Long categoryId) {
        return chatMapper.getQuestionByCategory(categoryId);
    }
}
