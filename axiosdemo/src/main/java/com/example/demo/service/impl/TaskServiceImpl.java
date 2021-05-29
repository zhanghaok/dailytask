package com.example.demo.service.impl;

import com.example.demo.dao.TaskDao;
import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Task)表服务实现类
 *
 * @author makejava
 * @since 2021-04-23 08:30:55
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {
    @Resource
    private TaskDao taskDao;

    @Override
    public PageInfo<Task> queryAll(Integer page, Integer pageSize, Task task) {
        PageHelper.startPage(page,pageSize);
        List<Task> tasks = taskDao.queryAll(task);
        PageInfo<Task> taskPageInfo = new PageInfo<>(tasks);

        return taskPageInfo;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Task queryById(Integer id) {
        return this.taskDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Task> queryAllByLimit(int offset, int limit) {
        return this.taskDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param task 实例对象
     * @return 实例对象
     */
    @Override
    public Task insert(Task task) {
        this.taskDao.insert(task);
        return task;
    }

    /**
     * 修改数据
     *
     * @param task 实例对象
     * @return 实例对象
     */
    @Override
    public Task update(Task task) {
        this.taskDao.update(task);
        return this.queryById(task.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.taskDao.deleteById(id) > 0;
    }
}