package Lab1_TBD.repositories;

import Lab1_TBD.entities.Task_AbilityEntity;

import java.util.List;



public interface Task_AbilityRepository {

    void save(Task_AbilityEntity task_abilityEntity);

    List<Task_AbilityEntity> findAll();

    Task_AbilityEntity findById(Long id);

    void deleteById(long id);


}
