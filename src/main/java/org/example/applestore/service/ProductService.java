package org.example.applestore.service;

import org.example.applestore.dto.ProductDto;
import org.example.applestore.model.Product;
import org.example.applestore.model.Result;
import org.example.applestore.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    //read all
    public List<Product> getall(){
        return productRepo.findAll();
    }

    //read by id
    public Product byid(Long id){
        return productRepo.findById(id).get();
    }

    //create
    public Result create(ProductDto productDto){
        boolean existsed = productRepo.existsByEmailAndPassword(productDto.getModel(), productDto.getPrice());
        if (existsed){
            return new Result("siz accotga kirdigiz",true);
        }
        Product product = new Product();
        product.setName(productDto.getName());
        product.setModel(productDto.getModel());
        product.setColor(productDto.getColor());
        product.setDisplay(productDto.getDisplay());
        product.setCamera(productDto.getCamera());
        product.setChip(productDto.getChip());
        product.setStorage(productDto.getStorage());
        product.setWaterresistense(productDto.getWaterresistense());
        product.setCreateddate(productDto.getCreateddate());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        productRepo.save(product);
        return new Result("saqlabdi",true);
    }

    //update
    public Result update(Long id , ProductDto productDto){
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setName(productDto.getName());
            product.setModel(productDto.getModel());
            product.setColor(productDto.getColor());
            product.setDisplay(productDto.getDisplay());
            product.setCamera(productDto.getCamera());
            product.setChip(productDto.getChip());
            product.setStorage(productDto.getStorage());
            product.setWaterresistense(productDto.getWaterresistense());
            product.setCreateddate(productDto.getCreateddate());
            product.setCategory(productDto.getCategory());
            product.setPrice(productDto.getPrice());
            productRepo.save(product);
            return new Result("ozgartirlid",true);
        }
        return new Result("Id topoiladi",false);
    }
    //delete
    public Result delete(Long id){
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            productRepo.delete(product);
            return new Result("ocirildi",true);
        }
        return new Result("Id topiadi",false);
    }
}
