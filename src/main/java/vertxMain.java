import Server.ServerVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;



public class vertxMain {

    public static void main(String[] args) {


        // Create an HTTP server which simply returns "Hello World!" to each request.
        Vertx.vertx().deployVerticle(ServerVerticle.class.getName());
    }

}
