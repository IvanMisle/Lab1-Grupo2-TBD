package Lab1_TBD.services;

import Lab1_TBD.entities.TaskAbilityEntity;
import Lab1_TBD.repositories.TaskAbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAbilityService {
    @Autowired

    private TaskAbilityRepository task_abilityRepository;

    public void save(TaskAbilityEntity task_abilityEntity) {
        task_abilityRepository.save(task_abilityEntity);
    }

    public List<TaskAbilityEntity> getAll() {
        return task_abilityRepository.findAll();
    }

    public TaskAbilityEntity getById(Long id) {
        return task_abilityRepository.findById(id);
    }

    public void delete(long id) {
        task_abilityRepository.deleteById(id);
    }
}
