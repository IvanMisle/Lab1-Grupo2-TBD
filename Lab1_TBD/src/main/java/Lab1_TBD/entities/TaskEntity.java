package Lab1_TBD.entities;

public class TaskEntity {

    private Long id;
    private String name_task;
    private String description;
    private Long id_emergency;
    private Long id_task_state;

    //Constructores
    public TaskEntity() {
    }

    public TaskEntity(Long id, Long id_task_state, String description, Long id_emergency, String name_task) {
        this.id = id;
        this.id_task_state = id_task_state;
        this.description = description;
        this.id_emergency = id_emergency;
        this.name_task = name_task;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_task_state() {
        return id_task_state;
    }

    public void setId_task_state(Long id_task_state) {
        this.id_task_state = id_task_state;
    }

    public Long getId_emergency() {
        return id_emergency;
    }

    public void setId_emergency(Long id_emergency) {
        this.id_emergency = id_emergency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName_task() {
        return name_task;
    }

    public void setName_task(String name_task) {
        this.name_task = name_task;
    }
}
