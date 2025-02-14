package com.jobposts.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "job_seeker_profile")
@Entity
public class JobSeekerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userAccountId;

    private String city;
    private String employmentType;
    private String country;
    private String firstName;
    private String lastName;

    @Column(length = 64) // nullable is true by default
    private String profilePhoto;

    private String resume;
    private String state;

    private String workAuthorization;

    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users userId;

    @OneToMany(targetEntity = Skills.class, cascade = CascadeType.ALL,
    mappedBy = "jobSeekerProfile") // for One to many, other class should be an entity
    @ToString.Exclude
    private List<Skills> skills;

    public JobSeekerProfile(Users users) {
        this.userId = users;
    }
}
