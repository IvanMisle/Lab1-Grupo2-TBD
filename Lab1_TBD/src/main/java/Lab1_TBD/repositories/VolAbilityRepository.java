package Lab1_TBD.repositories;

import Lab1_TBD.entities.VolAbilityEntity;

import java.util.List;

public interface VolAbilityRepository {
    public void save(VolAbilityEntity volAbilityEntity);
    public List<VolAbilityEntity> findAll();
    public VolAbilityEntity findById(Long id);
    public void deleteById(Long id);
}