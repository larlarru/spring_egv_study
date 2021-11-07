package kr.or.ddit.sample.service.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class DditSysLogAspect {
	
	public Object logInsert(ProceedingJoinPoint joinPoint) throws Throwable {

		StopWatch stopWatch = new StopWatch();

		try {
			stopWatch.start();

			Object retValue = joinPoint.proceed();
			return retValue;
			
			
		} catch (Throwable e) {
			throw e;
		} finally {
			stopWatch.stop();
		}
	}
	
}
