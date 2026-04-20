package org.example.applestore.service;

import org.example.applestore.dto.CategoryDto;
import org.example.applestore.model.Category;
import org.example.applestore.model.Result;
import org.example.applestore.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    //read all
    public List<Category> getall(){
        return categoryRepo.findAll();
    }
    //read byid
    public Category byid(Long id){
        return categoryRepo.findById(id).get();
    }
    //create
    public Result create(CategoryDto categoryDto){
        boolean existsed = categoryRepo.existsByEmailAndPassword(categoryDto.getDescription(), categoryDto.getName());
        if (existsed){
            return new Result("accota kirdigiz",true);
        }
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        categoryRepo.save(category);
        return new Result("saqladi",true);
    }
    //update
    public Result update(Long id , CategoryDto categoryDto){
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if (optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            category.setName(categoryDto.getName());
            category.setDescription(categoryDto.getDescription());
            categoryRepo.save(category);
            return new Result("ozgartirlidi",true);
        }
        return new Result("Id topiladfi",false);
    }
    //delete
    public Result delete(Long id){
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if (optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            categoryRepo.delete(category);
            return new Result("ochirlidi",true);
        }
        return new Result("Id topilmadi",false);
    }
}
