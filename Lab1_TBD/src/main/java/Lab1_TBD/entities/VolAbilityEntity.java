package Lab1_TBD.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class VolAbilityEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    private Long id_ability;
    private Long id_volunteer;

    public Long getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public Long getIdVolunteer(){
        return id_volunteer;
    }

    public void setIdVolunteer(Long id){
        this.id_volunteer = id;
    }

    public Long getIdAbility(){
        return id_ability;
    }

    public void setIdAbility(Long id){
        this.id_ability = id;
    }

    public VolAbilityEntity(Long id_volunteer, Long id_ability){
        this.id_volunteer = id_volunteer;
        this.id_ability = id_ability;
    }
}