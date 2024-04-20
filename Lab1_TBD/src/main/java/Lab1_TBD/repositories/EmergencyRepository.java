package Lab1_TBD.repositories;

import Lab1_TBD.entities.EmergencyEntity;

import java.util.List;

public interface EmergencyRepository {

    EmergencyEntity save(EmergencyEntity emergency);
    EmergencyEntity findById(Long id);
    EmergencyEntity update(EmergencyEntity emergency);
    boolean deleteById(Long id);
    List<EmergencyEntity> findAll();
    Integer getActiveTasksByIdEmergency(Long id);
}
