package Lab1_TBD.repositories;

import Lab1_TBD.entities.VolunteerEntity;

import java.util.List;

public interface VolunteerRepository {
    VolunteerEntity save(VolunteerEntity volunteer);
    List<VolunteerEntity> findAll();
    VolunteerEntity findById(Long id);
    VolunteerEntity update(VolunteerEntity volunteer);
    boolean deleteById(Long id);
}