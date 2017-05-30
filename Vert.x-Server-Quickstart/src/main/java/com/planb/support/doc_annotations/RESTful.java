package com.planb.support.doc_annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface RESTful {
	String requestHeaders() default "X";
	String params() default "X";
	String formAttributes() default "X";
	int successCode() default 0;
	String responseHeaders() default "X";
	String responseBody() default "X";
	int failureCode() default 0;
}
