package com.example.login.Repository;

import com.example.login.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByEmail(String email);
}
