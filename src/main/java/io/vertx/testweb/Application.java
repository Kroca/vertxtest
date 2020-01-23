package io.vertx.testweb;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class Application extends AbstractVerticle {
    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        vertx.createHttpServer()
                .requestHandler(ra -> ra.response().end("ok"))
                .listen(8080, result -> {
                    if(result.succeeded()){
                        startPromise.complete();//
                    }else{
                        startPromise.fail(result.cause());
                    }
                });
    }
}
