package net.eezn.mybatis.mapper;

import net.eezn.mybatis.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    int insert(@Param("employee") Employee employee);
    Employee getById(@Param("id") int id);
    List<Employee> getAll();
    List<Employee> getByCompanyId(@Param("companyId") int companyId);
}
