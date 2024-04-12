package Lab1_TBD.repositories;

import Lab1_TBD.entities.EmergencyEntity;

public interface EmergencyRepository {

    public EmergencyEntity save(EmergencyEntity emergency);
    public EmergencyEntity findById(Long id);
    public EmergencyEntity update(EmergencyEntity emergency);
    public boolean deleteById(Long id);
}
