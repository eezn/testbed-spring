package net.eezn.mybatis.mapper;

import net.eezn.mybatis.model.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyMapper {

    int insert(@Param("company") Company company);
    Company getById(@Param("id") int id);
    List<Company> getAll();
}
