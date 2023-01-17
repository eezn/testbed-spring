package net.eezn.mybatis.controller;

import lombok.RequiredArgsConstructor;
import net.eezn.mybatis.mapper.CompanyMapper;
import net.eezn.mybatis.model.Company;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyMapper companyMapper;

    @PostMapping
    public int insert(@RequestBody Company company) {
        return companyMapper.insert(company);
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable("id") int id) {
        return companyMapper.getById(id);
    }

    @GetMapping("/")
    public List<Company> getAll() {
        return companyMapper.getAll();
    }
}
