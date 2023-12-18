/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.api.svc;

import com.seed.api.core.ApiError;
import com.seed.api.core.ClientOptions;
import com.seed.api.core.ObjectMappers;
import com.seed.api.core.RequestOptions;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class _SvcClient {
    protected final ClientOptions clientOptions;

    public _SvcClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public String test() {
        return test(Test.builder().build());
    }

    public String test(Test request) {
        return test(request, null);
    }

    public String test(Test request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("test");
        if (request.getSomeEnum().isPresent()) {
            httpUrl.addQueryParameter("some-enum", request.getSomeEnum().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), String.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
