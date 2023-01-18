package net.eezn.jpa.controller;

import lombok.RequiredArgsConstructor;
import net.eezn.jpa.model.Company;
import net.eezn.jpa.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    // test ok
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.findAll();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    // test ok
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> getCompany(@PathVariable("id") Integer id) {
        Optional<Company> company = companyService.findById(id);
        return company.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));

    }

    // test ok
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteCompany(@PathVariable("id") Integer id) {
        companyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // test X
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> updateCompany(@PathVariable("id") Integer id,
                                                 @RequestBody Company company) {
        companyService.updateById(id, company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    // test ok
    @PostMapping
    public ResponseEntity<Company> save(@RequestBody Company company) {
        return new ResponseEntity<>(companyService.save(company), HttpStatus.OK);
    }

    // test ok
    @RequestMapping(value = "/saveCompany", method = RequestMethod.GET)
    public ResponseEntity<Company> save(HttpServletRequest req, @RequestBody Company company) {
        return new ResponseEntity<>(companyService.save(company), HttpStatus.OK);
    }
}
