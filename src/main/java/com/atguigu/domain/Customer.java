package com.atguigu.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用来表示数据的实体类
 * orm
 */
@Entity //表示是个实体类
@Table(name = "customer")  //指定表名
public class Customer implements Serializable {
    // 主键
    @Id  //声明为主键字段
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 用户名
    @Column(name = "username")
    private String username;
    // 密码
    @Column(name = "password")
    private String password;
    // 姓名
    @Column(name = "name")
    private String name;

    public Customer() {
    }

    public Customer(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
