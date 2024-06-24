package kr.co.sample.base.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import kr.co.sample.base.filter.GlobalBaseFilter;
import kr.co.sample.base.listener.GlobalHttpSessionAttributeListener;
import kr.co.sample.base.listener.GlobalHttpSessionListener;
import kr.co.sample.base.listener.GlobalServletContextAttributeListener;
import kr.co.sample.base.listener.GlobalServletContextListener;
import kr.co.sample.base.listener.GlobalServletRequestListener;


public class WebMvcConfig implements WebApplicationInitializer  {
	
	Logger log = LoggerFactory.getLogger(WebMvcConfig.class);
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// dispatcherServlet 설정
		log.debug("==================== onStartup ====================");
		
		registDispatcherServlet(servletContext);
		registRootAppContext(servletContext);
		registUTF8Filter(servletContext);
		registFilter(servletContext); 
		registListener(servletContext);
	
	}

	/************************************************************************************
	 *
	 * web.xml의 dispatcherServlet 설정부분
	 *
	 ***********************************************************************************/
	private void registDispatcherServlet(ServletContext servletContext) {
		
		//dispatcherServlet 설정
		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
		
		servletAppContext.register(ServletConfig.class);
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
		
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
	}
	
	/************************************************************************************
	 *
	 * web.xml의 rootConfig 설정부분 -- 네이밍 한번확인하자
	 * config파일 늘어나면 여기에다가 설정하면 될것으로 보임
	 *
	 ***********************************************************************************/
	private void registRootAppContext(ServletContext servletContext) {
		
		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
		rootAppContext.register(RootAppContext.class);
		
		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
		servletContext.addListener(listener);
		
	
	}
	
	/************************************************************************************
	 *
	 * UTF-8 설정
	 *
	 ***********************************************************************************/
	private void registUTF8Filter(ServletContext servletContext) {
	
		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		filter.setInitParameter("encoding", "UTF-8");
		filter.setInitParameter("forceEncoding", "true");
		filter.addMappingForServletNames(null, false, "dispatcher");
		
	}
	
	/************************************************************************************
	 *
	 * Filter 설정
	 *
	 ***********************************************************************************/
	private void registFilter(ServletContext servletContext) {
		
		FilterRegistration.Dynamic filter = servletContext.addFilter("GlobalBaseFilter", GlobalBaseFilter.class);
		filter.addMappingForServletNames(null, false, "dispatcher");
		
	}
	
	/************************************************************************************
	 *
	 * Listener 설정
	 *
	 ***********************************************************************************/
	private void registListener(ServletContext servletContext) {
		
		//ServletContext의 생명주기 이벤트 처리
		servletContext.addListener(GlobalServletContextListener.class);
		//HttpSession의 생명주기 이벤트 처리
		servletContext.addListener(GlobalHttpSessionListener.class);
		//ServletRequest의 생명주기 이벤트 처리
		servletContext.addListener(GlobalServletRequestListener.class);
		//ServletContext의 속성변경 이벤트 처리
		servletContext.addListener(GlobalServletContextAttributeListener.class);
		//HttpSession의 속성변경 이벤트 처리
		servletContext.addListener(GlobalHttpSessionAttributeListener.class);
		//ServletRequest의 속성변경 이벤트 처리
		servletContext.addListener(GlobalServletRequestListener.class);
		//HttpSession의 ID 변경 이벤트 처리
		servletContext.addListener(GlobalHttpSessionListener.class);
		
	}
	
	

}
