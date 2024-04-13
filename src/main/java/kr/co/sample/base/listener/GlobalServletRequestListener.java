package kr.co.sample.base.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @fileName        : GlobalServletRequestListener.java
 * @author          : DaeGeun Ki
 * @date            : 2024. 4. 13.
 * @description     : HTTP요청에 대한 리스너로 클라이언트가 서버에 요청을 보낼때 이벤트 처리
 *                    HTTP요청 및 완료시에 이벤트 처리
 */
public class GlobalServletRequestListener implements ServletRequestListener {
	
	/**
	 * @methodName      : requestDestroyed
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 13.
	 * @description     : HTTP요청이 시작될 때 호출
	 * 
	 * @param sre
	 */
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @methodName      : requestInitialized
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 13.
	 * @description     : HTTP요청이 완료될 때 호출
	 * 
	 * @param sre
	 */
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}

}
