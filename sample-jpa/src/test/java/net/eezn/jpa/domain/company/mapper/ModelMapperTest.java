package net.eezn.jpa.domain.company.mapper;

import net.eezn.jpa.domain.company.domain.CompanyEntity;
import net.eezn.jpa.domain.company.dto.CompanyDto;
import net.eezn.jpa.global.config.ModelMapperConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ModelMapperConfig.class)
public class ModelMapperTest {

    @Autowired
    ModelMapper modelMapper;

    @Test
    public void modelMapperTest() throws Exception {

        // Setter가 없는 Class(Entity) Mapping
        modelMapper.createTypeMap(CompanyDto.class, CompanyEntity.class).setProvider(
                new Provider<CompanyEntity>() {
                    @Override
                    public CompanyEntity get(ProvisionRequest<CompanyEntity> request) {
                        // 변환할 클래스를 가져와서 setter가 없는 클래스를 만듭니다.
                        CompanyDto dto = CompanyDto.class.cast(request.getSource());
                        return CompanyEntity.builder()
                                .name(dto.getName())
                                .address(dto.getAddress())
                                .build();
                    }
                });

        CompanyEntity companyEntity = CompanyEntity.builder()
                .id(1L)
                .name("testName")
                .address("testAddress")
                .build();

        // Entity -> DTO
        CompanyDto resultDto = modelMapper.map(companyEntity, CompanyDto.class);

        // DTO -> Entity
        CompanyEntity resultEntity = modelMapper.map(resultDto, CompanyEntity.class);

        System.out.println(resultDto);
        System.out.println(resultEntity);
    }
}
