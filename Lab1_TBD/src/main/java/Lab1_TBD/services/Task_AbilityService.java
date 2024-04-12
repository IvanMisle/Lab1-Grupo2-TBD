package Lab1_TBD.services;

import Lab1_TBD.entities.Task_AbilityEntity;
import Lab1_TBD.repositories.Task_AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Task_AbilityService {
    @Autowired

    private Task_AbilityRepository task_abilityRepository;

    public void save(Task_AbilityEntity task_abilityEntity) {
        task_abilityRepository.save(task_abilityEntity);
    }

    public List<Task_AbilityEntity> getAll() {
        return task_abilityRepository.findAll();
    }

    public Task_AbilityEntity getById(Long id) {
        return task_abilityRepository.findById(id);
    }

    public void delete(long id) {
        task_abilityRepository.deleteById(id);
    }
}
