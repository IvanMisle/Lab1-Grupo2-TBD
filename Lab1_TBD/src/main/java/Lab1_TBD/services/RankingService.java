package Lab1_TBD.services;

import Lab1_TBD.entities.RankingEntity;
import Lab1_TBD.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {
    @Autowired
    private RankingRepository rankingRepository;

    public RankingEntity getById(Long id) {
        return rankingRepository.findById(id);
    }

    public List<RankingEntity> getAll() {
        return rankingRepository.findAll();
    }

    public void save(RankingEntity rankingEntity) {
        rankingRepository.save(rankingEntity);
    }

    public void delete(Long id) {
        rankingRepository.deleteById(id);
    }
}
