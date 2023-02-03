package net.eezn.jpa.domain.company.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "t_company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private Long id;

    @Column(name = "company_name")
    private String name;

    @Column(name = "company_address")
    private String address;

    @OneToMany(mappedBy = "company")
    private List<EmployeeEntity> employeeList;

    @Builder
    public CompanyEntity(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void changeCompanyInfo(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
