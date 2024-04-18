package Lab1_TBD.repositories;

import Lab1_TBD.entities.InstitutionEntity;
import Lab1_TBD.entities.RankingEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface InstitutionRepository {
    InstitutionEntity save(InstitutionEntity institutionEntity);
    List<InstitutionEntity> findAll();
    InstitutionEntity findById(Long id);
    boolean deleteById(Long id);
    InstitutionEntity update(InstitutionEntity institutionEntity);
}
