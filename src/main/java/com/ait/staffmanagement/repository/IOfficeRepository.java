package com.ait.staffmanagement.repository;

import com.ait.staffmanagement.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOfficeRepository extends JpaRepository<Office, Long> {
	
	
}
