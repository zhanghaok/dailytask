package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Task)实体类
 *
 * @author makejava
 * @since 2021-04-23 08:30:51
 */
public class Task implements Serializable {
    private static final long serialVersionUID = -75470572328053816L;

    private Integer id;

    private String title;

    private Date ctime;
    /**
     * 1为完成；0为未完成
     */
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}