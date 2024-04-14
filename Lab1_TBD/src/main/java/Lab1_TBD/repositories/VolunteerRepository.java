package Lab1_TBD.repositories;

import Lab1_TBD.entities.VolunteerEntity;

public interface VolunteerRepository {
    public VolunteerEntity save(TaskEntity volunteer);
    public List<VolunteerEntity> findAll();
    public VolunteerEntity findById(Long id);
    public VolunteerEntity update(VolunteerEntity volunteer);
    public boolean deleteById(Long id);
}