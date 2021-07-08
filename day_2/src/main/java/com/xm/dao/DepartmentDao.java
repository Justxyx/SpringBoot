package com.xm.dao;

import com.xm.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer,Department> departments = null;
    static {
        departments = new HashMap<>();

        departments.put(101,new Department(101,"G教学部"));
        departments.put(102,new Department(102,"A教学部"));
        departments.put(103,new Department(103,"B教学部"));
        departments.put(104,new Department(104,"C教学部"));
        departments.put(105,new Department(105,"D教学部"));
        departments.put(106,new Department(106,"E教学部"));
    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
