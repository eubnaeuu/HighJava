package kr.or.ddit.basic;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class MySessionBindingListener implements HttpSessionBindingListener{
	
	
	// 바운딩은 getattribute, setattribute 같은 것들을 말함
	
	// 이 리스너는 세션에 바인딩, 언바인딩 되는 이벤트 객체 자체에 관심이 있는 것.(세션에서 등록되거나 삭제)
	/**
	 * HTTP세션 영역내에서 HttpSessionBindingListener를 구현한 객체가 [바인딩] 되면 호출됨.
	 * @param hsbe
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent hsbe) {
		String attrName = hsbe.getName();
		System.out.println("[] "+ this.getClass() + "객체가" + attrName + "으로 바인딩 됨");
	}
	
	
/**
 * HTTP세션 영역내에서 HttpSessionBindingListener를 구현한 객체가 [언바인딩] 되면 호출됨.
 * @param hsbe
 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent hsbe) {
		String attrName = hsbe.getName();
		System.out.println("[] "+ this.getClass() + "객체가" + attrName + "으로 언바인딩 됨");
	}

}
