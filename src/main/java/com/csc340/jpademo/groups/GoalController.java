package com.csc340.jpademo.groups;

import com.csc340.jpademo.tasks.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/goals")
public class GoalController {
    @Autowired
    GoalService goalService;
    @Autowired
    TaskService taskService;

    @GetMapping({"/", ""})
    public String getAllGoals(Model model) {
        model.addAttribute("goalList", goalService.getAllGoals());
        return "goals-view";
    }

    @GetMapping("/view/{goalId}")
    public String selectedGoalView(@PathVariable("goalId") String stringID, Model model) {
        int id = Integer.parseInt(stringID);
        model.addAttribute("goal", goalService.getGoalById(id));
        model.addAttribute("taskList", taskService.getTasksForGoal(id));
        return "selected-goal-view";
    }

    @PostMapping("/create")
    public String addNewGoal(Goal goal) {
        goalService.addNewGoal(goal);
        return "redirect:/goals/view/" + goal.getGoalId();
    }

    @GetMapping("/remove/{goalId}")
    public String removeGoal(@PathVariable("goalId") String goalIdString) {
        int goalId = Integer.parseInt(goalIdString);
        goalService.removeGoal(goalId);
        return "redirect:/goals/";
    }

    @GetMapping("/edit/{goalId}")
    public String editGoal(@PathVariable("goalId") String goalIdString, Model model) {
        int goalId = Integer.parseInt(goalIdString);
        model.addAttribute("goal", goalService.getGoalById(goalId));
        return "goal-edit";
    }

    @PostMapping("/edit/{goalId}/update")
    public String updateGoal(@PathVariable("goalId") String goalIdString, Goal goal) {
        int goalId = Integer.parseInt(goalIdString);
        goal.setGoalId(goalId);
        goalService.updateGoal(goal);
        return "redirect:/goals/";
    }

    @InitBinder
    public void dateBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}

