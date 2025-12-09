package org.example.EcommerceSpring.config;

import org.example.EcommerceSpring.gateway.api.FakeStoreCartApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import org.example.EcommerceSpring.gateway.api.FakeStoreCategoryApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetrofitConfig {

    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(FakeStoreCategoryApi.class);
    }

    @Bean
    public FakeStoreCartApi fakeStoreCartApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(FakeStoreCartApi.class);
    }
}
