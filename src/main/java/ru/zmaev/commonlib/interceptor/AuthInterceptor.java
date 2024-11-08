package ru.zmaev.commonlib.interceptor;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;
import ru.zmaev.commonlib.auth.AuthUtils;

@Component
public class AuthInterceptor implements Interceptor {

    private final AuthUtils authUtils;

    public AuthInterceptor(AuthUtils authUtils) {
        this.authUtils = authUtils;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder()
                .header("Authorization", "Bearer " + authUtils.getJwt());

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
