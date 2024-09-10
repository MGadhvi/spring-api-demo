package com.mg.apidemo.repositories;

import com.mg.apidemo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> getUserEntityById(Integer id);

    List<UserEntity> getUserEntityByName(String name);
}