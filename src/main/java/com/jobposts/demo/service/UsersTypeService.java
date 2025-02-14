package com.jobposts.demo.service;

import com.jobposts.demo.entities.UsersType;
import com.jobposts.demo.repository.UsersTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersTypeService {
    private final UsersTypeRepository usersTypeRepository;

    public List<UsersType> findAll() {
        return usersTypeRepository.findAll();
    }
}
