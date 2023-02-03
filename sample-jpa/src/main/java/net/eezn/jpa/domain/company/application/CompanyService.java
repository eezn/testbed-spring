package net.eezn.jpa.domain.company.application;

import lombok.RequiredArgsConstructor;
import net.eezn.jpa.domain.company.dao.CompanyRepository;
import net.eezn.jpa.domain.company.dto.CompanyDto;
import net.eezn.jpa.domain.company.domain.CompanyEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<CompanyEntity> findAll() {
        // ...
        return companyRepository.findAll();
    }

    public Optional<CompanyEntity> findById(Long id) {
        // ...
        return companyRepository.findById(id);
    }

    public void deleteById(Long id) {
        // ...
        companyRepository.deleteById(id);
    }

    public CompanyEntity save(CompanyEntity company) {
        // ...
        companyRepository.save(company);
        return company;
    }

    @Transactional
    public void updateById(Long id, CompanyDto companyDto) {
        CompanyEntity company = companyRepository.findById(id).orElseThrow(NoSuchElementException::new);
        company.changeCompanyInfo(companyDto.getName(), companyDto.getAddress());
    }
}
