package Lab1_TBD.controllers;

import Lab1_TBD.entities.InstitutionEntity;
import Lab1_TBD.entities.Task_AbilityEntity;
import Lab1_TBD.services.Task_AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/task_ability")
public class Task_AbilityController {

    @Autowired
    private Task_AbilityService task_abilityService;

    @GetMapping("/{id}")
    public ResponseEntity<Task_AbilityEntity> getTask_Ability(@PathVariable Long id) {
        Task_AbilityEntity task_ability = task_abilityService.getById(id);
        return ResponseEntity.ok(task_ability);
    }

    @GetMapping("/")
    public ResponseEntity<List<Task_AbilityEntity>> getAllTask_Ability() {
        List<Task_AbilityEntity>  task_ability = task_abilityService.getAll();
        return ResponseEntity.ok(task_ability);
    }

    @PostMapping("/")
    public void addTask_Ability(@RequestBody Task_AbilityEntity task_ability) {
        task_abilityService.save(task_ability);
    }

    @DeleteMapping("/{id}")
    public void deleteTask_Ability(@PathVariable Long id) {
        task_abilityService.delete(id);
    }
}
