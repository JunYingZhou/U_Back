package top.continew.admin.news.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.continew.admin.news.mapper.ChatMapper;
import top.continew.admin.news.model.ChatDO;
import top.continew.admin.news.service.ChatService;
import top.continew.admin.news.service.TestService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final ChatMapper chatMapper;

    @Override
    public List<ChatDO> getTestById(Long categoryId, Long userId) {
        return chatMapper.getChatById(categoryId, userId);
    }
}
