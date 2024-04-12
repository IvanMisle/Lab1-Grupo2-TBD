package Lab1_TBD.controllers;

import Lab1_TBD.entities.InstitutionEntity;
import Lab1_TBD.services.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institution")
public class InstitutionController {
    @Autowired
    private InstitutionService institutionService;

    @GetMapping("/{id}")
    public ResponseEntity<InstitutionEntity> getInstitution(@PathVariable Long id) {
        InstitutionEntity institution = institutionService.getById(id);
        return ResponseEntity.ok(institution);
    }

    @GetMapping("/")
    public ResponseEntity<List<InstitutionEntity>> getAllInstitution() {
        List<InstitutionEntity> institutions = institutionService.getAll();
        return ResponseEntity.ok(institutions);
    }

    @PostMapping("/")
    public void addInstitution(@RequestBody InstitutionEntity institution) {
        institutionService.save(institution);
    }

    @DeleteMapping("/{id}")
    public void deleteInstitution(@PathVariable Long id) {
        institutionService.delete(id);
    }
}
