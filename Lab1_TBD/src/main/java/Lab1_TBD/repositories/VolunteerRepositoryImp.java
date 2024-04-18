package Lab1_TBD.repositories;

import Lab1_TBD.entities.VolunteerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VolunteerRepositoryImp implements VolunteerRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public VolunteerEntity save(VolunteerEntity volunteer) {
        try(Connection con = sql2o.open()) {
            con.createQuery("INSERT INTO volunteer (id, availability, name, password, age)" +
                            "VALUES (:id, :availability, :name, :password, :age)")
                    .addParameter("id", volunteer.getId())
                    .addParameter("availability", volunteer.getAvailability())
                    .addParameter("name", volunteer.getName())
                    .addParameter("password", volunteer.getPassword())
                    .addParameter("age", volunteer.getAge())
                    .executeUpdate().getKey();
            return volunteer;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VolunteerEntity> findAll() {
        String sql = "SELECT * FROM volunteer";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(VolunteerEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public VolunteerEntity findById(Long id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM volunteer WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(VolunteerEntity.class);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public VolunteerEntity update(VolunteerEntity volunteer) {
        try(Connection con = sql2o.open()){
            con.createQuery("UPDATE volunteer SET availability = :availability, name = :name, " +
                            "password = :password, age = :age WHERE id = :id")
                    .addParameter("id", volunteer.getId())
                    .addParameter("availability", volunteer.getAvailability())
                    .addParameter("name", volunteer.getName())
                    .addParameter("password", volunteer.getPassword())
                    .addParameter("age", volunteer.getAge())
                    .executeUpdate();
            return volunteer;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteById(Long id){
        int deletedVolunteer;
        try(Connection con = sql2o.open()) {
            deletedVolunteer = con.createQuery("DELETE FROM volunteer WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate().getResult();
            return deletedVolunteer == 1;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}