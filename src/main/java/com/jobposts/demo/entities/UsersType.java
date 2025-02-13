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
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "users_type")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UsersType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userTypeId;

    private String userTypeName;

    @OneToMany(targetEntity = Users.class, mappedBy = "usersTypeId", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Users> users;
}
