package Lab1_TBD.services;

import Lab1_TBD.entities.VolunteerEntity;
import Lab1_TBD.repositories.VolunteerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService {

    private  VolunteerRepository volunteerRepository;

    VolunteerService(VolunteerRepository volunteerRepository){
        this.volunteerRepository = volunteerRepository;
    }

    public VolunteerEntity saveVolunteer(VolunteerEntity volunteer){
        return volunteerRepository.save(volunteer);
        }
    
    public List<VolunteerEntity> getAllVolunteer(){
        return volunteerRepository.findAll();
    }

    public VolunteerEntity getVolunteerById(Long id){
        return volunteerRepository.findById(id);
        }

    public boolean deleteVolunteer(Long id){
        return volunteerRepository.deleteById(id);
        }

    public VolunteerEntity updateVolunteer(VolunteerEntity volunteer){
        return volunteerRepository.update(volunteer);
        }
}