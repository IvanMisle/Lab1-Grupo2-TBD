package Lab1_TBD.repositories;

import Lab1_TBD.entities.EmeAbilityEntity;

public interface EmeAbilityRepository {

    EmeAbilityEntity save(EmeAbilityEntity eme_ability);
    EmeAbilityEntity findById(Long id);
    EmeAbilityEntity update(EmeAbilityEntity eme_ability);
    boolean deleteById(Long id);
}
