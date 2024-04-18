package Lab1_TBD.repositories;

import Lab1_TBD.entities.RankingEntity;

import java.util.List;

public interface RankingRepository {
    RankingEntity save(RankingEntity rankingEntity);
    List<RankingEntity> findAll();
    RankingEntity findById(Long id);
    boolean deleteById(Long id);
    RankingEntity update(RankingEntity rankingEntity);
}
