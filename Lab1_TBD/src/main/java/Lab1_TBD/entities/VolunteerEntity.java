package Lab1_TBD.entities;

public class VolunteerEntity {
    private Long id;

    private Boolean availability;
    private String name;
    private String password;
    private Long age;

    //Constructores
    public VolunteerEntity() {
    }

    public VolunteerEntity(Long id, Boolean availability, String name, String password, Long age) {
        this.id = id;
        this.availability = availability;
        this.name = name;
        this.password = password;
        this.age = age;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}