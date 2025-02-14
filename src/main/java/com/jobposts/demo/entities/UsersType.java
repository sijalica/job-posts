package com.jobposts.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "users_type")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsersType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userTypeId;

    private String userTypeName;

    @OneToMany(targetEntity = Users.class, mappedBy = "userTypeId", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Users> users;
}
