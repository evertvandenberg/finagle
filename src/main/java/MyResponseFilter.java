import com.twitter.finagle.Filter;
import com.twitter.finagle.Service;
import com.twitter.util.Future;

import javax.ws.rs.core.Response;

/**
 * Created by vdBerg on 3/1/17.
 */
public class MyResponseFilter<REQ, Response> extends Filter <REQ, Response, REQ, Response>{

    @Override
    public Future<Response> apply(REQ req, Service<REQ, Response> service) {
        return service.apply(req);
    }
}
