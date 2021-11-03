package com.ait.staffmanagement.model.DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DisplayDTO {

    private Long id;
    private String fullName;
    private String email;
    private String address;
    private Date dateOfBirth;
    private Date entryCompanyDate;
    private String office;

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

    public String getDateOfBirth() {
        return new SimpleDateFormat("dd/MM/yyyy").format(dateOfBirth);
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEntryCompanyDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(entryCompanyDate) ;
    }

    public void setEntryCompanyDate(Date entryCompanyDate) {
        this.entryCompanyDate = entryCompanyDate;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public DisplayDTO(Long id, String fullName, String email, String address, Date dateOfBirth, Date entryCompanyDate, String office) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.entryCompanyDate = entryCompanyDate;
        this.office = office;
    }
}
