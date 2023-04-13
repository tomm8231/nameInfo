package com.example.apihandin2.repository;

import com.example.apihandin2.entity.NameInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameInfoRepository extends JpaRepository<NameInfo, String> {
}
