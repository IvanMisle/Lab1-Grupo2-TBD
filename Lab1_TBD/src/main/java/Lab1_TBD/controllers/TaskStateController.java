package Lab1_TBD.controllers;

import Lab1_TBD.entities.TaskEntity;
import Lab1_TBD.entities.TaskStateEntity;
import Lab1_TBD.services.TaskStateService;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/task_state")
public class TaskStateController {
    private TaskStateService taskStateService;
    TaskStateController(TaskStateService taskStateService){
        this.taskStateService = taskStateService;
    }
    @PostMapping("/tasks_states")
    public ResponseEntity<TaskStateEntity> saveEntity(@RequestBody TaskStateEntity taskState){
        TaskStateEntity newTaskState = taskStateService.saveTaskState(taskState);
        return ResponseEntity.ok(newTaskState);
    }

    @GetMapping("/tasks_states/{id}")
    public ResponseEntity<TaskStateEntity> getTaskStatesById(@PathVariable Long id){
        TaskStateEntity newTaskState = taskStateService.getTaskById(id);
        return ResponseEntity.ok(newTaskState);
    }

    @PutMapping("/tasks_states/{id}")
    public ResponseEntity<TaskStateEntity> updateTaskState(@PathVariable Long id,
                                                           @RequestBody TaskStateEntity taskState){
        taskState.setId(id);
        TaskStateEntity updateStateTask = taskStateService.updateTaskState(taskState);
        return  ResponseEntity.ok(updateStateTask);
    }

    @DeleteMapping("/tasks_states/{id}")
    public ResponseEntity<Boolean> deleteTaskState(@PathVariable long id){
        var isDeleted = taskStateService.deleteTaskState(id);
        return  ResponseEntity.ok(isDeleted);
    }
}
