package com.ait.staffmanagement.controller.api;

import com.ait.staffmanagement.model.Staff;
import com.ait.staffmanagement.service.staff.IStaffService;
import com.ait.staffmanagement.service.staff.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/setLock")
public class SetLockAPI {

    @Autowired
    private IStaffService StaffService;

    @PostMapping("/{id}")
    public ResponseEntity<?> setLock(@PathVariable Long id) {
        Optional<Staff> StaffOptional = StaffService.findById(id);
        if (StaffOptional.isPresent()) {
            Staff staff = StaffOptional.get();
            staff.setDeleted(staff.getDeleted() ? false : true);
            StaffService.save(staff);
            return new ResponseEntity<>(staff.getId(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
