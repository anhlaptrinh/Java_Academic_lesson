package com.cybersolf.demojpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;


    /**
     * Bảng nào chứa từ khóa nhiều thì sẽ là ManytoOne và @JoinColumn(ten_cot_khoa_ngoai)
     * Căn cu vào chữ cuoi trong mqh
     * Khi map  xong thì entity duoc map quan he phai map nguoc lai
     * @return
     */
    @ManyToOne
    @JoinColumn(name = "id_role")
    @JsonIgnore
    private RoleEntity role;

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
