package kr.co.sample.base.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * @fileName        : GlobalServletRequsetAttributeListener.java
 * @author          : DaeGeun Ki
 * @date            : 2024. 4. 13.
 * @description     : ServletRequest의 속성변경 이벤트를 수신처리하는 리스너
 *                    ServletRequest 속성이 추가, 제거 또는 변경이 될때 특성 동작을 실행한다.
 */
public class GlobalServletRequsetAttributeListener implements ServletRequestAttributeListener {

	/**
	 * @methodName      : attributeAdded
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 13.
	 * @description     : 속성이 추가될 때 호출 
	 * 
	 * @param srae
	 */
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @methodName      : attributeRemoved
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 13.
	 * @description     : 속성이 제거될 때 호출 
	 * 
	 * @param srae
	 */
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @methodName      : attributeReplaced
	 * @author          : DaeGeun Ki
	 * @date            : 2024. 4. 13.
	 * @description     : 속성이 변경될 때 호출 
	 * 
	 * @param srae
	 */
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
	}

}
