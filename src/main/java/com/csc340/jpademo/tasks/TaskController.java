package com.csc340.jpademo.tasks;

import com.csc340.jpademo.groups.GoalController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/goals/{goalId}/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/")
    public String goalRedirect(@PathVariable("goalId") String goalIdString) {
        return "redirect:/goals/view/" + goalIdString;
    }

    @GetMapping("/{taskId}")
    public String taskView(@PathVariable("taskId") String taskIdString, Model model) {
        int taskId = Integer.parseInt(taskIdString);
        model.addAttribute("task", taskService.getTaskById(taskId));
        return "task-view";
    }

    @PostMapping("/create")
    public String createNewTask(@PathVariable("goalId") String goalIdString, Task task) {
        int goalId = Integer.parseInt(goalIdString);
        task.setGoalId(goalId);
        taskService.addNewTask(task);
        return "redirect:/goals/" + goalIdString + "/tasks/" + task.getTaskId();
    }

    @PostMapping("/{taskId}/update")
    public String updateTask(@PathVariable("goalId") String goalIdString, @PathVariable("taskId") String taskIdString, Task task) {
        int goalId = Integer.parseInt(goalIdString);
        int taskId = Integer.parseInt(taskIdString);
        task.setGoalId(goalId);
        task.setTaskId(taskId);
        taskService.updateTask(task);
        return "redirect:/goals/view" + goalIdString;
    }

    @GetMapping("/{taskId}/remove")
    public String deleteTask(@PathVariable("taskId") String taskIdString, @PathVariable("goalId") String goalIdString) {
        int taskId = Integer.parseInt(taskIdString);
        taskService.removeTask(taskId);
        return "redirect:/goals/view/" + goalIdString;
    }
}
