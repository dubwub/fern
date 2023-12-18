/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.apiWideBasePath.service;

import com.seed.apiWideBasePath.core.ApiError;
import com.seed.apiWideBasePath.core.ClientOptions;
import com.seed.apiWideBasePath.core.ObjectMappers;
import com.seed.apiWideBasePath.core.RequestOptions;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class _ServiceClient {
    protected final ClientOptions clientOptions;

    public _ServiceClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public void post(String serviceParam, int endpointParam) {
        post(serviceParam, endpointParam, null);
    }

    public void post(String serviceParam, int endpointParam, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegment(serviceParam)
                .addPathSegment(Integer.toString(endpointParam))
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", RequestBody.create("", null))
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
