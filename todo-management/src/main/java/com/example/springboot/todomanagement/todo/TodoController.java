package com.example.springboot.todomanagement.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    private TodoService todoService;

    @RequestMapping("list-todos")
    public String todosPage(ModelMap model){
        List<Todo> todos = todoService.findByUsername("hemant");
        model.addAttribute("todos",  todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodo(){
        return "newTodo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addTodo(){
        return "redirect:list-todos";
    }
}
