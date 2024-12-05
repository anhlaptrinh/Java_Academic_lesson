package com.cybersolf.demojpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "description")
    private String desc;

    //mappedBy(ten_thuoc_tinh_cua_bang_map_toi_no)
    @OneToMany(mappedBy = "role")
    private List<UserEntity> lisUsers;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserEntity> getLisUsers() {
        return lisUsers;
    }

    public void setLisUsers(List<UserEntity> lisUsers) {
        this.lisUsers = lisUsers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
