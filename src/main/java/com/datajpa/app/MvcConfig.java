package com.datajpa.app;

import java.nio.file.Paths;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.datajpa.app.view.xml.ClienteList;

@Configuration
public class MvcConfig  implements WebMvcConfigurer{
	

//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		WebMvcConfigurer.super.addResourceHandlers(registry);
//		/*String resourcePath = Paths.get("upload").toAbsolutePath().toUri().toString();
//		registry.addResourceHandler("/upload/**")
//				.addResourceLocations(resourcePath);*/
//		
//	}
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale.Builder().setLanguage("es").setRegion("ES").build());
		
		return localeResolver;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
		localeInterceptor.setParamName("lang");
		
		return localeInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(localeChangeInterceptor());
	}

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/error_403").setViewName("error_403");
	}
	
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
//    @Bean
//    public MarshallingHttpMessageConverter marshallingMessageConverter() {
//        return new MarshallingHttpMessageConverter(
//            jaxb2Marshaller(),
//            jaxb2Marshaller()
//        );
//    }
    
//    @Bean
//    public Jaxb2Marshaller jaxb2Marshaller() {
//    	Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//    	
//    	marshaller.setClassesToBeBound( new Class[] {com.datajpa.app.view.xml.ClienteList.class});
//    	return marshaller;
//    }
//    
	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller =  new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(new Class[] {com.datajpa.app.view.xml.ClienteList.class});
		return marshaller;
	}
	
	
}
