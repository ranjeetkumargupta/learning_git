package com.wipro.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


import lombok.extern.slf4j.Slf4j;


@Aspect
@Slf4j
@Component
public class UserAspect {
	
	@Pointcut("execution(* com.wipro.service.UserService.*(..))")
	private void pointCut1() {
		
	}
	
	//@Before("execution ( public com.wipro.service.UserService.get*(..))")
	@Before("pointCut1()")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("JointPoint method is: ");
//		System.out.println(joinPoint.getSignature().getName());
		log.info(joinPoint.getSignature().getName());
	}
	
}


