package Lab1_TBD.repositories;

import Lab1_TBD.entities.RankingEntity;

import java.util.List;

public interface RankingRepository {
    void save(RankingEntity rankingEntity);
    List<RankingEntity> findAll();
    RankingEntity findById(Long id);
    void deleteById(Long id);
}
