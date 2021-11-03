package com.ait.staffmanagement.service.staff;


import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.ait.staffmanagement.model.Staff;
import com.ait.staffmanagement.model.DTO.CreateDTO;
import com.ait.staffmanagement.model.DTO.DisplayDTO;
import com.ait.staffmanagement.service.IGeneralService;


public interface IStaffService  extends IGeneralService<Staff>{
	
	Optional<Staff> findByEmail(String email);

    CreateDTO findStaffByEmail(String email);

    Iterable<DisplayDTO> findAllByDeleted(Boolean isDeleted);

    Optional<DisplayDTO> findStaffById(Boolean isDeleted, long id);
    
    Iterable<DisplayDTO> searchByNameOffice(Boolean isDeleted, String keyword);


}
