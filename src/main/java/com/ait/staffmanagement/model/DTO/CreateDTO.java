package com.ait.staffmanagement.model.DTO;

import com.ait.staffmanagement.model.Office;
import com.ait.staffmanagement.model.Skill;
import com.ait.staffmanagement.model.Staff;
import com.ait.staffmanagement.service.office.IOfficeService;
import com.ait.staffmanagement.service.office.OfficeService;
import com.ait.staffmanagement.service.skill.ISkillService;
import com.ait.staffmanagement.service.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CreateDTO {
    private Long id;

    @NotBlank
    private String fullName;

    @NotBlank
    private String email;

    @NotBlank
    private String address;

    @NotBlank
    private String dateOfBirth;

    @NotBlank
    private String entryCompanyDate;

    @NotBlank
    private String introduce;

    @NotNull
    private Long office;

    private List<Long> skills;
    private Boolean isDeleted = true;

    public CreateDTO() {
    }

    public CreateDTO(Long id, String fullName, String email, String address, String dateOfBirth, String entryCompanyDate, String introduce, Long office, List<Long> skills, Boolean isDeleted) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.entryCompanyDate = entryCompanyDate;
        this.introduce = introduce;
        this.office = office;
        this.skills = skills;
        this.isDeleted = isDeleted;
    }

    public CreateDTO(Long id, String email) {
        this.id = id;
        this.email = email;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() throws ParseException {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEntryCompanyDate() throws ParseException {
        return entryCompanyDate;
    }

    public void setEntryCompanyDate(String entryCompanyDate) {
        this.entryCompanyDate = entryCompanyDate;
    }

    public Long getOffice() {
        return office;
    }

    public void setOffice(Long office) {
        this.office = office;
    }

    public List<Long> getSkills() {
        return skills;
    }

    public void setSkills(List<Long> skills) {
        this.skills = skills;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

//    public Staff toCreateStaff()throws ParseException {
//        Date dob = new SimpleDateFormat("yyyy-dd-MM").parse(dateOfBirth);
//        Date ecd = new SimpleDateFormat("yyyy-dd-MM").parse(entryCompanyDate);
//        Optional<Office> _office = iOfficeService.findById(office);
//
//        List<Skill> skillList = new ArrayList<>();
//        for (Long item : skills){
//            skillList.add(skillService.findById(item).get());
//        }
//        return new Staff(fullName, email, address, dob, ecd, introduce, _office.get(), skillList);
//    }
}
