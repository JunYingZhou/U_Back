package top.continew.admin.news.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.continew.admin.news.mapper.CategoryGMapper;
import top.continew.admin.news.model.CategoryGDO;
import top.continew.admin.news.service.CategoryGService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryGServiceImpl implements CategoryGService {

    private final CategoryGMapper categoryMapper;

    @Override
    public List<CategoryGDO> getAllCategory() {
        System.out.println("categoryMapper.getAllCategory() = " + categoryMapper.getAllCategory());
        return categoryMapper.getAllCategory();
    }
}
