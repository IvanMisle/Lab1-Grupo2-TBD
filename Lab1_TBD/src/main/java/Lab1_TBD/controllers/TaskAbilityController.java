package Lab1_TBD.controllers;

import Lab1_TBD.entities.TaskAbilityEntity;
import Lab1_TBD.services.TaskAbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/task_ability")
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
    public void addTask_Ability(@RequestBody TaskAbilityEntity task_ability) {
        task_abilityService.save(task_ability);
    }

    @DeleteMapping("/{id}")
    public void deleteTask_Ability(@PathVariable Long id) {
        task_abilityService.delete(id);
    }
}
