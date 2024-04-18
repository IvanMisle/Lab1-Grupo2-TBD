package Lab1_TBD.repositories;

import Lab1_TBD.entities.AbilityEntity;

import java.util.List;

public interface AbilityRepository {

    AbilityEntity save(AbilityEntity abilityEntity);

    List<AbilityEntity> findAll();

    AbilityEntity findById(Long id);

    boolean deleteById(Long id);

    AbilityEntity update(AbilityEntity abilityEntity);
}
