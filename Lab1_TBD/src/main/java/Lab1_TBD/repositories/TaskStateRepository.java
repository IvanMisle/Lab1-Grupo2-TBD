package Lab1_TBD.repositories;

import Lab1_TBD.entities.TaskStateEntity;

public interface TaskStateRepository {
    public TaskStateEntity save(TaskStateEntity taskState);
    TaskStateEntity findById(Long id);
    public TaskStateEntity update(TaskStateEntity taskState);
    public boolean deleteById(Long id);

}
