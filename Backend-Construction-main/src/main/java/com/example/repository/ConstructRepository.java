package com.example.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ConstructEntity;

@Repository
public interface ConstructRepository extends JpaRepository <ConstructEntity, UUID> {

}
