package Lab1_TBD.services;

import Lab1_TBD.entities.RankingEntity;
import Lab1_TBD.entities.VolAbilityEntity;
import Lab1_TBD.entities.VolunteerEntity;
import Lab1_TBD.repositories.AbilityRepository;
import Lab1_TBD.repositories.RankingRepository;
import Lab1_TBD.repositories.VolAbilityRepository;
import Lab1_TBD.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RankingService {
    @Autowired
    private RankingRepository rankingRepository;

    @Autowired
    private AbilityRepository abilityRepository;

    @Autowired
    private VolAbilityRepository volAbilityRepository;

    @Autowired
    private VolunteerRepository volunteerRepository;

    public RankingEntity getById(Long id) {
        return rankingRepository.findById(id);
    }

    public List<RankingEntity> getAll() {
        return rankingRepository.findAll();
    }

    public RankingEntity save(RankingEntity rankingEntity) {
        return rankingRepository.save(rankingEntity);
    }

    public boolean delete(Long id) {
        return rankingRepository.deleteById(id);
    }

    public RankingEntity update(RankingEntity rankingEntity) {
        return rankingRepository.update(rankingEntity);
    }

    public List<RankingEntity> addRankingsByIdTask(Long id_task){
        Integer maxId = rankingRepository.getMaxId();
        List<RankingEntity> rankings = new ArrayList<>();
        List<Integer> id_abilities = abilityRepository.getAbilitybyIdtask(id_task);
        List<VolunteerEntity> volunteers = volunteerRepository.findAll();

        for (VolunteerEntity volunteerEntity : volunteers){
            Long id_volunteer = volunteerEntity.getId();
            Integer level = 0;
            for (Integer id_ability : id_abilities){
                if (volAbilityRepository.volHaveAbility(volunteerEntity.getId(), id_ability.longValue())){
                    level++;

                }

            }
            maxId ++;
            RankingEntity rankingEntity = new RankingEntity(maxId.longValue(), id_task, id_volunteer, level);
            rankings.add(rankingRepository.save(rankingEntity));

        }
        return rankings;

    }
}
