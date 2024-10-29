package com.ust.gateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {
    public static final List<String> OpenApiEndpoints = List.of(
            "/cred/add",
            "/cred/validateuser",
            "/cred/validateToken");
    public Predicate<ServerHttpRequest> isSecured =
            request -> OpenApiEndpoints
                    .stream()
                    .noneMatch(uri -> request
                    .getURI()
                    .getPath()
                    .contains(uri));
}
