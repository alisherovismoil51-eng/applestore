package org.example.applestore.Controller;

import org.example.applestore.dto.CategoryDto;
import org.example.applestore.model.Category;
import org.example.applestore.model.Result;
import org.example.applestore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorys")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getall(){
        return categoryService.getall();
    }
    @GetMapping("{id")
    public Category byid(@PathVariable Long id){
        return categoryService.byid(id);
    }
    @PostMapping
    public ResponseEntity<Result> add(@RequestBody CategoryDto categoryDto){
        Result result = categoryService.create(categoryDto);
        return ResponseEntity.status(200).body(result);
    }
    @PutMapping("{id}")
    public ResponseEntity<Result> edit(@PathVariable Long id , @RequestBody CategoryDto categoryDto){
        Result result = categoryService.update(id , categoryDto);
        return ResponseEntity.status(200).body(result);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Result> delete(@PathVariable Long id){
        Result result = categoryService.delete(id);
        return ResponseEntity.status(200).body(result);
    }
}
