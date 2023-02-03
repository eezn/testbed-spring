package net.eezn.jpa.domain.company.mapper;


import net.eezn.jpa.domain.company.domain.CompanyEntity;
import net.eezn.jpa.domain.company.dto.CompanyDto;
import net.eezn.jpa.domain.company.dto.CompanyMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MapStructTest.class)
public class MapStructTest {

    @Test
    public void MapStructTest() throws Exception {

        CompanyEntity companyEntity = CompanyEntity.builder()
                .id(1L)
                .name("testName")
                .address("testAddress")
                .build();

        // Entity -> Dto
        CompanyDto resultDto = CompanyMapper.cm.toCompanyDto(companyEntity);

        // Dto -> Entity, Setter가 없어도 @Builder가 붙어있다면 변환 가능
        CompanyEntity resultEntity = CompanyMapper.cm.toCompanyEntity(resultDto);

        System.out.println(resultDto);
        System.out.println(resultEntity);
    }
}
