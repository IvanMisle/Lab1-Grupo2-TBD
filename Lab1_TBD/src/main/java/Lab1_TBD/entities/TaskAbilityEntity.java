package Lab1_TBD.entities;

public class TaskAbilityEntity {

    private Long id;
    private Long id_eme_ability;
    private Long id_task;

    //Constructor
    public TaskAbilityEntity() {
    }

    public TaskAbilityEntity(Long id, Long id_eme_ability, Long id_task) {
        this.id = id;
        this.id_eme_ability = id_eme_ability;
        this.id_task = id_task;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_task() {
        return id_task;
    }

    public void setId_task(Long id_task) {
        this.id_task = id_task;
    }

    public Long getId_eme_ability() {
        return id_eme_ability;
    }

    public void setId_eme_ability(Long id_eme_ability) {
        this.id_eme_ability = id_eme_ability;
    }
}
