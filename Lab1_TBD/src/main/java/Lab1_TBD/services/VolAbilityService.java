package Lab1_TBD.services;

import Lab1_TBD.entities.VolAbilityEntity;
import Lab1_TBD.repositories.VolAbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class VolAbilityService {

    private  VolAbilityRepository volAbilityRepository;

    VolAbilityService(VolAbilityRepository volAbilityRepository){
        this.volAbilityRepository = volAbilityRepository;
    }

    public VolAbilityEntity saveVolAbility(VolAbilityEntity volAbility){
        return volAbilityRepository.save(volAbility);
        }
    
    public List<VolAbilityEntity> getAllVolAbility(){
        return volAbilityRepository.findAll();
    }

    public VolAbilityEntity getVolAbilityById(Long id){
        return volAbilityRepository.findById(id);
        }

    public boolean deleteVolAbility(Long id){
        return volAbilityRepository.deleteById(id);
        }
}