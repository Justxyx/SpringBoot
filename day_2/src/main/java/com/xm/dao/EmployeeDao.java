package com.xm.dao;

import com.xm.entity.Department;
import com.xm.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer,Employee>  employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer,Employee>();
        employees.put(1001,new Employee(1001,"1aa","123@qq.com",1,new Department(101,"G教学部")));
        employees.put(1002,new Employee(1002,"2aa","A123456@qq.com",0,new Department(102,"A教学部")));
        employees.put(1003,new Employee(1003,"3aa","123@qq.com",1,new Department(103,"B教学部")));
        employees.put(1004,new Employee(1004,"4aa","123@qq.com",0,new Department(104,"C教学部")));
    }

    private static Integer initId = 1005;
    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId ++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAllEmployee(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void deleteById(Integer id){
        employees.remove(id);
    }



}
