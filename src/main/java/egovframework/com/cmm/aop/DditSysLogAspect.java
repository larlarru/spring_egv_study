package egovframework.com.cmm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import kr.or.ddit.sample.service.impl.EgovSampleServiceImpl;

public class DditSysLogAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DditSysLogAspect.class);
	
	// returning="returnVal" 와 같은 의미
	public void logAfter(JoinPoint joinPoint, Object returnVal) throws Throwable {
		
		LOGGER.debug("logAfter aop 실행");
		LOGGER.debug("logAfter joinPoint : {}", joinPoint);
		LOGGER.debug("logAfter returnVal : {}", returnVal);
	}
	
	public Object logView(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// 실행될 Service 객체 제어를 하겠다....
		StopWatch stopWatch = new StopWatch();

		try {
			
			LOGGER.debug("logView aop 실행");
			LOGGER.debug("logView : {}", joinPoint.getArgs());
			
			// Service의 메소드를 실행 해라...
			stopWatch.start();
			
			// 실행된 결과 값을 반환을 받겠다.
			Object retValue = joinPoint.proceed();
			
			LOGGER.debug("logViewaop 실행 결과..........");
			LOGGER.debug("logView result : {}", retValue);
			
			// 처리된 프로세스를 controller 또는 호출자에게 값을 전달 함.
			return retValue;
			
			
		} catch (Throwable e) {
			throw e;
		} finally {
			// 제어를 중지 하고 aop 객체를 소멸 하겠다.
			stopWatch.stop();
			
			// stopWatch.stop(); 실행후 후처리 업무 로직을 작성을 해야함...(****** 필수) 
			// 조회 이력을 적재를 한다.
			
		}
	}
	
}
