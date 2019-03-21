package com.kh.spring.common.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.kh.spring.model.vo.Member;

@Component
@Aspect
public class LoggerAspect {

	private Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Pointcut("execution(* com.kh.spring..Memo*.*(..))")
	public void myPointcut() {
		
	}
	
	@Around("myPointcut()")
	/*around advice에 해당된다*/
	public Object loggerAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		Signature sig = joinPoint.getSignature();
		String type = sig.getDeclaringTypeName();//클래스 이름
		String method = sig.getName();//메소드 이름
		
		String componentType="";
		if(type.indexOf("Controller")>-1) {
			componentType = "Controller \t: ";
		}
		else if(type.indexOf("Service")>-1) {
			componentType = "Service \t: ";
		}
		else if(type.indexOf("Dao")>-1) {
			componentType = "Dao \t: ";
		}
		logger.warn("[before]"+componentType+type+"."+method+"()");
		Object obj = joinPoint.proceed();
		logger.warn("[after]"+componentType+type+"."+method+"()");
		return obj;
	}
	
	/*로그인 했을때 정보를 파악할때 편하다.*/
	/*@Pointcut("execution(* com.kh.spring..Member*.*(..))")*/
	@Pointcut("execution(* com.kh.spring..MemberDao.*(..))")
	public void beforePoint() {
		
	}
	
	@Before("beforePoint()")
	public void beforeLogger(JoinPoint joinPoint) throws Exception {
		
		/* joinPoint 해당 정보를 가지고 있기에 여러가지 정보를 가져올 수 있다 */
		/* 요청했을때 클래스, 메소드, 파라미터에 대한 정보 */
		
		/*session 값 가져오기*/
		
		//HttpSession session = (HttpSession) RequestContextHolder.currentRequestAttributes().resolveReference(RequestAttributes.REFERENCE_SESSION);
		//HttpRequest request = (HttpRequest) RequestContextHolder.currentRequestAttributes().resolveReference(RequestAttributes.REFERENCE_REQUEST);
		
		Signature sig = joinPoint.getSignature();
		Object[] objs = joinPoint.getArgs();
		
		for(Object o : objs) {
			logger.warn("매개변수 : "+o);
			
			/*오브젝트 o 안에 Member 라는 객체가 있나?*/
			Member m = null;
			if(o instanceof Member) {
				m = (Member)o;
			}
			if(m!=null && !"admin".equals(m.getUserId())) {
				throw new Exception();
			}
			
		}
		
		logger.warn("before : " + sig.getDeclaringTypeName());
	}
	
	@After("execution(* com.kh.spring..Member*.*(..))")
	public void afterLogger(JoinPoint joinPoint) {
			logger.warn("After : 한방에!");
	}
}
