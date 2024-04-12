package Lab1_TBD.controllers;

import Lab1_TBD.entities.VolunteerEntity;
import Lab1_TBD.services.VolunteerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class VolunteerController{

    private final VolunteerService volunteerService;
    VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @PostMapping("/volunteer")
    public ResponseEntity<VolunteerEntity> saveVolunteer(@RequestBody VolunteerEntity volunteer) {
        VolunteerEntity newVolunteer = volunteerService.saveVolunteer(volunteer);
        return ResponseEntity.ok(newVolunteer);
    }

    @GetMapping("/volunteer/{id}")
    public ResponseEntity<VolunteerEntity> getVolunteerById(@PathVariable Long id) {
        VolunteerEntity newVolunteer = volunteerService.getVolunteerById(id);
        return ResponseEntity.ok(newVolunteer);
    }

    @PutMapping("/volunteer/{id}")
    public ResponseEntity<VolunteerEntity> updateVolunteer(@PathVariable Long id, @RequestBody VolunteerEntity volunteer) {
        volunteer.setId(id);
        EmergencyEntity updatedVolunteer = volunteerService.updateVolunteer(volunteer);
        return ResponseEntity.ok(updatedVolunteer);
    }

    @DeleteMapping("/volunteer/{id}")
    public ResponseEntity<Boolean> deleteVolunteer(@PathVariable Long id) {
        var isDeleted = volunteerService.deleteVolunteer(id);
        return ResponseEntity.ok(isDeleted);
    }
}