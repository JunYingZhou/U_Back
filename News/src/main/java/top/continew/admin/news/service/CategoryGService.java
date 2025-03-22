package top.continew.admin.news.service;

import top.continew.admin.news.model.CategoryGDO;

import java.util.List;

public interface CategoryGService {

    /**
     * 获取所有分类
     */
    List<CategoryGDO> getAllCategory();

}
