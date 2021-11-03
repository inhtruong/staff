package com.ait.staffmanagement.service.staff;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.staffmanagement.model.Staff;
import com.ait.staffmanagement.model.DTO.CreateDTO;
import com.ait.staffmanagement.model.DTO.DisplayDTO;
import com.ait.staffmanagement.repository.IStaffRepository;

@Service
public class StaffService implements  IStaffService {
	
	@Autowired
	private IStaffRepository staffRepository;

	@Override
	public Iterable<Staff> findAll() {
		return 	staffRepository.findAll();
		
	}

	@Override
	public Optional<Staff> findById(long id) {
		return 	staffRepository.findById(id);
		
	}
	@Override
	public Staff save(Staff t) {
		return 	staffRepository.save(t);
		
	}

	@Override
	public void deleteById(long id) {
		staffRepository.deleteById(id);
		
	}

	@Override
    public Optional<Staff> findByEmail(String email) {
        return staffRepository.findByEmail(email);
    }

    @Override
    public CreateDTO findStaffByEmail(String email) {
        return staffRepository.findStaffByEmail(email);
    }

	@Override
	public Iterable<DisplayDTO> findAllByDeleted(Boolean isDeleted) {
		return staffRepository.findAllByDeleted(isDeleted);
	}

	@Override
	public Optional<DisplayDTO> findStaffById(Boolean isDeleted, long id) {
		return staffRepository.findStaffById(isDeleted, id);
	}

	@Override
	public Iterable<DisplayDTO> searchByNameOffice(Boolean isDeleted, String keyword) {
		return staffRepository.searchByNameOffice(isDeleted, keyword);
	}

}
