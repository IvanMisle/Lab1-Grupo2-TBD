package Lab1_TBD.repositories;

import Lab1_TBD.entities.AbilityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class AbilityRepositoryImp implements AbilityRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public AbilityEntity save(AbilityEntity abilityEntity) {
        String sql = "INSERT INTO ability VALUES (:id, :name)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id", abilityEntity.getId())
                    .addParameter("name", abilityEntity.getName())
                    .executeUpdate();
            return abilityEntity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<AbilityEntity> findAll() {
        String sql = "SELECT * FROM ability";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(AbilityEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public AbilityEntity findById(Long id) {
        String sql = "SELECT * FROM ability WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(AbilityEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE FROM ability WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public AbilityEntity update(AbilityEntity abilityEntity) {
        String sql = "UPDATE ability SET name = :name WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", abilityEntity.getName())
                    .addParameter("id", abilityEntity.getId())
                    .executeUpdate();
            return abilityEntity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}