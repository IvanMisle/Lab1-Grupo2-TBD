package Lab1_TBD.controllers;

import Lab1_TBD.entities.EmeAbilityEntity;
import Lab1_TBD.services.EmeAbilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class EmeAbilityController {

    private final EmeAbilityService emeAbilityService;
    EmeAbilityController(EmeAbilityService emeAbilityService) { this.emeAbilityService = emeAbilityService; }

    @PostMapping("/eme_ability")
    public ResponseEntity<EmeAbilityEntity> saveEmeAbility(@RequestBody EmeAbilityEntity emeAbility) {
        EmeAbilityEntity newEmeAbility = emeAbilityService.saveEmeAbility(emeAbility);
        return ResponseEntity.ok(newEmeAbility);
    }
    @GetMapping("/eme_ability/{id}")
    public ResponseEntity<EmeAbilityEntity> getEmeAbilityById(@PathVariable Long id) {
        EmeAbilityEntity newEmeAbility = emeAbilityService.getEmeAbilityById(id);
        return ResponseEntity.ok(newEmeAbility);
    }
    @PutMapping("/eme_ability/{id}")
    public ResponseEntity<EmeAbilityEntity> updateEmeAbility(@PathVariable Long id, @RequestBody EmeAbilityEntity emeAbility) {
        emeAbility.setId(id);
        EmeAbilityEntity updatedEmeAbility = emeAbilityService.updateEmeAbility(emeAbility);
        return ResponseEntity.ok(updatedEmeAbility);
    }
    @DeleteMapping("/eme_ability/{id}")
    public ResponseEntity<Boolean> deleteEmeAbility(@PathVariable Long id) {
        var isDeleted = emeAbilityService.deleteEmeAbility(id);
        return ResponseEntity.ok(isDeleted);
    }
}
