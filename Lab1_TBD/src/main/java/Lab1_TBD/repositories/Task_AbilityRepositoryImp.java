package Lab1_TBD.repositories;

import Lab1_TBD.entities.RankingEntity;
import Lab1_TBD.entities.Task_AbilityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Task_AbilityRepositoryImp implements Task_AbilityRepository{
    @Autowired
    Sql2o sql2o;

    @Override
    public void save(Task_AbilityEntity task_abilityEntity) {
        String sql = "INSERT INTO task_ability VALUES (:id, :id_task_ability, :id_task)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id", task_abilityEntity.getId())
                    .addParameter("id_task_ability", task_abilityEntity.getId_task_ability())
                    .addParameter("id_task", task_abilityEntity.getId_task())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Task_AbilityEntity> findAll() {
        String sql = "SELECT * FROM task_ability";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Task_AbilityEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Task_AbilityEntity findById(Long id) {
        String sql = "SELECT * FROM task_ability WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Task_AbilityEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteById(long id) {
        String sql = "DELETE FROM task_ability WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
