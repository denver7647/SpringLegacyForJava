package kr.co.sample.base.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @fileName        : GlobalHttpSessionListener.java
 * @author          : DaeGeun Ki
 * @date            : 2024. 4. 13.
 * @description     : HttpSession의 생명주기 이벤트를 처리하는 리스너
 * 					  HttpSession의 세션이 생성 or 소멸시 이벤트 감지
 */
public class GlobalHttpSessionListener implements HttpSessionListener{
	
	/**
	 * @methodName      : sessionCreated
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 13.
	 * @description     : 세션이 생성이될 때 동작 
	 * 
	 * @param se
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @methodName      : sessionDestroyed
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 13.
	 * @description     : 세션이 소멸될 때 동작 
	 * 
	 * @param se
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

}
