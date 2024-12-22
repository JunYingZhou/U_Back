package top.continew.admin.news.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.continew.admin.news.model.ArticleDO;
import top.continew.admin.news.model.CategoryDO;
import top.continew.admin.news.service.CategoryService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/anti/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/list")
    public List<CategoryDO> getArticleList() {
        return categoryService.getAllCategory();
    }
}
