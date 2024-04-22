package Lab1_TBD.repositories;

import Lab1_TBD.entities.VolAbilityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VolAbilityRepositoryImp implements VolAbilityRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public VolAbilityEntity save(VolAbilityEntity volAbility) {
        try (Connection con = sql2o.open()) {
            con.createQuery("INSERT INTO vol_ability (id, id_volunteer, id_ability)" +
                    "values (:id, :id_volunteer, :id_ability)")
                    .addParameter("id", volAbility.getId())
                    .addParameter("id_volunteer", volAbility.getId_volunteer())
                    .addParameter("id_ability", volAbility.getId_ability())
                    .executeUpdate().getKey();
            return volAbility;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public VolAbilityEntity findById(Long id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT *  FROM vol_ability WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(VolAbilityEntity.class);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public VolAbilityEntity update(VolAbilityEntity volAbility) {
        try (Connection con = sql2o.open()) {
            con.createQuery("UPDATE vol_ability SET id_volunteer = :id_volunteer, id_ability = :id_ability " +
                            "WHERE id = :id")
            .addParameter("id", volAbility.getId())
            .addParameter("id_volunteer", volAbility.getId_volunteer())
            .addParameter("id_ability", volAbility.getId_ability())
            .executeUpdate();
            return volAbility;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public boolean deleteById(Long id) {
        int deleteVolAbility;
        try (Connection con = sql2o.open()) {
            deleteVolAbility =  con.createQuery("DELETE FROM vol_ability WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate().getResult();
            return deleteVolAbility == 1;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean volHaveAbility(Long id_volunteer, Long id_ability){
        String sql = "SELECT id FROM vol_ability WHERE id_ability = :id_ability AND id_volunteer = :id_volunteer";
        try (Connection con = sql2o.open()){
            Integer id = con.createQuery(sql)
                    .addParameter("id_ability", id_ability)
                    .addParameter("id_volunteer", id_volunteer)
                    .executeAndFetchFirst(Integer.class);
            if (id == null){
                return false;

            }
            return true;
        } catch(Exception e) {
        System.out.println(e.getMessage());
        return false;
    }

    }
}