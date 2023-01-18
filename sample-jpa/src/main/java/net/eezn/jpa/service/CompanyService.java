package net.eezn.jpa.service;

import lombok.RequiredArgsConstructor;
import net.eezn.jpa.model.Company;
import net.eezn.jpa.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Optional<Company> findById(Integer id) {
        return companyRepository.findById(id);
    }

    public void deleteById(Integer id) {
        companyRepository.deleteById(id);
    }

    public Company save(Company company) {
        companyRepository.save(company);
        return company;
    }

    public void updateById(Integer id, Company company) {
        Optional<Company> e = companyRepository.findById(id);
        if (e.isPresent()) {
            e.get().setId(company.getId());
            e.get().setName(company.getName());
            e.get().setAddress(company.getAddress());
            companyRepository.save(company);
        }
    }

}
