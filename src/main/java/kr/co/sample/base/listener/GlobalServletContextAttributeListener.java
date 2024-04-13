package kr.co.sample.base.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * @fileName        : GlobalServletContextAttributeListener.java
 * @author          : DaeGeun Ki
 * @date            : 2024. 4. 13.
 * @description     : ServletContext의 속성 변경 이벤트를 감지하고 처리하는 리스너
 * 					  추가, 제거 또는 변경이 될 때 이벤트 처리
 */
public class GlobalServletContextAttributeListener implements ServletContextAttributeListener {
	/**
	 * @methodName      : attributeAdded
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 13.
	 * @description     : 속성이 추가될 때 호출
	 * 
	 * @param event
	 */
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @methodName      : attributeRemoved
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 13.
	 * @description     : 속성이 삭제될 때 호출 
	 * 
	 * @param event
	 */
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @methodName      : attributeReplaced
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 13.
	 * @description     : 속성이 변경될 때 호출
	 * 
	 * @param event
	 */
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
