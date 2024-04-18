package Lab1_TBD.services;

import Lab1_TBD.entities.InstitutionEntity;
import Lab1_TBD.entities.RankingEntity;
import Lab1_TBD.repositories.InstitutionRepository;
import Lab1_TBD.repositories.RankingRepository;
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

    public InstitutionEntity save(InstitutionEntity institutionEntity) {
        return institutionRepository.save(institutionEntity);
    }

    public boolean delete(Long id) {
        return institutionRepository.deleteById(id);
    }

    public InstitutionEntity update(InstitutionEntity institutionEntity) {
        return institutionRepository.update(institutionEntity);
    }
}