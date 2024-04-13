package Lab1_TBD.services;


import Lab1_TBD.entities.TaskEntity;
import Lab1_TBD.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class TaskService {


    private  TaskRepository taskRepository;

    TaskService(TaskRepository taskRepository){this.taskRepository = taskRepository;}

    public TaskEntity saveTask(TaskEntity task){return taskRepository.save(task);}

    public TaskEntity getTaskById(Long id){return taskRepository.findById(id);}

    public boolean deleteTask(Long id){return taskRepository.deleteById(id);}

    public TaskEntity updateTask(TaskEntity task){return taskRepository.update(task);}

}
