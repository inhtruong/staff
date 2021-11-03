package com.ait.staffmanagement.service.office;

import com.ait.staffmanagement.model.Office;
import com.ait.staffmanagement.repository.IOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfficeService implements IOfficeService{

    @Autowired
    private IOfficeRepository officeRepository;

    @Override
    public Iterable<Office> findAll() {
        return officeRepository.findAll();
    }

    @Override
    public Optional<Office> findById(long id) {
        return officeRepository.findById(id);
    }

    @Override
    public Office save(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public void deleteById(long id) {
        officeRepository.deleteById(id);
    }
    
    
}
