package Lab1_TBD.entities;

public class AbilityEntity {
    private Long id;
    private String name;

  //Constructores
    public AbilityEntity() {
    }
    public AbilityEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
