package dev.ocode.inventory.controller;

import dev.ocode.inventory.model.Category;
import dev.ocode.inventory.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Long id){
        return categoryService.findById(id);
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        category.setCreateAt(LocalDateTime.now());
        category.setUpdateAt(LocalDateTime.now());
        return categoryService.save(category);
    }
}
