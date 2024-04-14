package Lab1_TBD.services;
import Lab1_TBD.entities.TaskStateEntity;
import Lab1_TBD.repositories.TaskStateRepository;

public class TaskStateService {
    private final TaskStateRepository taskStateRepository;
    TaskStateService(TaskStateRepository taskStateRepository){this.taskStateRepository = taskStateRepository;}
    public TaskStateEntity saveTaskState(TaskStateEntity taskState){return taskStateRepository.save(taskState);}
    public TaskStateEntity getTaskById(Long id){return taskStateRepository.findById(id);}
    public boolean deleteTaskState(Long id){return taskStateRepository.deleteById(id);}
    public TaskStateEntity updateTaskState(TaskStateEntity taskState){return taskStateRepository.update(taskState);}
}
