package top.continew.admin.news.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.continew.admin.news.mapper.CategoryMapper;
import top.continew.admin.news.model.CategoryDO;
import top.continew.admin.news.service.CategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDO> getAllCategory() {
        System.out.println("categoryMapper.getAllCategory() = " + categoryMapper.getAllCategory());
        return categoryMapper.getAllCategory();
    }
}
