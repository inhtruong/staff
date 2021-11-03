package com.ait.staffmanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String skill;

//    @ManyToMany(mappedBy = "staffs")
//    private List<Staff> staff = new ArrayList<>();

    public Skill() {
    }

    public Skill(Long id, String skill) {
        Id = id;
        this.skill = skill;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
