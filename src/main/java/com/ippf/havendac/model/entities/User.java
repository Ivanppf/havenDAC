package com.ippf.havendac.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private String username;
    private String email;
    private String password;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_user_role",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId")
    )
    private List<Role> roles;

//    public User(UserRequestDTO userRequestDTO) {
//        this.firstName = userRequestDTO.firstName();
//        this.lastName = userRequestDTO.lastName();
//        this.email = userRequestDTO.email();
//        this.password = userRequestDTO.password();
//    }

}
