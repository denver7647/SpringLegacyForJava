
package kr.co.sample.base.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @fileName : GlobalBaseInterceptor.java
 * @author : DaeGeun Ki
 * @date : 2024. 4. 13.
 * @description : 전역으로 처리하는 Global interceptor HandlerInterceptor
 * 
 *              인터페이스 HandlerInterceptorAdapter 구현
 * 
 *              Spring홈페이지에서 HandlerInterceptor or AsyncHandlerInterceptor 권장
 * 
 *              default로 preHandle , postHandle , afterCompletion ,
 *              afterConcurrentHandlingStarted 모두 override 권장
 * 
 */
public class GlobalBaseInterceptor implements HandlerInterceptor {

	private Logger log = LoggerFactory.getLogger(GlobalBaseInterceptor.class);

	/**
	 * @methodName : preHandle
	 * @author : DaeGeun Ki
	 * @date : 2024. 4. 21.
	 * @description : 전처리 작업
	 * 
	 * @param request
	 * @param response
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

		log.debug("==================== preHandle interceptor ====================");

		log.debug(" Request : " + request);
		log.debug(" Request Url : " + request.getRequestURI());
		log.debug(" Request Method : " + request.getMethod());
		log.debug(" Request Parameters : " + getParameters(request));

		return true;

	}

	/**
	 * @methodName : postHandle
	 * @author : DaeGeun Ki
	 * @date : 2024. 4. 21.
	 * @description : 후처리 작업
	 * 
	 * @param request
	 * @param response
	 * @param obj
	 * @param mv
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mv)
			throws Exception {

	}

	/**
	 * @methodName : afterCompletion
	 * @author : DaeGeun Ki
	 * @date : 2024. 4. 21.
	 * @description : 후 처리 이후 작업
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @param exc
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response,
			final Object handler, final Exception exc) throws Exception {

	}

	/*
	 * @Override public void afterConcurrentHandlingStarted(HttpServletRequest
	 * request, HttpServletResponse response, Object handler) throws Exception {
	 * 
	 * log.
	 * debug("====================================== afterConcurrentHandlingStarted interceptor ======================================\n"
	 * );
	 * 
	 * }
	 */
	private String getParameters(HttpServletRequest request) {
		StringBuffer posted = new StringBuffer();
		Enumeration<?> e = request.getParameterNames();
		if (e != null) {
			posted.append("?");
		}
		while (e.hasMoreElements()) {
			if (posted.length() > 1) {
				posted.append("&");
			}
			String curr = (String) e.nextElement();
			posted.append(curr + "=");
			if (curr.contains("password") || curr.contains("pass") || curr.contains("pwd")) {
				posted.append("*****");
			} else {
				posted.append(request.getParameter(curr));
			}
		}
		String ip = request.getHeader("X-FORWARDED-FOR");
		String ipAddr = (ip == null) ? getRemoteAddr(request) : ip;
		if (ipAddr != null && !ipAddr.equals("")) {
			posted.append("&_psip=" + ipAddr);
		}
		return posted.toString();
	}

	private String getRemoteAddr(HttpServletRequest request) {
		String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
		if (ipFromHeader != null && ipFromHeader.length() > 0) {
			log.debug("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
			return ipFromHeader;
		}
		return request.getRemoteAddr();
	}

}