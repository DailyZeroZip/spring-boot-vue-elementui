package com.example.demo.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.componet.Wrapper;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Customer)表控制层
 *
 * @author makejava
 * @since 2020-10-19 15:16:35
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    /**
     * 服务对象
     */
    @Resource
    private CustomerService customerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    @CrossOrigin    //跨域问题解决
    @ApiOperation("通过主键查询单条数据")
    public Customer selectOne(Integer id) {
        return this.customerService.queryById(id);
    }

    @GetMapping("/selesctAll")
    @CrossOrigin    //跨域问题解决
    @ApiOperation("查询全部")
    public Wrapper selectAll(Page<Customer> page,Customer customer){
        IPage<Customer> iPage = customerService.page(page, new QueryWrapper<>(customer));
        return Wrapper.ok((iPage));
    }
}