package com.planb.main;

import com.planb.support.utilities.Log;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class MainVerticle extends AbstractVerticle {
	@Override
	public void start() throws Exception {
		
	}
	
	@Override
	public void stop(@SuppressWarnings("rawtypes") Future stopFuture) throws Exception {
		Log.I("Server Stopped");
	}
}
