package kr.co.sample.base.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @fileName        : GlobalHttpSessionAttributeListener.java
 * @author          : DaeGeun Ki
 * @date            : 2024. 4. 13.
 * @description     : HttpSession의 속성 변경 이벤트를 감지하고 처리하는 리스너
 *                    속성이 추가, 제거 및 변경될 때 이벤트 처리
 */
public class GlobalHttpSessionAttributeListener implements HttpSessionAttributeListener {
	
	/**
	 * @methodName      : attributeAdded
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 13.
	 * @description     : Session속성이 추가될 때 호출
	 * 
	 * @param event
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @methodName      : attributeRemoved
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 13.
	 * @description     : Session속성이 제거될 때 호출
	 * 
	 * @param event
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @methodName      : attributeReplaced
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 13.
	 * @description     : Session속성이 변경될 때 호출
	 * 
	 * @param event
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

}
