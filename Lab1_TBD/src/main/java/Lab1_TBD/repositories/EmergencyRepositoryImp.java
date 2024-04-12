package Lab1_TBD.repositories;

import Lab1_TBD.entities.EmergencyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class EmergencyRepositoryImp implements EmergencyRepository{

    @Autowired
    private Sql2o sql2o;


    @Override
    public EmergencyEntity save(EmergencyEntity emergency) {
        try(Connection con = sql2o.open()) {
            con.createQuery("INSERT INTO emergency (id, id_institution, state, name, description, responsible_coordinator)" +
                            "values (:id, :id_institution, :state, :name, :description, :responsible_coordinator)")
                    .addParameter("id", emergency.getId())
                    .addParameter("id_institution", emergency.getId_institution())
                    .addParameter("state", emergency.getState())
                    .addParameter("name", emergency.getName())
                    .addParameter("description", emergency.getDescription())
                    .addParameter("responsible_coordinator", emergency.getResponsible_coordinator())
                    .executeUpdate().getKey();
            return emergency;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public EmergencyEntity findById(Long id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM emergency WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(EmergencyEntity.class);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public EmergencyEntity update(EmergencyEntity emergency) {
        try(Connection con = sql2o.open()){
            con.createQuery("UPDATE emergency SET id = :id, id_institution = :id_institution, state = :state," +
                    " name = :name, description = :description, responsible_coordinator = :responsible_coordinator")
                    .addParameter("id", emergency.getId())
                    .addParameter("id_institution", emergency.getId_institution())
                    .addParameter("state", emergency.getState())
                    .addParameter("name", emergency.getName())
                    .addParameter("description", emergency.getDescription())
                    .addParameter("responsible_coordinator", emergency.getResponsible_coordinator())
                    .executeUpdate();
            return emergency;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteById(Long id){
        int deletedEmergency;
        try(Connection con = sql2o.open()) {
            deletedEmergency =  con.createQuery("DELETE FROM emergency WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate().getResult();
            return deletedEmergency == 1;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
