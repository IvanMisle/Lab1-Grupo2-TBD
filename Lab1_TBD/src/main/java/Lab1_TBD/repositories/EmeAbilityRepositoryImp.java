package Lab1_TBD.repositories;

import Lab1_TBD.entities.EmeAbilityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class EmeAbilityRepositoryImp implements EmeAbilityRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public EmeAbilityEntity save(EmeAbilityEntity emeAbility) {
        try (Connection con = sql2o.open()) {
            con.createQuery("INSERT INTO emeAbility (id, id_emergency, id_ability)" +
                    "values (:id, :id_emergency, :id_ability)")
                    .addParameter("id", emeAbility.getId())
                    .addParameter("id_emergency", emeAbility.getId_emergency())
                    .addParameter("id_ability", emeAbility.getId_ability())
                    .executeUpdate().getKey();
            return emeAbility;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public EmeAbilityEntity findById(Long id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT *  FROM emeAbility WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(EmeAbilityEntity.class);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public EmeAbilityEntity update(EmeAbilityEntity emeAbility) {
        try (Connection con = sql2o.open()) {
            con.createQuery("UPDATE emeAbility SET id = :id, id_emergency = :id_emergency, id_ability = :id_ability")
            .addParameter("id", emeAbility.getId())
            .addParameter("id_emergency", emeAbility.getId_emergency())
            .addParameter("id_ability", emeAbility.getId_ability())
            .executeUpdate();
            return emeAbility;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public boolean deleteById(Long id) {
        int deleteEmeAbility;
        try (Connection con = sql2o.open()) {
            deleteEmeAbility =  con.createQuery("DELETE FROM emeAbility WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate().getResult();
            return deleteEmeAbility == 1;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
