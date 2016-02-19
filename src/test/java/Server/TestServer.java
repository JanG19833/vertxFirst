package Server;

import Server.ServerVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class TestServer {
    Vertx vertx;
    HttpClient httpClient;

    @Before
    public void setUp(){
        vertx = Vertx.vertx();
        httpClient = vertx.createHttpClient();
        vertx.deployVerticle(ServerVerticle.class.getName());
    }

    @After
    public void tearDown(TestContext context){
        vertx.close(context.asyncAssertSuccess());
    }

    @Test
    public void testHttpRequest(TestContext context){
        Async async = context.async();
        httpClient.getNow(8080, "localhost", "/", response -> response.bodyHandler(body -> {
            context.assertEquals("Hello World!!", body.toString());
            httpClient.close();
            async.complete();
        }));
    }
    @Test
    public void testHttpRequestFail(TestContext context){
        Async async = context.async();
        httpClient.getNow(8080, "localhost", "/",response -> response.bodyHandler(body ->{
            context.assertNotEquals("Hello", body.toString());
            httpClient.close();
            async.complete();
        }));
    }
}
