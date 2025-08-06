package com.java.java_minebrat_task.Repo;

import java.time.LocalDate;
import java.util.Optional;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.java_minebrat_task.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

    @Query("SELECT u FROM User u WHERE (:name IS NULL OR u.username LIKE %:name%) AND (:pin IS NULL OR u.address.pinCode = :pin) AND (:start IS NULL OR u.registrationDate >= :start) AND (:end IS NULL OR u.registrationDate <= :end)")
    Page<UserEntity> searchUsers(@Param("name") String name, @Param("pin") String pin, @Param("start") LocalDate start, @Param("end") LocalDate end, org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable pageable);


}
