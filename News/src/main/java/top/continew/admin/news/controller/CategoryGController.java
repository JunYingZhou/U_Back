package top.continew.admin.news.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.continew.admin.news.model.CategoryGDO;
import top.continew.admin.news.service.CategoryGService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/anti/category")
public class CategoryGController {

    private final CategoryGService categoryService;

    @GetMapping("/list")
    public List<CategoryGDO> getArticleList() {
        return categoryService.getAllCategory();
    }
}
