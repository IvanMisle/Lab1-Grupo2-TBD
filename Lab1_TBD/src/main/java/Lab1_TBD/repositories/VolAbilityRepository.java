package Lab1_TBD.repositories;

import Lab1_TBD.entities.VolAbilityEntity;

import java.util.List;

public interface VolAbilityRepository {
    VolAbilityEntity save(VolAbilityEntity volAbilityEntity);
    VolAbilityEntity update(VolAbilityEntity volAbilityEntity);
    VolAbilityEntity findById(Long id);
    boolean deleteById(Long id);
    boolean volHaveAbility(Long id_volunteer, Long id_ability);
}