package com.ait.staffmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.ait.staffmanagement.model.Staff;
import com.ait.staffmanagement.model.DTO.CreateDTO;
import com.ait.staffmanagement.model.DTO.DisplayDTO;


@Repository
public interface IStaffRepository extends JpaRepository<Staff,Long> {
	
	@Query("SELECT NEW com.ait.staffmanagement.model.DTO.CreateDTO (s.id, s.email) FROM Staff s WHERE s.email = ?1")
    CreateDTO findStaffByEmail(String email);

    Optional<Staff> findByEmail(String email);

    @Query("SELECT NEW com.ait.staffmanagement.model.DTO.DisplayDTO (s.id, s.fullName, s.email, s.address, s.dateOfBirth, "
    		+ "s.entryCompanyDate, s.office.name) " +
            "FROM Staff s " +
            "WHERE s.isDeleted =?1")
    Iterable<DisplayDTO> findAllByDeleted(Boolean isDeleted);

    @Query("SELECT NEW com.ait.staffmanagement.model.DTO.DisplayDTO (s.id, s.fullName, s.email, s.address, s.dateOfBirth, "
            + "s.entryCompanyDate, s.office.name) " +
            "FROM Staff s " +
            "WHERE s.isDeleted =?1 AND s.id =?2")
    Optional<DisplayDTO> findStaffById(Boolean isDeleted, long id);

    @Query("SELECT NEW com.ait.staffmanagement.model.DTO.DisplayDTO (s.id, s.fullName, s.email, s.address, s.dateOfBirth, "
    		+ "s.entryCompanyDate, s.office.name) " +
            "FROM Staff s " +
            "WHERE s.isDeleted =:isDeleted AND s.office.name LIKE %:keyword%")
    Iterable<DisplayDTO> searchByNameOffice(@Param("isDeleted") Boolean isDeleted, @Param("keyword") String keyword);

}
