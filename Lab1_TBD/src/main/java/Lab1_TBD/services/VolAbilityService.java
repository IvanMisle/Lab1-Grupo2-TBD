package Lab1_TBD.services;

import Lab1_TBD.entities.VolAbilityEntity;
import Lab1_TBD.repositories.VolAbilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolAbilityService {

    private  VolAbilityRepository volAbilityRepository;
    VolAbilityService(VolAbilityRepository volAbilityRepository){
        this.volAbilityRepository = volAbilityRepository;
    }

    public VolAbilityEntity saveVolAbility(VolAbilityEntity volAbility){
        return volAbilityRepository.save(volAbility);
    }

    public VolAbilityEntity getVolAbilityById(Long id){
        return volAbilityRepository.findById(id);
    }

    public boolean deleteVolAbility(Long id){
        return volAbilityRepository.deleteById(id);
    }

    public VolAbilityEntity updateVolAbility(VolAbilityEntity volAbility){
        return volAbilityRepository.update(volAbility);
    }

    public boolean volHaveAbility(Long id_volunteer, Long id_ability){
        return volAbilityRepository.volHaveAbility(id_volunteer, id_ability);
    }
}