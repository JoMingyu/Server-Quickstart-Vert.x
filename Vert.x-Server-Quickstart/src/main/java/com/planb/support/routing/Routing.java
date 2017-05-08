package com.planb.support.routing;

import java.util.Set;

import org.reflections.Reflections;

import com.planb.support.utilities.Log;

import io.vertx.core.Handler;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class Routing {
	@SuppressWarnings("unchecked")
	public static void route(Router router, String... packages) {
		for(String p : packages) {
			// 가변인자 패키지 네임 순회
			
			Reflections reflections = new Reflections(p);
			// 패키지에 대한 리플렉션
			
			Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(Route.class);
			// Route 어노테이션이 주입된 클래스 탐색
			
			for(Class<?> c : annotatedClasses) {
				// 클래스 순회
				
				Route ano = c.getAnnotation(Route.class);
				// 클래스의 Route 어노테이션 get
				
				try {
					router.route(ano.method(), ano.uri()).handler((Handler<RoutingContext>) c.newInstance());
					Log.I("Routed : " + ano.method() + " " + ano.uri());
				} catch (InstantiationException | IllegalAccessException e) {
					// 생성자가 public이 아니면 리플렉션으로 접근 불가능(IllegalStateException)
					e.printStackTrace();
				}
			}
		}
	}
}
