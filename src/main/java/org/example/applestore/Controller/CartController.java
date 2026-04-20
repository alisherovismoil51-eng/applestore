package org.example.applestore.Controller;

import org.example.applestore.dto.CartDto;
import org.example.applestore.model.Cart;
import org.example.applestore.model.Result;
import org.example.applestore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/carts"})
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping
    public List<Cart> getall(){
        return cartService.getall();
    }
    @GetMapping("{id}")
    public Cart byid(@PathVariable Long id){
        return cartService.byid(id);
    }
    @PostMapping
    public ResponseEntity<Result> add(@RequestBody CartDto cartDto){
        Result result = cartService.create(cartDto);
        return ResponseEntity.status(200).body(result);
    }
    @PutMapping("{id}")
    public ResponseEntity<Result> edit(@PathVariable Long id , @RequestBody CartDto cartDto){
        Result result = cartService.update(id , cartDto);
        return ResponseEntity.status(200).body(result);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Result> delete(@PathVariable Long id){
        Result result = cartService.delete(id);
        return ResponseEntity.status(200).body(result);
    }
}
