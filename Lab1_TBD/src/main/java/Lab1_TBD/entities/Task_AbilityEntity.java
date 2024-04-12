package Lab1_TBD.entities;

public class Task_AbilityEntity {

    private Long id;
    private Long id_task_ability;
    private Long id_task;

    //Constructor

    public Task_AbilityEntity(Long id, Long id_task_ability, Long id_task) {
        this.id = id;
        this.id_task_ability = id_task_ability;
        this.id_task = id_task;
    }


    //Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_task_ability() {
        return id_task_ability;
    }

    public void setId_task_ability(Long id_task_ability) {
        this.id_task_ability = id_task_ability;
    }

    public Long getId_task() {
        return id_task;
    }

    public void setId_task(Long id_task) {
        this.id_task = id_task;
    }
}
