package com.swaggerdemo.conf;


import com.swaggerdemo.resource.MyResource;
import io.swagger.v3.jaxrs2.integration.resources.AcceptHeaderOpenApiResource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationPath("rest")
public class AppConfig extends Application {
    public AppConfig() {
    }

    public Set<Class<?>> getClasses() {
        return Stream.of(MyResource.class, OpenApiResource.class, AcceptHeaderOpenApiResource.class).collect(Collectors.toSet());
    }

}