import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by vdBerg on 3/1/17.
 */
public class FinagleRunner {

    //zie ook :
    //      https://github.com/making/finagle-java-example/blob/master/src/main/java/sample/http/HttpClient.java
    //      http://www.hascode.com/2013/12/jax-rs-2-0-rest-client-features-by-example/

    public static Future<Response> getAsyncHttp(final String url) {

        return ClientBuilder.newClient().target(url).request().async().get();
    };

    public static void main (String [] args) throws InterruptedException, ExecutionException{
        MyResponseFilter <Response, Request> respfilter = new MyResponseFilter<>();

        Future<Response> response = getAsyncHttp("http://www.nofrag.com");
        while (!response.isDone()) {
            System.out.println("Still waiting...");
            Thread.sleep(10);
        }
        System.out.println(response.get().readEntity(String.class));


    }
}
