package Lab1_TBD.entities;

public class EmeAbilityEntity {
    private Long id;
    private Long id_emergency;
    private Long id_ability;

    //Constructores
    public EmeAbilityEntity() {
    }

    public EmeAbilityEntity(Long id, Long id_ability, Long id_emergency) {
        this.id = id;
        this.id_ability = id_ability;
        this.id_emergency = id_emergency;
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

    public Long getId_emergency() {
        return id_emergency;
    }

    public void setId_emergency(Long id_emergency) {
        this.id_emergency = id_emergency;
    }
}
