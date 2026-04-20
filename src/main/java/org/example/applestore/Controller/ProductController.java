package org.example.applestore.Controller;

import org.example.applestore.dto.ProductDto;
import org.example.applestore.model.Product;
import org.example.applestore.model.Result;
import org.example.applestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> all(){
        return productService.getall();
    }

    @GetMapping("{id}")
    public Product byid(@PathVariable Long id){
        return productService.byid(id);
    }

    @PostMapping
    public ResponseEntity<Result> add(@RequestBody ProductDto productDto){
        Result result = productService.create(productDto);
        return ResponseEntity.status(200).body(result);
    }

    @PutMapping("{id}")
    public ResponseEntity<Result> edit(@PathVariable Long id , @RequestBody ProductDto productDto){
        Result result = productService.update(id , productDto);
        return ResponseEntity.status(200).body(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Result> delete(@PathVariable Long id){
        Result result = productService.delete(id);
        return ResponseEntity.status(200).body(result);
    }
}
