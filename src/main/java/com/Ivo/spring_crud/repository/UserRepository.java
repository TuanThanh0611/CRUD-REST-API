package com.Ivo.spring_crud.repository;

;
import com.Ivo.spring_crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}