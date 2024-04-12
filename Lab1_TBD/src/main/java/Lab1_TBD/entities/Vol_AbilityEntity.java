package Lab1_TBD.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Vol_AbilityEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @ManyToOne
    @JoinColumn(name = "volunteer_id", nullable = false)
    @NotNull
    private VolunteerEntity volunteer;

    @ManyToOne
    @JoinColumn(name = "ability_id", nullable = false)
    @NotNull
    private AbilityEntity ability;

    public Long getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public VolunteerEntity getVolunteer(){
        return volunteer;
    }

    public void setVolunteer(VolunteerEntity volunteer){
        this.volunteer = volunteer;
    }

    public AbilityEntity getAbility(){
        return ability;
    }

    public void setAbility(AbilityEntity ability){
        this.ability = ability;
    }

    public Vol_AbilityEntity(VolunteerEntity volunteer, AbilityEntity ability){
        this.volunteer = volunteer;
        this.ability = ability;
    }
}