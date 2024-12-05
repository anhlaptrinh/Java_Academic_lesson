package com.cybersolf.demojpa.controller;

import com.cybersolf.demojpa.dto.RolesDto;
import com.cybersolf.demojpa.dto.UsersDto;
import com.cybersolf.demojpa.entity.RoleEntity;
import com.cybersolf.demojpa.entity.UserEntity;
import com.cybersolf.demojpa.repository.RolesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/roles")
public class RolesController {


    private RolesRepository rolesRepository;
    RolesController(RolesRepository rolesRepository){
        this.rolesRepository = rolesRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllRoles(){
        List<RoleEntity> roles = rolesRepository.findAll();
        List<RolesDto> rolesDtos=new ArrayList<>();

        for(RoleEntity role : roles){
            RolesDto roledto = new RolesDto();
            roledto.setIdRole(role.getId());
            roledto.setRoleName(role.getRoleName());
            roledto.setDescription(role.getDesc());

            List<UsersDto> usersDtos = new ArrayList<>();
            for (UserEntity user : role.getLisUsers()){
                UsersDto users = new UsersDto();
                users.setId(user.getId());
                users.setLastName(user.getLastName());
                usersDtos.add(users);

            }
            roledto.setUsers(usersDtos);
            rolesDtos.add(roledto);
        }
        return ResponseEntity.ok(rolesDtos);
    }
}
