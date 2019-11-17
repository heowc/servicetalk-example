package com.example;

import io.servicetalk.http.netty.HttpServers;

import static io.servicetalk.concurrent.api.Single.succeeded;
import static io.servicetalk.http.api.HttpSerializationProviders.textSerializer;

public class GettingStartedApplication {

    public static void main(String[] args) throws Exception {
        HttpServers
                .forPort(8080)
                .listenAndAwait((ctx, request, responseFactory) ->
                        succeeded(responseFactory.ok().payloadBody("Hello World, ServiceTalk!", textSerializer())))
                .awaitShutdown();
    }
}
