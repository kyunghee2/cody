package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class TimeCheckAdvice {
	static final Logger LOGGER = LoggerFactory.getLogger("root");
	
	@Pointcut("execution(* spring.biz.user.service.UserService.*(..))")
	public void pointcut_1() {
		
	}
	@Around("pointcut_1()")
	public Object around(ProceedingJoinPoint pp) throws Throwable {
		String method = pp.getSignature().getName();
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		System.out.println("*************** 실행시간체크<start> ********************");		
		Object obj = pp.proceed();
		stopwatch.stop();
		System.out.println("메소드이름:"+method +"() => 실행시간:"+stopwatch.getTotalTimeMillis()+"(ms)초");
		System.out.println("*************** 실행시간체크<end> ********************");
		return obj;
	}
}
