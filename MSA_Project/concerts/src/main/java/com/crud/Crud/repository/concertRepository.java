package com.crud.Crud.repository;

import com.crud.Crud.entity.concert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface concertRepository extends JpaRepository<concert,String> {
}
