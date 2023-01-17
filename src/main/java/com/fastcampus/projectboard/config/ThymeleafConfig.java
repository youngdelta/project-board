package com.fastcampus.projectboard.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

@Configuration
public class ThymeleafConfig {

    @Bean
    public SpringResourceTemplateResolver thymeleafTemplateResolver(
            SpringResourceTemplateResolver defaultTemplateResolver,
            Thymeleaf3Properties thymeleaf3Properties){
        defaultTemplateResolver.setUseDecoupledLogic(thymeleaf3Properties.isDecoupledLogic());

        return defaultTemplateResolver;
    }



    @RequiredArgsConstructor
    @Getter
    @ConstructorBinding // application.yml에서 자동완성으로 사용할 수 있도록
    @ConfigurationProperties("spring.thymeleaf3") // application.yml에서 spring: thymeleaf3 : 에 정의된 값을 가져옴
    public static class Thymeleaf3Properties{
        /**
         Use Thymeleaf 3 Decoupled Logic
         **/
        private final boolean decoupledLogic;

        /*
        public Thymeleaf3Properties(boolean decoupledLogic) {
            this.decoupledLogic = decoupledLogic;
        }
        */

        /*
        public boolean isDecoupledLogic() {
            return this.decoupledLogic;
        }
        */
    }

}

