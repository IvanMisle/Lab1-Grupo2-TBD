package Lab1_TBD.repositories;

import Lab1_TBD.entities.EmeAbilityEntity;

public interface EmeAbilityRepository {

    public EmeAbilityEntity save(EmeAbilityEntity eme_ability);
    public EmeAbilityEntity findById(Long id);
    public EmeAbilityEntity update(EmeAbilityEntity eme_ability);
    public boolean deleteById(Long id);
}
