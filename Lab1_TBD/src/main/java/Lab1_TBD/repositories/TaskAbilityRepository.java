package Lab1_TBD.repositories;

import Lab1_TBD.entities.TaskAbilityEntity;

import java.util.List;



public interface TaskAbilityRepository {

    TaskAbilityEntity save(TaskAbilityEntity task_abilityEntity);

    List<TaskAbilityEntity> findAll();

    TaskAbilityEntity findById(Long id);

    boolean deleteById(Long id);

    TaskAbilityEntity update(TaskAbilityEntity task_abilityEntity);
}
