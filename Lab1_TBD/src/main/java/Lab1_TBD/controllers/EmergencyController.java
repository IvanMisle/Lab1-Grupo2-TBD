package Lab1_TBD.controllers;

import Lab1_TBD.entities.EmergencyEntity;
import Lab1_TBD.services.EmergencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EmergencyController {

    private final EmergencyService emergencyService;
    EmergencyController(EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
    }

    @PostMapping("/emergencies")
    public ResponseEntity<EmergencyEntity> saveEmergency(@RequestBody EmergencyEntity emergency) {
        EmergencyEntity newEmergency = emergencyService.saveEmergency(emergency);
        return ResponseEntity.ok(newEmergency);
    }

    @GetMapping("/emergencies/{id}")
    public ResponseEntity<EmergencyEntity> getEmergencyById(@PathVariable Long id) {
        EmergencyEntity newEmergency = emergencyService.getEmergencyById(id);
        return ResponseEntity.ok(newEmergency);
    }

    @GetMapping("/emergencies")
    public ResponseEntity<List<EmergencyEntity>> getAllEmergencies() {
        List<EmergencyEntity> emergencies = emergencyService.getAll();
        return ResponseEntity.ok(emergencies);
    }

    @GetMapping("/emergencies/getActiveTasksCount/{id}")
    public ResponseEntity<Integer> getActiveTasksCount(@PathVariable Long id) {
        Integer activeTasksCount = emergencyService.getActiveTasksCount(id);
        return ResponseEntity.ok(activeTasksCount);
    }

    @PutMapping("/emergencies/{id}")
    public ResponseEntity<EmergencyEntity> updateEmergency(@PathVariable Long id, @RequestBody EmergencyEntity emergency) {
        emergency.setId(id);
        EmergencyEntity updatedEmergency = emergencyService.updateEmergency(emergency);
        return ResponseEntity.ok(updatedEmergency);
    }

    @DeleteMapping("/emergencies/{id}")
    public ResponseEntity<Boolean> deleteEmergency(@PathVariable Long id) {
        var isDeleted = emergencyService.deleteEmergency(id);
        return ResponseEntity.ok(isDeleted);
    }
}
