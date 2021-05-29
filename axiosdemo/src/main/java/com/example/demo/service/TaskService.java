package com.example.demo.service;

import com.example.demo.entity.Task;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * (Task)表服务接口
 *
 * @author makejava
 * @since 2021-04-23 08:30:55
 */
public interface TaskService {

    PageInfo<Task> queryAll(Integer page,Integer pageSize,Task task);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Task queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Task> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param task 实例对象
     * @return 实例对象
     */
    Task insert(Task task);

    /**
     * 修改数据
     *
     * @param task 实例对象
     * @return 实例对象
     */
    Task update(Task task);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}