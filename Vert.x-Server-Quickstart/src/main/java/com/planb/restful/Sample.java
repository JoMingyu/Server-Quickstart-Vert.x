package com.planb.restful;

import com.planb.support.routing.Route;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;

@Route(uri = "/test", method = HttpMethod.POST)
public class Sample implements Handler<RoutingContext> {
	@Override
	public void handle(RoutingContext ctx) {
		ctx.response().setStatusCode(201).end();
		ctx.response().close();
	}
}
