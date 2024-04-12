package Lab1_TBD.repositories;

import Lab1_TBD.entities.TaskAbilityEntity;

import java.util.List;



public interface TaskAbilityRepository {

    void save(TaskAbilityEntity task_abilityEntity);

    List<TaskAbilityEntity> findAll();

    TaskAbilityEntity findById(Long id);

    void deleteById(long id);


}
