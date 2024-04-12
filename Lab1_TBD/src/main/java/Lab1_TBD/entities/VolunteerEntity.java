package Lab1_TBD.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class VolunteerEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    private Boolean availability;
    private String name;
    private String password;
    private Long age;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Boolean getAvailability(){
        return availability;
    }

    public void setAvailability(Boolean availability){
        this.availability = availability;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Long age getAge(){
        return age;
    }

    public void setAge(Long age){
        this.age = age;
    }

    public VolunteerEntity(Boolean availability, String name, String password, Long age){
        this.availability = availability;
        this.name = name;
        this.password = password;
        this.age = age;
    }
}