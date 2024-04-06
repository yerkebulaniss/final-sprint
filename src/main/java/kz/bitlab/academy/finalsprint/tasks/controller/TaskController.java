package kz.bitlab.academy.finalsprint.tasks.controller;

import kz.bitlab.academy.finalsprint.tasks.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/tasks")
    public String addTask(@RequestParam("title") String title,
                          @RequestParam("description") String description,
                          @RequestParam("folderId") Long folderId) {
        taskService.create(title, description, folderId);

        return "redirect:/" + folderId;
    }

    @GetMapping("/tasks/{id}")
    public String detailsTask(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.findById(id));
        return "detailsTask";
    }

    @PostMapping("/tasks/{id}")
    public String updateTask(@RequestParam("title") String title,
                          @RequestParam("description") String description,
                          @RequestParam("status") int status,
                          @PathVariable Long id) {
        taskService.update(id, title, description, status);

        return "redirect:/tasks/" + id;
    }

    @PostMapping("/tasks/{id}/delete")
    public String deleteTask(@PathVariable Long id,
                             @RequestParam("folderId") Long folderId) {
        taskService.delete(id);

        return "redirect:/" + folderId;
    }

}
