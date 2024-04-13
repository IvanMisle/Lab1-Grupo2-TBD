package Lab1_TBD.repositories;


import Lab1_TBD.entities.TaskEntity;

public interface TaskRepository {
    public TaskEntity save(TaskEntity task);
    TaskEntity findById(Long id);
    public TaskEntity update(TaskEntity task);
    public boolean deleteById(Long id);

}
