package Lab1_TBD.entities;

public class VolAbilityEntity {
    private Long id;

    private Long id_ability;
    private Long id_volunteer;

    //Constructores
    public VolAbilityEntity() {
    }

    public VolAbilityEntity(Long id, Long id_volunteer, Long id_ability) {
        this.id = id;
        this.id_volunteer = id_volunteer;
        this.id_ability = id_ability;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_ability() {
        return id_ability;
    }

    public void setId_ability(Long id_ability) {
        this.id_ability = id_ability;
    }

    public Long getId_volunteer() {
        return id_volunteer;
    }

    public void setId_volunteer(Long id_volunteer) {
        this.id_volunteer = id_volunteer;
    }
}