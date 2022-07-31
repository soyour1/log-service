package com.example.logservice.repository;

import com.example.logservice.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogerRepository extends JpaRepository<Logger, Long> {
}
