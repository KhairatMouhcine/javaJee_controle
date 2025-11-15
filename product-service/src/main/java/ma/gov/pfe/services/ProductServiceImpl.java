package ma.gov.pfe.services;

import ma.gov.pfe.dtos.ProductDto;
import ma.gov.pfe.dtos.UserDto;
import ma.gov.pfe.mappers.ProductMapper;
import ma.gov.pfe.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final RestTemplate restTemplate;
    private final WebClient.Builder webClientBuilder;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductMapper productMapper,
                              RestTemplate restTemplate, WebClient.Builder webClientBuilder) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.restTemplate = restTemplate;
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        return productMapper.toDto(productRepository.save(productMapper.toEntity(productDto)));
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return productMapper.toDto(productRepository.save(productMapper.toEntity(productDto)));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> selectProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id) {
        ProductDto productDto = productMapper.toDto(
                productRepository.findById(id).orElse(null)
        );

        if (productDto != null && productDto.getUserId() != null) {
            // Appel REST vers user-service
            UserDto user = restTemplate.getForObject(
                    "http://USER-SERVICE/users/" + productDto.getUserId(),
                    UserDto.class
            );
            productDto.setUser(user);
        }

        return productDto;
    }

    public ProductDto getProductByIdWithWebClient(Long id) {
        ProductDto productDto = productMapper.toDto(
                productRepository.findById(id).orElse(null)
        );

        if (productDto != null && productDto.getUserId() != null) {
            UserDto user = webClientBuilder.build()
                    .get()
                    .uri("http://USER-SERVICE/users/" + productDto.getUserId())
                    .retrieve()
                    .bodyToMono(UserDto.class)
                    .block();

            productDto.setUser(user);
        }

        return productDto;
    }
}