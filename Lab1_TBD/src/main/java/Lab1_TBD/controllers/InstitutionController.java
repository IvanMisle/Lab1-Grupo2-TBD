package Lab1_TBD.controllers;

import Lab1_TBD.entities.InstitutionEntity;
import Lab1_TBD.services.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institution")
@CrossOrigin("*")
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
    public ResponseEntity<InstitutionEntity> addInstitution(@RequestBody InstitutionEntity institution) {
        InstitutionEntity newInstitution = institutionService.save(institution);
        return ResponseEntity.ok(newInstitution);
    }

    @PutMapping("/")
    public ResponseEntity<InstitutionEntity> updateInstitution(@RequestBody InstitutionEntity institution) {
        InstitutionEntity newInstitution = institutionService.update(institution);
        return ResponseEntity.ok(newInstitution);
    }

    @DeleteMapping("/{id}")
    public boolean deleteInstitution(@PathVariable Long id) {
        return institutionService.delete(id);
    }
}
