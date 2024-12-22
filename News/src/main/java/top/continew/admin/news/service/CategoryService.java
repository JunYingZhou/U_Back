package top.continew.admin.news.service;

import top.continew.admin.news.model.CategoryDO;

import java.util.List;

public interface CategoryService {

    /**
     * 获取所有分类
     */
    List<CategoryDO> getAllCategory();

}
