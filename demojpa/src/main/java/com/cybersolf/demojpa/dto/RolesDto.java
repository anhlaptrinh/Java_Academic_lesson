package com.cybersolf.demojpa.dto;

import java.util.List;

public class RolesDto {
    private int idRole;
    private String roleName;
    private String description;
    private List<UsersDto> users;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UsersDto> getUsers() {
        return users;
    }

    public void setUsers(List<UsersDto> users) {
        this.users = users;
    }
}
