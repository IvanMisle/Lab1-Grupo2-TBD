package Lab1_TBD.repositories;

import Lab1_TBD.entities.TaskAbilityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TaskAbilityRepositoryImp implements TaskAbilityRepository {
    @Autowired
    Sql2o sql2o;

    @Override
    public TaskAbilityEntity save(TaskAbilityEntity task_abilityEntity) {
        String sql = "INSERT INTO task_ability VALUES (:id, :id_eme_ability, :id_task)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id", task_abilityEntity.getId())
                    .addParameter("id_eme_ability", task_abilityEntity.getId_eme_ability())
                    .addParameter("id_task", task_abilityEntity.getId_task())
                    .executeUpdate();
            return task_abilityEntity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TaskAbilityEntity> findAll() {
        String sql = "SELECT * FROM task_ability";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(TaskAbilityEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public TaskAbilityEntity findById(Long id) {
        String sql = "SELECT * FROM task_ability WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(TaskAbilityEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE FROM task_ability WHERE id = :id";
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
    public TaskAbilityEntity update(TaskAbilityEntity task_abilityEntity) {
        String sql = "UPDATE task_ability " +
                "SET id_eme_ability = :id_eme_ability, id_task = :id_task " +
                "WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id_eme_ability", task_abilityEntity.getId_eme_ability())
                    .addParameter("id_task", task_abilityEntity.getId_task())
                    .addParameter("id", task_abilityEntity.getId())
                    .executeUpdate();
            return task_abilityEntity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
