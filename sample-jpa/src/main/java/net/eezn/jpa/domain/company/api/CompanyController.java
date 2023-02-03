package net.eezn.jpa.domain.company.api;

import lombok.RequiredArgsConstructor;
import net.eezn.jpa.domain.company.dto.CompanyDto;
import net.eezn.jpa.domain.company.domain.CompanyEntity;
import net.eezn.jpa.domain.company.application.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CompanyEntity>> getAllCompanies() {
        List<CompanyEntity> companies = companyService.findAll();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyEntity> getCompany(@PathVariable("id") Long id) {
        Optional<CompanyEntity> company = companyService.findById(id);
        return company.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));

    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteCompany(@PathVariable("id") Long id) {
        companyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyDto> updateCompany(@PathVariable("id") Long id,
                                                    @RequestBody CompanyDto companyDto) {
        HttpStatus httpStatus;
        try {
            companyService.updateById(id, companyDto);
            httpStatus = HttpStatus.OK;
        } catch (NoSuchElementException e) {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(companyDto, httpStatus);
    }

    @PostMapping
    public ResponseEntity<CompanyEntity> save(@RequestBody CompanyEntity companyEntity) {
        return new ResponseEntity<>(companyService.save(companyEntity), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveCompany", method = RequestMethod.GET)
    public ResponseEntity<CompanyEntity> save(HttpServletRequest req, @RequestBody CompanyEntity companyEntity) {
        return new ResponseEntity<>(companyService.save(companyEntity), HttpStatus.OK);
    }
}
