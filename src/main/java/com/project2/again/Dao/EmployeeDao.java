package com.project2.again.Dao;

import com.project2.again.pojo.Department;
import com.project2.again.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees=null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees=new HashMap<Integer,Employee>();
        employees.put(1001,new Employee(1001,"A","A@qq.com",0,new Department(101,"市场部")));
        employees.put(1002,new Employee(1002,"B","B@qq.com",0,new Department(102,"设计部")));
        employees.put(1003,new Employee(1003,"C","C@qq.com",1,new Department(103,"技术部")));
        employees.put(1004,new Employee(1004,"D","D@qq.com",1,new Department(104,"后勤部")));
        employees.put(1005,new Employee(1005,"E","E@qq.com",0,new Department(105,"小卖部")));

    }

    //主键自增
    private static Integer initId=1006;

    //增加员工
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    //查询全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}
