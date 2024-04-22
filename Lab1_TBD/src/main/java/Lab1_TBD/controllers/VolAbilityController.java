package Lab1_TBD.controllers;

import Lab1_TBD.entities.VolAbilityEntity;
import Lab1_TBD.services.VolAbilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/volAbility")
public class VolAbilityController {

    private final VolAbilityService volAbilityService;
    VolAbilityController(VolAbilityService volAbilityService) {
        this.volAbilityService = volAbilityService;
    }

    @PostMapping("/volAbility")
    public ResponseEntity<VolAbilityEntity> saveVolAbility(@RequestBody VolAbilityEntity volAbility) {
        VolAbilityEntity newVolAbility = volAbilityService.saveVolAbility(volAbility);
        return ResponseEntity.ok(newVolAbility);
    }

    @GetMapping("/volAbility/{id}")
    public ResponseEntity<VolAbilityEntity> getVolAbilityById(@PathVariable Long id) {
        VolAbilityEntity newVolAbility = volAbilityService.getVolAbilityById(id);
        return ResponseEntity.ok(newVolAbility);
    }

    @GetMapping("/volHaveAbility/{id_volunteer}/{id_ability}")
    public boolean volHaveAbility(@PathVariable Long id_volunteer, @PathVariable Long id_ability){
        return volAbilityService.volHaveAbility(id_volunteer,id_ability);
    }




    @PutMapping("/volAbility")
    public ResponseEntity<VolAbilityEntity> updateVolAbility(@RequestBody VolAbilityEntity volAbility) {
        VolAbilityEntity newVolAbility = volAbilityService.updateVolAbility(volAbility);
        return ResponseEntity.ok(newVolAbility);
    }

    @DeleteMapping("/volAbility/{id}")
    public ResponseEntity<Boolean> deleteVolAbility(@PathVariable Long id) {
        var isDeleted = volAbilityService.deleteVolAbility(id);
        return ResponseEntity.ok(isDeleted);
    }
}