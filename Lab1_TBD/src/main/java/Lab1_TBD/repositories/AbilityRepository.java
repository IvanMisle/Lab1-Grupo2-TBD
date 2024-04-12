package Lab1_TBD.repositories;

import Lab1_TBD.entities.AbilityEntity;

import java.util.List;

public interface AbilityRepository {

    void save(AbilityEntity abilityEntity);

    List<AbilityEntity> findAll();

    AbilityEntity findById(long id);

    void deleteById(Long id);

}
