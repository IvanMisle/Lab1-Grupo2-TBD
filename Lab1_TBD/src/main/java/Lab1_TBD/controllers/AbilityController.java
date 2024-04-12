package Lab1_TBD.controllers;

import Lab1_TBD.entities.AbilityEntity;
import Lab1_TBD.services.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ability")
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

    @PostMapping("/")
    public void addAbility(@RequestBody AbilityEntity ability) {
        abilityService.save(ability);
    }

    @DeleteMapping("/{id}")
    public void deleteAbility(@PathVariable Long id) {
        abilityService.delete(id);
    }
}





}
