package Lab1_TBD.services;

import Lab1_TBD.entities.AbilityEntity;
import Lab1_TBD.entities.InstitutionEntity;
import Lab1_TBD.repositories.AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityService {
    @Autowired
    private AbilityRepository abilityRepository;

    public void save(AbilityEntity abilityEntity) {
        abilityRepository.save(abilityEntity);
    }

    public List<AbilityEntity> getAll() {
        return abilityRepository.findAll();
    }

    public AbilityEntity getById(long id) {
        return abilityRepository.findById(id);
    }

    public void delete(Long id) {
        abilityRepository.deleteById(id);
    }

}
