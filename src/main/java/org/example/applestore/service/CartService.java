package org.example.applestore.service;

import org.example.applestore.dto.CartDto;
import org.example.applestore.model.Cart;
import org.example.applestore.model.Result;
import org.example.applestore.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;

    //read all
    public List<Cart> getall(){
        return cartRepo.findAll();
    }

    //read by id
    public Cart byid(Long id){
        return cartRepo.findById(id).get();
    }
    //create
    public Result create(CartDto cartDto){
        boolean existsed = cartRepo.existsByEmailAndid(cartDto.getProductid(), cartDto.getProductid());
        if (existsed){
            return new Result("accoutga kirdigiz",true);
        }
        Cart cart = new Cart();
        cart.setProductid(cartDto.getProductid());
        cart.setUserid(cartDto.getUserid());
        cartRepo.save(cart);
        return new Result("saqlandi",true);
    }
    //update
    public Result update(Long id , CartDto cartDto){
        Optional<Cart> optionalCart = cartRepo.findById(id);
        if (optionalCart.isPresent()){
            Cart cart = optionalCart.get();
            cart.setProductid(cartDto.getProductid());
            cart.setUserid(cartDto.getUserid());
            cartRepo.save(cart);
            return new Result("ozgartirildi",true);
        }
        return new Result("Id topilmadi",false);
    }
    //delete
    public Result delete(Long id){
        Optional<Cart> optionalCart = cartRepo.findById(id);
        if (optionalCart.isPresent()){
            Cart cart = optionalCart.get();
            cartRepo.delete(cart);
            return new Result("ochirildi",true);
        }
        return new Result("Id topilmadi",false);
    }
}
