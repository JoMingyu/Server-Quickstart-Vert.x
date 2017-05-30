package com.planb.restful;

import com.planb.support.doc_annotations.Function;
import com.planb.support.doc_annotations.RESTful;
import com.planb.support.routing.Route;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;

@Route(uri = "/sample", method = HttpMethod.POST)
@Function(name = "샘플", summary = "기능기능")
@RESTful(formAttributes = "key : Type, key2 : Type2", successCode = 201, failureCode = 204)
public class Sample implements Handler<RoutingContext> {
	@Override
	public void handle(RoutingContext ctx) {
		
	}
}
