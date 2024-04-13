package kr.co.sample.base.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @fileName        : GlobalServletContextListener.java
 * @author          : DaeGeun Ki
 * @date            : 2024. 4. 13.
 * @description     : 웹 애플리케이션의 생명주기 이벤트를 감지하고 처리하는 리스너
 * 					  웹 애플리케이션의 생성(초기화) 및 소멸(종료) 시에 이벤트 처리
 */
public class GlobalServletContextListener implements ServletContextListener {
	
	/**
	 * @methodName      : contextInitialized
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 13.
	 * @description     : 웹 애플리케이션이 생성(초기화)될 때 호출 
	 * 
	 * @param sce
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @methodName      : contextDestroyed
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 13.
	 * @description     : 웹 애플리케이션이 소멸(종료)될 떼 호출
	 * 
	 * @param sce
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
