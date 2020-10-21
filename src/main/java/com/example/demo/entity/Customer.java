package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Customer)实体类
 *
 * @author makejava
 * @since 2020-10-19 15:16:34
 */
@NoArgsConstructor
public class Customer implements Serializable {
    private static final long serialVersionUID = 863076841502402485L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String sex;

    private String tell;

    private String addr;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

}