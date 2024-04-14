package Lab1_TBD.services;

import Lab1_TBD.entities.EmergencyEntity;
import Lab1_TBD.repositories.EmergencyRepository;

public class EmergencyService {

    private final EmergencyRepository emergencyRepository;
    EmergencyService(EmergencyRepository emergencyRepository) {
        this.emergencyRepository = emergencyRepository;
    }

    public EmergencyEntity saveEmergency(EmergencyEntity emergency) { return emergencyRepository.save(emergency); }
    public EmergencyEntity getEmergencyById(Long id) { return emergencyRepository.findById(id); }
    public EmergencyEntity updateEmergency(EmergencyEntity emergency) { return emergencyRepository.update(emergency); }
    public boolean deleteEmergency(Long id) { return emergencyRepository.deleteById(id); }
}
