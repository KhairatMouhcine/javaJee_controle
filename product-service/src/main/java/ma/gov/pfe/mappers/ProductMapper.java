package ma.gov.pfe.mappers;

import ma.gov.pfe.dtos.ProductDto;
import ma.gov.pfe.entities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductEntity toEntity(ProductDto productDto);
    ProductDto toDto(ProductEntity productEntity);
}