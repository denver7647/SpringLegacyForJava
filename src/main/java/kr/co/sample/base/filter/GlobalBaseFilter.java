package kr.co.sample.base.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @fileName        : GlobalBaseFilter.java
 * @author          : DaeGeun Ki
 * @date            : 2024. 4. 13.
 * @description     : 전역으로 처리하는 기본적인 Filter
 */
public class GlobalBaseFilter implements Filter {

	Logger log = LoggerFactory.getLogger(GlobalBaseFilter.class);
    
	/**
	 * @methodName      : init
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 21.
	 * @description     : FilterConfig를 통한 filter 설정
	 *                    서블릿 컨테이너가 필터 인스턴스 생성한 후 초기화 하기 위해서 사용 전 호출하는 메소드
	 * @param filterConfig
	 * @throws ServletException
	 */
	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    	log.debug("====================================== defaultFilter init ======================================\n");

    }
	/**
	 * @methodName      : doFilter
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 21.
	 * @description     : 필터에서 구현해야 하는 로직을 작성하는 메소드
	 * 
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	
    	// 처리 전
    	log.debug("====================================== defaultFilter doFilter start ======================================\n");
    	
    	chain.doFilter(request, response);
    	
    	// 처리 후
    	log.debug("====================================== defaultFilter doFilter end======================================\n");
    	
    }
    /**
     * @methodName      : destroy
     * @author          : DaeGeun Ki
     * @date            : 2024. 4. 21.
     * @description     : 필터 인스턴스를 종료시키기 전에 호출하는 메소드
     */
    @Override
    public void destroy() {
    	
    	log.debug("====================================== defaultFilter destroy ======================================\n");
    }
}
