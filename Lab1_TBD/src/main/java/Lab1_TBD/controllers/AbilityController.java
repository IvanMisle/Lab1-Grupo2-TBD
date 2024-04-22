package Lab1_TBD.controllers;

import Lab1_TBD.entities.AbilityEntity;
import Lab1_TBD.services.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ability")
@CrossOrigin("*")
public class AbilityController {

    @Autowired
    private AbilityService abilityService;

    @GetMapping("/{id}")
    public ResponseEntity<AbilityEntity> getAbility(@PathVariable Long id) {
        AbilityEntity ability = abilityService.getById(id);
        return ResponseEntity.ok(ability);
    }

    @GetMapping("/")
    public ResponseEntity<List<AbilityEntity>> getAllAbility() {
        List<AbilityEntity> ability = abilityService.getAll();
        return ResponseEntity.ok(ability);
    }

    @GetMapping("/getAbilitybyIdtask/{id}")
    public ResponseEntity<List<Integer>> getAbilityIdtask(@PathVariable Long id){
        List<Integer> abilities = abilityService.getAbilitybyIdtask(id);
        return ResponseEntity.ok(abilities);
    }


    @PostMapping("/")
    public ResponseEntity<AbilityEntity> addAbility(@RequestBody AbilityEntity ability) {
        AbilityEntity newAbilityEntity = abilityService.save(ability);
        return ResponseEntity.ok(newAbilityEntity);
    }

    @PutMapping("/")
    public ResponseEntity<AbilityEntity> updateAbility(@RequestBody AbilityEntity ability) {
        AbilityEntity newAbilityEntity = abilityService.update(ability);
        return ResponseEntity.ok(newAbilityEntity);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAbility(@PathVariable Long id) {
        return abilityService.delete(id);
    }


}