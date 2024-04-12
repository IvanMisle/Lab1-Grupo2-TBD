package Lab1_TBD.services;

import Lab1_TBD.entities.InstitutionEntity;
import Lab1_TBD.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionService {
    @Autowired
    private InstitutionRepository institutionRepository;

    public InstitutionEntity getById(Long id) {
        return institutionRepository.findById(id);
    }

    public List<InstitutionEntity> getAll() {
        return institutionRepository.findAll();
    }

    public void save(InstitutionEntity institutionEntity) {
        institutionRepository.save(institutionEntity);
    }

    public void delete(Long id) {
        institutionRepository.deleteById(id);
    }
}
