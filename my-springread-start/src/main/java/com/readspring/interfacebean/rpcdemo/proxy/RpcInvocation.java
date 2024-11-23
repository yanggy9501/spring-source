package com.readspring.interfacebean.rpcdemo.proxy;

import com.readspring.interfacebean.rpcdemo.annotation.RpcMapping;
import com.readspring.interfacebean.rpcdemo.annotation.RpcService;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RpcInvocation implements InvocationHandler {

    private RestTemplate restTemplate;

    private Class<?> type;

    public RpcInvocation(RestTemplate restTemplate, Class<?> type) {
        this.restTemplate = restTemplate;
        this.type = type;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        RpcService rpcService = this.type.getAnnotation(RpcService.class);
        if (rpcService == null) {
            return result;
        }
        String host = rpcService.host();
        String protocol = rpcService.protocol();
        int port = rpcService.port();
        String url = protocol + "://" + host + ":" + port;

        RpcMapping rpcMapping = method.getAnnotation(RpcMapping.class);
        String uri = rpcMapping.uri();
        RequestMethod methodType = rpcMapping.method();

        url = url + uri;

//        HttpRequest getRequest = HttpUtil.createGet(url);
//        ObjectMapper objectMapper = new ObjectMapper();
//        byte[] bytes = objectMapper.writeValueAsBytes(args);
//        getRequest.body(bytes);
//        HttpResponse execute = getRequest.execute();
//        if (execute.isOk()) {
//            Class<?> returnType = method.getReturnType();
//            if (returnType != void.class) {
//                String body = execute.body();
//
//                System.out.println(body);
//                if (returnType != String.class) {
//                    result = objectMapper.readValue(body, returnType);
//                } else {
//                    result = body;
//                }
//            }
//        }

        return result;
    }
}
