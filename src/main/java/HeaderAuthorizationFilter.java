

import com.twitter.finagle.Filter;
import com.twitter.finagle.Service;
import com.twitter.finagle.http.Request;
import com.twitter.util.Future;

public class HeaderAuthorizationFilter<res> extends Filter<Request, res, Request, res> {

    @Override
    public Future<res> apply(Request request, Service<Request, res> service) {
        return null;
    }
}