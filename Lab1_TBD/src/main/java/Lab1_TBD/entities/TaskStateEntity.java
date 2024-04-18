package Lab1_TBD.entities;

public class TaskStateEntity {
    private Long id;
    private boolean state;

    //Constructores
    public TaskStateEntity() {
    }

    public TaskStateEntity(Long id, boolean state) {
        this.id = id;
        this.state = state;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
