package com.prometheussoftwarellc.hello.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.prometheussoftwarellc.hello.data.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

  List<User> findByName(String name);
}
