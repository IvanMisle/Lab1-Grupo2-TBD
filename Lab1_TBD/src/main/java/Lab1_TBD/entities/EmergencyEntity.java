package Lab1_TBD.entities;


public class EmergencyEntity {
    private Long id;
    private Long id_institution;
    private boolean state;
    private String name;
    private String description;
    private String responsible_coordinator;

    //Constructores
    public EmergencyEntity() {
    }

    public EmergencyEntity(Long id, String description, String responsible_coordinator, boolean state, String name, Long id_institution) {
        this.id = id;
        this.description = description;
        this.responsible_coordinator = responsible_coordinator;
        this.state = state;
        this.name = name;
        this.id_institution = id_institution;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponsible_coordinator() {
        return responsible_coordinator;
    }

    public void setResponsible_coordinator(String responsible_coordinator) {
        this.responsible_coordinator = responsible_coordinator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Long getId_institution() {
        return id_institution;
    }

    public void setId_institution(Long id_institution) {
        this.id_institution = id_institution;
    }
}
