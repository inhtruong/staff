package com.ait.staffmanagement.repository;

import com.ait.staffmanagement.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository<Skill,Long> {
}
