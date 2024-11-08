package ru.zmaev.commonlib.configuration;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.zmaev.commonlib.api.SupportServiceApi;
import ru.zmaev.commonlib.auth.AuthUtils;
import ru.zmaev.commonlib.interceptor.AuthInterceptor;

@Configuration
public class RetrofitConfig {

    private @Value("${service-url}") String adminServiceUrl;

    private final AuthUtils authUtils;

    public RetrofitConfig(@Autowired AuthUtils authUtils) {
        this.authUtils = authUtils;
    }

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new AuthInterceptor(authUtils))
                .build();
    }

    @Bean
    public Retrofit retrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(adminServiceUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Bean
    public SupportServiceApi createSupportService(Retrofit retrofit) {
        return retrofit.create(SupportServiceApi.class);
    }
}
