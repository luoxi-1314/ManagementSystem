package com.project2.again.Dao;

import com.project2.again.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments=null;

    static {
        departments=new HashMap<Integer, Department>();
        departments.put(101,new Department(101,"市场部"));
        departments.put(102,new Department(102,"设计部"));
        departments.put(103,new Department(103,"技术部"));
        departments.put(104,new Department(104,"后勤部"));
        departments.put(105,new Department(105,"小卖部"));


    }

    //获得所有信息
    public Collection<Department> getDepartments(){
        return  departments.values();
    }

    //通过id获得信息
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
