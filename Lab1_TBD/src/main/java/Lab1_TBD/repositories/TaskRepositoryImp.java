package Lab1_TBD.repositories;

import Lab1_TBD.entities.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class TaskRepositoryImp implements TaskRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public TaskEntity save(TaskEntity task) {
        try(Connection con = sql2o.open()) {
            con.createQuery("INSERT INTO task (id, name_task, description, id_emergency, id_task_state)" +
                            "VALUES (:id, :name_task, :description, :id_emergency, :id_task_state)")
                    .addParameter("id", task.getId())
                    .addParameter("name_task", task.getName_task())
                    .addParameter("description", task.getDescription())
                    .addParameter("id_emergency", task.getId_emergency())
                    .addParameter("id_task_state", task.getId_task_state())
                    .executeUpdate().getKey();
            return task;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public TaskEntity findById(Long id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM task WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(TaskEntity.class);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public TaskEntity update(TaskEntity task) {
        try(Connection con = sql2o.open()){
            con.createQuery("UPDATE task SET name_task = :name_task, description = :description, " +
                            "id_emergency = :id_emergency, id_task_state = :id_task_state WHERE id = :id")
                    .addParameter("id", task.getId())
                    .addParameter("name_task", task.getName_task())
                    .addParameter("description", task.getDescription())
                    .addParameter("id_emergency", task.getId_emergency())
                    .addParameter("id_task_state", task.getId_task_state())
                    .executeUpdate();
            return task;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteById(Long id){
        int deletedTask;
        try(Connection con = sql2o.open()) {
            deletedTask = con.createQuery("DELETE FROM task WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate().getResult();
            return deletedTask == 1;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
