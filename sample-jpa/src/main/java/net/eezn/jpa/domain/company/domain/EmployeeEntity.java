package net.eezn.jpa.domain.company.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "t_employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @Builder
    public EmployeeEntity(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void setCompany(CompanyEntity company) {
        if (this.company != null) {
            this.company.getEmployeeList().remove(this);
        }
        this.company = company;
        company.getEmployeeList().add(this);
    }
}
