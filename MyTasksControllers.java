package com.example.tasktracker.Controllers;

import com.example.tasktracker.model.MyTasks;
import com.example.tasktracker.model.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MyTasksControllers {
    ArrayList<MyTasks> myTasks=new ArrayList<>();

    @GetMapping("/mytasks")
    public ArrayList< MyTasks> GetTasks(){
        return myTasks;
    }

    @PostMapping("/mytasks")
    public Response Addtasks(@RequestBody MyTasks tasks){
       myTasks.add(tasks);
        return new Response("task Added to the list!");
    }
    @PutMapping("/mytasks/{index}")
    public Response Updatetasks(@PathVariable int index, @RequestBody MyTasks tasks){
        myTasks.set(index,tasks);
        return new Response("task updated!");
    }
    @DeleteMapping("/mytasks/{index}")
    public Response Deletetasks(@PathVariable int index){
        myTasks.remove(index);
        return new Response("task removed!");
    }

    @PostMapping("/mytasks/status")
    public Response changestat(@RequestParam int index ,@RequestParam String stat){
        MyTasks tasks1=myTasks.get(index);
        tasks1.setStatus(stat);
        return new Response("Status updated");
    }
    @GetMapping("/mytasks/search")
    public MyTasks searchtask(@RequestParam String task){
       for(int i=0;i<myTasks.size();i++) {

           if (myTasks.get(i).getTitle().equals(task)) {
               return myTasks.get(i);

           }

       }
        new Response("task not found");
     return null;
    }


}
