package dev.ocode.inventory.controller;

import dev.ocode.inventory.dto.ProductRequest;
import dev.ocode.inventory.model.Category;
import dev.ocode.inventory.model.Product;
import dev.ocode.inventory.service.CategoryService;
import dev.ocode.inventory.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody ProductRequest request){
        Category category = categoryService.findById(request.getCategoryId());
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setCategory(category);
        product.setCreateAt(LocalDateTime.now());
        product.setUpdateAt(LocalDateTime.now());
        return productService.save(product);
    }
}
