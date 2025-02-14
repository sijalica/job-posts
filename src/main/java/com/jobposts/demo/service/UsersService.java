package com.jobposts.demo.service;

import com.jobposts.demo.entities.JobSeekerProfile;
import com.jobposts.demo.entities.RecruiterProfile;
import com.jobposts.demo.entities.Users;
import com.jobposts.demo.repository.JobSeekerProfileRepository;
import com.jobposts.demo.repository.RecruiterProfileRepository;
import com.jobposts.demo.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;

    public Users addUser(Users users) {
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        Users savedUsers = usersRepository.save(users);
        int userTypeId = users.getUserTypeId().getUserTypeId();

        if (userTypeId == 1) {
            recruiterProfileRepository.save(new RecruiterProfile(savedUsers));
        } else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUsers));
        }

        return savedUsers;
    }

    public Optional<Users> getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
