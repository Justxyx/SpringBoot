package com.xm.controller;

import com.xm.dao.DepartmentDao;
import com.xm.dao.EmployeeDao;
import com.xm.entity.Department;
import com.xm.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;



    @RequestMapping("emps/findall")
    public String listOfEmployee(Model model){
        Collection<Employee> employees = employeeDao.getAllEmployee();
        model.addAttribute("lists",employees);
//        return String.valueOf(employees);
        return "/emp/list";    // 一般企业开发中，会将不同的页面放置在不同的文件夹中
    }

//
//    @RequestMapping("emps/add")
//    public String addEmployee(Model model){
//        private Integer id;
//        private String lastName;
//        private String email;
//        private Integer gerder;
//
//        private Department department;
//        private Date date;
//
//
//        new Employee()
//        employeeDao.save();
//    }


    // 跳转到添加用户界面
    @GetMapping("add")
    public String addEmployee(Model model){
        Collection<Department> department = departmentDao.getDepartments();
        model.addAttribute("departments",department);
        return "emp/add";
    }

    //  添加用户，redirect 请求。
    @PostMapping("add")
    public String addEmplpyee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps/findall";
    }

    // 删除用户
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeDao.deleteById(id);
        return "redirect:/emps/findall";
    }

    //修改用户
     // 1. 查询所有用户
    @RequestMapping("/update1/{id}")
    public String update(@PathVariable("id") Integer id , Model model){

        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        return "/emp/update";
    }

    // 2. 修改
    @RequestMapping("/update2")
    public String update2(Employee employee){
//        employee.setDepartment().setDepartmentName("A教学部");
        Department department = new Department();
        department.setDepartmentName("A教学部");
        department.setId(102);
        employee.setDepartment(department);
        employeeDao.save(employee);
        return "redirect:/emps/findall";
    }
}
