package com.planb.support.routing;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface REST {
	String requestHeaders() default "X";
	String requestParams() default "X";
	String requestBody() default "X";
	String responseHeaders() default "X";
	String responseBody() default "X";
	int successCode() default 0;
	int failureCode() default 0;
	String etc() default "X";
}
