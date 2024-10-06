package org.product.management.productmanagementapplication;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductManagementApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE) // 필드 접근 수준을 설정하는 부분
                                                                        // private 필드에도 접근할 수 있게 설정
                .setFieldMatchingEnabled(true); // 필드 매칭을 활성화
                                                // 기본적으로 ModelMapper는 getter/setter 메서드를 통해 매핑하는데,
                                                // 이 옵션을 활성화하면 getter/setter 없이도 클래스의 필드끼리 바로 매칭을 시도하게 됨
                                                // 같은 이름의 필드끼리 값을 매핑 가능

        return modelMapper;
    }

}
