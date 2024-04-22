package Lab1_TBD.services;

import Lab1_TBD.entities.AbilityEntity;
import Lab1_TBD.repositories.AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityService {
    @Autowired
    private AbilityRepository abilityRepository;

    public AbilityEntity save(AbilityEntity abilityEntity) {
        return abilityRepository.save(abilityEntity);
    }

    public List<AbilityEntity> getAll() {
        return abilityRepository.findAll();
    }

    public AbilityEntity getById(Long id) {
        return abilityRepository.findById(id);
    }

    public boolean delete(Long id) {
        return abilityRepository.deleteById(id);
    }

    public AbilityEntity update(AbilityEntity abilityEntity) {
        return abilityRepository.update(abilityEntity);
    }

    public List<Integer> getAbilitybyIdtask(Long id){
        return abilityRepository.getAbilitybyIdtask(id);
    }

}
