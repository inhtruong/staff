package com.ait.staffmanagement.service.skill;

import com.ait.staffmanagement.model.Skill;
import com.ait.staffmanagement.repository.ISkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillService implements ISkillService {

    @Autowired
    private ISkillRepository skillRepository;

    @Override
    public Iterable<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Optional<Skill> findById(long id) {
        return skillRepository.findById(id);
    }

    @Override
    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public void deleteById(long id) {
        skillRepository.deleteById(id);
    }
}
