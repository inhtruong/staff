package com.ait.staffmanagement.model;

import com.ait.staffmanagement.model.DTO.CreateDTO;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name",nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column (name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column (name = "entry_company_date", nullable = false)
    private Date entryCompanyDate;

    @Column(nullable = false)
    private String introduce;
    
   

    @ManyToOne
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    private Office office;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "staff_skill",
            joinColumns = { @JoinColumn(name = "staff_id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_id") }
    )
    private List<Skill> skills = new ArrayList<>();

    private Boolean isDeleted = true;

    public Staff() {
    }

    public Staff(Long id, String email, String address,
                 Date dateOfBirth, Date entryCompanyDate, Office office, List<Skill> skills) {
        this.id = id;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.entryCompanyDate = entryCompanyDate;
        this.office = office;
        this.skills = skills;
    }

    public Staff(String email, String address,
                 Date dateOfBirth, Date entryCompanyDate, Office office, List<Skill> skills) {
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.entryCompanyDate = entryCompanyDate;
        this.office = office;
        this.skills = skills;
    }

    public Staff(Long id, String fullName, String email, String address,
                 Date dateOfBirth, Date entryCompanyDate, String introduce, Office office, List<Skill> skills) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.entryCompanyDate = entryCompanyDate;
        this.introduce = introduce;
        this.office = office;
        this.skills = skills;
    }

    public Staff(String fullName, String email, String address,
                 Date dateOfBirth, Date entryCompanyDate, String introduce, Office office, List<Skill> skills) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.entryCompanyDate = entryCompanyDate;
        this.introduce = introduce;
        this.office = office;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDateOfBirth() {
        return new SimpleDateFormat("dd/MM/yyyy").format(dateOfBirth);
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEntryCompanyDate() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(entryCompanyDate);
    }

    public void setEntryCompanyDate(Date entryCompanyDate) {
        this.entryCompanyDate = entryCompanyDate;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public CreateDTO toCreateDTO(){
        List<Long> skills_ = new ArrayList<>();
        for (Skill skill: skills){
            skills_.add(skill.getId());
        }
        return new CreateDTO(id, fullName, email
                , address, getDateOfBirth(), getEntryCompanyDate(), introduce, office.getId(), skills_, isDeleted);
    }
}
