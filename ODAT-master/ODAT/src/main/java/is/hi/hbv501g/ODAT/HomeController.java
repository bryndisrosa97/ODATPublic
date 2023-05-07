package is.hi.hbv501g.ODAT;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import is.hi.hbv501g.ODAT.Entities.Tfolder;
import is.hi.hbv501g.ODAT.Entities.Goal;
import is.hi.hbv501g.ODAT.Entities.Task;
import is.hi.hbv501g.ODAT.Services.TfolderService;
import is.hi.hbv501g.ODAT.Services.GoalService;
import is.hi.hbv501g.ODAT.Services.TaskService;

@Controller
public class HomeController {

    private TaskService taskService;
    private TfolderService tfolderService;
    private GoalService goalService;

    @Autowired
    public HomeController(TaskService taskService, TfolderService tfolderService, GoalService goalService) {
        this.taskService = taskService;
        this.tfolderService = tfolderService;
        this.goalService = goalService;
    }

    @RequestMapping("/")
    public String Home(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("tfolders", tfolderService.findAll());
        model.addAttribute("goals", goalService.findAll());
        return "calendar";
    }

    @RequestMapping(value = "/addtask", method = RequestMethod.POST)
    public String addTask(@Valid Task task, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "addtask";
        }
        taskService.save(task);
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("tfolders", tfolderService.findAll());
        model.addAttribute("goals", goalService.findAll());
        return "calendar";
    }

    @RequestMapping(value = "/addtask", method = RequestMethod.GET)
    public String addTaskForm(Task task, Model model) {
        // ATH.
        if(tfolderService.findAll().isEmpty()) {
            return "error";
        } else {
            model.addAttribute("tfolders", tfolderService.findAll());
            return "addtask";
        }
    }

    @RequestMapping(value = "/deletetask/{id}", method = RequestMethod.GET)
    public String deleteTask(@PathVariable("id") long id, Model model) {
        Task task = taskService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid task ID"));
        taskService.delete(task);
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("tfolders", tfolderService.findAll());
        model.addAttribute("goals", goalService.findAll());
        return "calendar";
    }

    @RequestMapping(value = "/addgoal", method = RequestMethod.POST)
    public String addGoal(@Valid Goal goal, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "addgoal";
        }
        goalService.save(goal);
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("tfolders", tfolderService.findAll());
        model.addAttribute("goals", goalService.findAll());
        return "calendar";
    }

    @RequestMapping(value = "/addgoal", method = RequestMethod.GET)
    public String addGoalForm(Goal goal) {
        return "addgoal";
    }

    @RequestMapping(value = "/deletegoal/{id}", method = RequestMethod.GET)
    public String deleteGoal(@PathVariable("id") long id, Model model) {
        Goal goal = goalService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid goal ID"));
        goalService.delete(goal);
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("tfolders", tfolderService.findAll());
        model.addAttribute("goals", goalService.findAll());
        return "calendar";
    }

    @RequestMapping(value = "/addfolder", method = RequestMethod.POST)
    public String addTfolder(@Valid Tfolder tfolder, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "addfolder";
        }
        tfolderService.save(tfolder);
        model.addAttribute("tfolders", tfolderService.findAll());
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("goals", goalService.findAll());
        return "calendar";
    }

    @RequestMapping(value = "/addfolder", method = RequestMethod.GET)
    public String addTfolderForm(Tfolder tfolder) {
        return "addfolder";
    }

    @RequestMapping(value = "/deletetfolder/{id}", method = RequestMethod.GET)
    public String deleteTfolder(@PathVariable("id") long id, Model model) {
        Tfolder tfolder = tfolderService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid task ID"));
        tfolderService.delete(tfolder);
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("tfolders", tfolderService.findAll());
        model.addAttribute("goals", goalService.findAll());
        return "calendar";
    }

}