/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.trace.v2;

import com.seed.trace.core.ApiError;
import com.seed.trace.core.ClientOptions;
import com.seed.trace.core.ObjectMappers;
import com.seed.trace.core.RequestOptions;
import com.seed.trace.core.Suppliers;
import com.seed.trace.v2.problem._ProblemClient;
import com.seed.trace.v2.v3._V3Client;
import java.io.IOException;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public class _V2Client {
    protected final ClientOptions clientOptions;

    protected final Supplier<_ProblemClient> problemClient;

    protected final Supplier<_V3Client> v3Client;

    public _V2Client(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.problemClient = Suppliers.memoize(() -> new _ProblemClient(clientOptions));
        this.v3Client = Suppliers.memoize(() -> new _V3Client(clientOptions));
    }

    public void test() {
        test(null);
    }

    public void test(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
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

    public _ProblemClient problem() {
        return this.problemClient.get();
    }

    public _V3Client v3() {
        return this.v3Client.get();
    }
}
