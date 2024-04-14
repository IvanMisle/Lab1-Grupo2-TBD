package Lab1_TBD.services;

import Lab1_TBD.entities.EmeAbilityEntity;
import Lab1_TBD.repositories.EmeAbilityRepository;

public class EmeAbilityService {

    private final EmeAbilityRepository emeAbilityRepository;
    EmeAbilityService(EmeAbilityRepository emeAbilityRepository) { this.emeAbilityRepository = emeAbilityRepository; }

    public EmeAbilityEntity saveEmeAbility(EmeAbilityEntity emeAbilityEntity) { return emeAbilityRepository.save(emeAbilityEntity); }
    public EmeAbilityEntity getEmeAbilityById(Long id) { return emeAbilityRepository.findById(id); }
    public EmeAbilityEntity updateEmeAbility(EmeAbilityEntity emeAbilityEntity) { return emeAbilityRepository.update(emeAbilityEntity); }
    public boolean deleteEmeAbility(Long id) { return emeAbilityRepository.deleteById(id); }
}
