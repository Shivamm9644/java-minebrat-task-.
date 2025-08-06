package com.java.java_minebrat_task.Repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.java.java_minebrat_task.Entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
