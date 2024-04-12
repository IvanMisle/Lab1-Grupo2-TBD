package Lab1_TBD.entities;


public class EmergencyEntity {
    private Long id;
    private Long id_institution;
    private boolean state;
    private String name;
    private String description;
    private String responsible_coordinator;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_institution() {
        return id_institution;
    }

    public void setId_institution(Long id_institution) {
        this.id_institution = id_institution;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponsible_coordinator() {
        return responsible_coordinator;
    }

    public void setResponsible_coordinator() {
        this.responsible_coordinator = responsible_coordinator;
    }
}
