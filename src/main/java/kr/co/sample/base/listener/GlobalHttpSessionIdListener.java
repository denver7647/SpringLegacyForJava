package kr.co.sample.base.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

/**
 * 
 * @fileName        : GlobalHttpSessionIdListener.java
 * @author          : DaeGeun Ki
 * @date            : 2024. 4. 13.
 * @description     : HttpSession의 ID가 변경될 때 이벤트를 수신하고 처리하는 리스너
 *                    HttpSeesion은 클라이언트와 서버 간의 상태를 유지하는데 사용하며 고유 ID를 지니고있음
 */
public class GlobalHttpSessionIdListener implements HttpSessionIdListener  {
	
	/**
	 * @methodName      : sessionIdChanged
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 13.
	 * @description     : 세션 ID가 변경될 때 호출 
	 * 
	 * @param event
	 * @param oldSessionId
	 */
	@Override
	public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
		// TODO Auto-generated method stub
		
	}

}
