package net.eezn.jpa.domain.company.dto;

import net.eezn.jpa.domain.company.domain.CompanyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

// MapStruct
/* @Mapper 정책
 * unmappedSourcePolicy - IGNORE(default), WARN, ERROR
 * unmappedTargetPolicy - IGNORE, WARN(default), ERROR
 * typeConversionPolicy - IGNORE(default), WARN, ERROR
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CompanyMapper {
    
    // bean, 없을 시 호출할 때 Mapper 객체 생성 후 호출해야 함
    CompanyMapper cm = Mappers.getMapper(CompanyMapper.class);

    /* @Mapping 옵션
     * 1. 서로 다른 속성 매핑
     * 2. 객체 합치기
     * 3. 속성 무시
     */
    @Mapping(target = "id", ignore = true) // 속성 무시 조항이 없으면 없으면 unmappedTargetPolicy = ReportingPolicy.ERROR 정책으로 에러처리
    CompanyEntity toCompanyEntity(CompanyDto companyDto);
    CompanyDto toCompanyDto(CompanyEntity companyEntity);
}
