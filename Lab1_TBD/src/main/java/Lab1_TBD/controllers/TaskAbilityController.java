package Lab1_TBD.controllers;

import Lab1_TBD.entities.TaskAbilityEntity;
import Lab1_TBD.services.TaskAbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/task_ability")
@CrossOrigin("*")
public class TaskAbilityController {

    @Autowired
    private TaskAbilityService task_abilityService;

    @GetMapping("/{id}")
    public ResponseEntity<TaskAbilityEntity> getTask_Ability(@PathVariable Long id) {
        TaskAbilityEntity task_ability = task_abilityService.getById(id);
        return ResponseEntity.ok(task_ability);
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskAbilityEntity>> getAllTask_Ability() {
        List<TaskAbilityEntity>  task_ability = task_abilityService.getAll();
        return ResponseEntity.ok(task_ability);
    }

    @PostMapping("/")
    public ResponseEntity<TaskAbilityEntity> addTask_Ability(@RequestBody TaskAbilityEntity task_ability) {
        TaskAbilityEntity newTaskAbility = task_abilityService.save(task_ability);
        return ResponseEntity.ok(newTaskAbility);
    }

    @PutMapping("/")
    public ResponseEntity<TaskAbilityEntity> updateTask_Ability(@RequestBody TaskAbilityEntity task_ability) {
        TaskAbilityEntity newTaskAbility = task_abilityService.update(task_ability);
        return ResponseEntity.ok(newTaskAbility);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTask_Ability(@PathVariable Long id) {
        return task_abilityService.delete(id);
    }
}
