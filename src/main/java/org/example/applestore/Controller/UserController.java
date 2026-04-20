package org.example.applestore.Controller;

import org.example.applestore.dto.UserDto;
import org.example.applestore.model.Result;
import org.example.applestore.model.User;
import org.example.applestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> all() {
        return userService.getall();
    }

    @GetMapping
    public User byid(@PathVariable Long id) {
        return userService.byid(id);
    }

    @PostMapping
    public ResponseEntity<Result> add(@RequestBody UserDto userDto) {
        Result result = userService.create(userDto);
        return ResponseEntity.status(200).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> edit(@PathVariable Long id, @RequestBody UserDto userDto) {
        Result result = userService.update(id, userDto);
        return ResponseEntity.status(200).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable Long id) {
        Result result = userService.delete(id);
        return ResponseEntity.status(200).body(result);

    }
}
