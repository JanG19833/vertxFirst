package Server;

import io.vertx.core.*;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

/**
 * Created by jge on 28.08.15.
 */
public class ServerVerticle implements Verticle {

    Logger LOGGER = LoggerFactory.getLogger(ServerVerticle.class.getName());

    @Override
    public Vertx getVertx() {
        return null;
    }

    @Override
    public void init(Vertx vertx, Context context) {

    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        Vertx vertx = Vertx.vertx();
        LOGGER.info("First Verticle Deployed");
        vertx.createHttpServer().requestHandler(req -> req.response().end("Hello World!!")).listen(8080);
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {

    }
}
