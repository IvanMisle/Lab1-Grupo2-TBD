package Lab1_TBD.repositories;

import Lab1_TBD.entities.InstitutionEntity;

import java.util.List;

public interface InstitutionRepository {
    void save(InstitutionEntity institutionEntity);
    List<InstitutionEntity> findAll();
    InstitutionEntity findById(Long id);
    void deleteById(Long id);
}
