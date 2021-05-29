package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import com.example.demo.util.R;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Task)表控制层
 *
 * @author makejava
 * @since 2021-04-23 08:30:55
 */
@RestController
@RequestMapping("task")
public class TaskController {
    /**
     * 服务对象
     */
    @Resource
    private TaskService taskService;

    /**
     * 用户端
     */

    @RequestMapping("/index")
    public Map index(@RequestBody Map<String,String> map){

        String title = "";
        if (map.containsKey("title")){
            title = map.get("title");
        }

        Map m= new HashMap();
        Task task = new Task();
        task.setTitle(title);
        PageInfo<Task> taskPageInfo = taskService.queryAll(1,50,task);
        List<Task> tasks = taskPageInfo.getList();
        m.put("tasks",tasks);

        return m;

    }

    @RequestMapping("/daka")
    public R setStatus(@RequestBody Map<String,String> map){
        String taskId = "";
        if (map.containsKey("taskId")){
            taskId = map.get("taskId");
        }
        Task task = taskService.queryById(Integer.parseInt(taskId));
        task.setStatus(1);
        taskService.update(task);
        return R.ok();
    }

    @RequestMapping("/addTask")
    public R addTask(@RequestBody Map<String,String> map){
        String title="";
        if (map.containsKey("title")){
            title= map.get("title");
        }
        Task task = new Task();
        task.setStatus(0);
        task.setTitle(title);
        taskService.insert(task);
        return R.ok();
    }

    /**
     * 修改任务
     * @param map
     * @return
     */
    @RequestMapping("/editTask")
    public R editTask(@RequestBody Map<String,String> map){
        String title="";
        if (map.containsKey("title")){
            title= map.get("title");
        }
        String taskId="";
        if (map.containsKey("taskId")){
            taskId= map.get("taskId");
        }
        Task task = taskService.queryById(Integer.parseInt(taskId));
        task.setTitle(title);
        task.setCtime(new Date());
        taskService.update(task);
        return R.ok();
    }

    /**
     * 数据回显
     * @param map
     * @return
     */
    @RequestMapping("/queryInfo")
    public Map queryInfo(@RequestBody Map<String,String> map){
        Map m = new HashMap();
        String taskId="";
        if (map.containsKey("taskId")){
            taskId= map.get("taskId");
        }
        Task task = taskService.queryById(Integer.parseInt(taskId));
        if (task!=null){
            m.put("title",task.getTitle());
            return m;
        }
        return m;
    }

    @RequestMapping("/deleteTask")
    public R deleteTask(@RequestBody Map<String ,String> map){
        String taskId = "";
        if (map.containsKey("taskId")){
            taskId = map.get("taskId");
        }
        taskService.deleteById(Integer.parseInt(taskId));
        return R.ok();
    }

}