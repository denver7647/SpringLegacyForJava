package kr.co.sample.base.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.sample.base.interceptor.GlobalBaseInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "kr.co.sample")
public class ServletConfig implements WebMvcConfigurer {

	Logger log = LoggerFactory.getLogger(ServletConfig.class);
	
	/**
	 * @methodName      : addArgumentResolvers
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 21.
	 * @description     : @RequestParam, @PathVariable, @RequestBody 과 같은것을 사용하기 위한 커스텀 메서드
	 * 					  여기에 등록을 하고 HandlerMethodArgumentResolver 을 상속받는 class 구현
	 * 
	 * @param arg0
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> arg0) {
		log.info("ServletContext addArgumentResolvers.....");

	}

	/**
	 * @methodName : addCorsMappings
	 * @author : DaeGeun Ki
	 * @date : 2024. 4. 21.
	 * @description : Cross-Origin Resource Sharing (CORS)을 구성메서드
	 * 
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		log.info("ServletContext addCorsMappings.....");
		registry.addMapping("/") // CORS를 적용할 패턴을 지정해준다.
				.allowedOrigins("https://www.naver.com", "https://wwww.google.com") // 허용할 출처 지정
				.allowedMethods("GET", "POST") // 허용할 HTTP 메서드 지정
				.allowedHeaders("Authorization", "Content-Type") // 허용할 요청 헤더 지정
				.exposedHeaders("Authorization") // 브라우저에 노출할 응답 헤더 지정
				.allowCredentials(true) // 자격 증명 허용 여부 지정
				.maxAge(3600); // preflight 요청 결과를 캐시할 시간(초) 지정
				
	}
	
	/**
	 * @methodName      : addFormatters
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 21.
	 * @description     : 자동으로 포멧팅 해주는 그런 기능 ... AOP에서 하는게 좋을지도?
	 * 					  registry에 data타입을 yyyy-MM-dd 로 등록을 해두면
	 *  				  data 타입쓸때 자동으로 해당 포멧팅으로 해줌.
	 * @param registry
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		log.info("ServletContext addFormatters.....");

	}

	/**
	 * @methodName      : addInterceptors
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 21.
	 * @description     : 인터셉터 등록
	 * 			          addInterceptor : 인터셉터 설정한 클래스 
	 * 					, addPathPatterns : 인터셉터 설정할 url 패턴 
	 * 					, excludePathPatterns : 인터셉터 제외할 url 패턴	
	 * 
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.info("ServletContext addInterceptors.....");

		GlobalBaseInterceptor globalBaseInterceptor = new GlobalBaseInterceptor();

		registry.addInterceptor(globalBaseInterceptor).addPathPatterns("/").excludePathPatterns("/excludeIntercaptor");

	}

	/**
	 * @methodName      : addResourceHandlers
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 21.
	 * @description     : 정적파일 리소스 경로 지정
	 * 
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.info("ServletContext addResourceHandlers.....");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/assets/**").addResourceLocations("/resources/assets/");
		registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/");
		registry.addResourceHandler("/err/**").addResourceLocations("/WEB-INF/views/err/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("/resources/fonts/");
		registry.addResourceHandler("/notice/**").addResourceLocations("/resources/notice/");
		registry.addResourceHandler("/pdf/**").addResourceLocations("/resources/pdf/");

	}
	
	/**
	 * @methodName      : addReturnValueHandlers
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 21.
	 * @description     : 컨트롤러 리턴값 처리를 위한 커스텀 메서드
	 * 					  필요시 여기에 등록을 하고 HandlerMethodReturnValueHandler을 상속받는 class 구현
	 * @param arg0
	 */
	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> arg0) {
		
		log.info("============================== ServletContext addReturnValueHandlers ==============================");

	}
	
	/**
	 * @methodName      : addViewControllers
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 21.
	 * @description     : 컨트롤러를 구현하지않고 URL과 뷰 템플릿 직접 매핑
	 * 					  간단 포워딩 리다이렉트 등 구현가능
	 * 
	 * @param registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		log.info("============================== ServletContext addViewControllers ==============================");
		/*
		registry.addViewController("/home").setViewName("home"); //해당 URL 들어올때 해당 VIEW 보여줌
		registry.addRedirectViewController("/old-url", "/new-url"); // oldURL 접근시 newURL로 리다이렉트
		registry.addViewController("/old-url").setViewName("forward:/new-url"); //forwarding
		registry.addViewController("/static/**").setViewName("forward:/resources/static/"); //forwarding
		*/
		
	}
	
	/**
	 * @methodName      : configureAsyncSupport
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 21.
	 * @description     : Spring 비동기 처리관련
	 * 					  setDefaultTimeout(long timeout): 비동기 요청의 기본 처리 시간(타임아웃 시간)을 설정합니다.
	 * 					  setTaskExecutor(AsyncTaskExecutor taskExecutor): 비동기 작업을 처리할 태스크 실행기를 설정
	 * 					  setCallableInterceptors(AsyncHandlerInterceptor... interceptors): Callable 타입의 비동기 요청 처리에 사용될 인터셉터를 설정
	 * 					  registerDeferredResultInterceptors(DeferredResultProcessingInterceptor... interceptors):	DeferredResult 타입의 비동기 요청 처리에 사용될 인터셉터를 설정			
	 * 
	 * @param configurer
	 */
	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		log.info("============================== ServletContext configureAsyncSupport ==============================");
		//configurer.setDefaultTimeout(3000); // -1 무한대
		//configurer.setTaskExecutor(className); // 비동기 처리할 클래스 설정
		//configurer.registerCallableInterceptors(interceptorClasName); //Callable 타입의 비동기 처리할때 이용되는 인터셉터 설정
		//configurer.registerDeferredResultInterceptors(interceptorClasName); //DeferredResult  타입의 비동기 처리할때 이용되는 인터셉터 설정
	}
	
	/**
	 * @methodName      : configureContentNegotiation
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 21.
	 * @description     : 클라이언트와 서버 간의 콘텐츠 협상전략
	 *       			  콘텐츠 협상은 클라이언트가 요청한 콘텐츠 타입에 따라 서버가 적절한 응답을 반환하는 기능
	 * 
	 * @param configurer
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

		log.info(
				"============================== ServletContext configureContentNegotiation ==============================");
	     configurer
         .favorParameter(true) // URL 파라미터에 따라 콘텐츠 형식을 결정합니다.
         .parameterName("format") // URL 파라미터의 이름을 설정합니다. 기본값은 "format"입니다.
         .ignoreAcceptHeader(false) // 클라이언트의 Accept 헤더를 무시할지 여부를 설정합니다.
         .defaultContentType(MediaType.APPLICATION_JSON) // 기본 콘텐츠 타입을 설정합니다.
         .mediaType("xml", MediaType.APPLICATION_XML) // "xml" 파일 확장자에 대한 콘텐츠 타입을 설정합니다.
         .mediaType("json", MediaType.APPLICATION_JSON); // "json" 파일 확장자에 대한 콘텐츠 타입을 설정합니다.


	}
	
	/**
	 * @methodName      : configureDefaultServletHandling
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 21.
	 * @description     : 기본 서블릿 처리활성 , 비활성화
	 * 
	 * @param Configurer
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer Configurer) {
		log.info("============================== ServletContext configureDefaultServletHandling ==============================");
		
		//Configurer.enable(); //모든 기본처리
		//Configurer.enable("/resources"); //해당 패턴에만 기본 서블릿 처리
	}
	
	/**
	 * @methodName      : configureHandlerExceptionResolvers
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 21.
	 * @description     : 예외가 발생했을때 처리하는 용도 
	 * 					  여기에 등록을 하고 HandlerExceptionResolver 상속받는 클래스를 구현 
	 * 				      굳이 필요는 없을듯
	 * 
	 * @param arg0
	 */
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> arg0) {
		log.info(
				"============================== ServletContext configureHandlerExceptionResolvers ==============================");

	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> arg0) {
		log.info(
				"============================== ServletContext configureMessageConverters ==============================");

	}

	@Override
	public void configurePathMatch(PathMatchConfigurer arg0) {
		log.info("============================== ServletContext configurePathMatch ==============================");

	}

	/******************************************************************
	 * Controller의 메서드에서 반환하는 문자열 앞 뒤에 붙힐 경로를 셋팅
	 ******************************************************************/
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		log.info("============================== ServletContext configureViewResolvers ==============================");

		registry.jsp("/WEB-INF/views", ".jsp");

	}

	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> arg0) {
		log.info(
				"============================== ServletContext extendHandlerExceptionResolvers ==============================");

	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> arg0) {
		log.info(
				"============================== ServletContext extendMessageConverters ==============================");

	}

	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		log.info(
				"============================== ServletContext getMessageCodesResolver ==============================");
		return null;
	}

	@Override
	public Validator getValidator() {
		log.info("============================== ServletContext getValidator ==============================");
		return null;
	}
	

}
