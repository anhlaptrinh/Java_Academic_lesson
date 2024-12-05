package com.cybersolf.demojpa.controller;

import com.cybersolf.demojpa.dto.UsersDto;
import com.cybersolf.demojpa.entity.UserEntity;
import com.cybersolf.demojpa.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/users")
public class UsersController {

    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public ResponseEntity<?> getUsers(@RequestParam String firstName, @RequestParam String lastName){
        List<UsersDto> listuser=usersRepository.findByFirstNameAndLastName(firstName, lastName).stream().map(
                item->{
                    UsersDto usersDto= new UsersDto();
                    usersDto.setId(item.getId());
                    usersDto.setLastName(item.getLastName());
                    return usersDto;
                }
        ).toList();

        return ResponseEntity.ok(listuser);
    }
}
