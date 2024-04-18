package Lab1_TBD.controllers;
import Lab1_TBD.entities.TaskEntity;
import Lab1_TBD.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RequestMapping("/task")
@RestController
public class TaskController {
    private TaskService taskService;
    TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskEntity> saveEntity(@RequestBody TaskEntity task){
        TaskEntity newTask = taskService.saveTask(task);
        return ResponseEntity.ok(newTask);
    }
    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable Long id) {
        TaskEntity newTask = taskService.getTaskById(id);
        return ResponseEntity.ok(newTask);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable Long id,
                                                 @RequestBody TaskEntity task){
        task.setId(id);
        TaskEntity updateTask = taskService.updateTask(task);
        return ResponseEntity.ok(updateTask);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable long id){
        var isDeleted = taskService.deleteTask(id);
        return  ResponseEntity.ok(isDeleted);
    }
}
