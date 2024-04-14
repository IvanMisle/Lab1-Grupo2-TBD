package Lab1_TBD.repositories;

import Lab1_TBD.entities.TaskStateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class TaskStateRepositoryImp implements TaskStateRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public TaskStateEntity save(TaskStateEntity taskState) {
        try (Connection con = sql2o.open()) {
            Long id = (Long) con.createQuery("INSERT INTO task_state (id, state) VALUES (:id, :state)")
                    .addParameter("id", taskState.getId())
                    .addParameter("state", taskState.isState())
                    .executeUpdate().getKey();
            taskState.setId(id);
            return taskState;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public TaskStateEntity findById(Long id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM task_state WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(TaskStateEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public TaskStateEntity update(TaskStateEntity taskState) {
        try (Connection con = sql2o.open()) {
            con.createQuery("UPDATE task_state SET state = :state WHERE id = :id")
                    .addParameter("id", taskState.getId())
                    .addParameter("state", taskState.isState())
                    .executeUpdate();
            return  taskState;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (Connection con = sql2o.open()) {
            int deletedTaskState = con.createQuery("DELETE FROM task_state WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate().getResult();
            return deletedTaskState == 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
