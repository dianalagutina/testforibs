package com.example.a.b.c.demo2903;

import com.example.a.b.c.Add;
import com.example.a.b.c.AddResponse;
import com.example.a.b.c.ObjectFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculatorEndpoint {
    private static final String NAMESPACE_URI = "http://c.b.a";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "add")
    @ResponsePayload
    public AddResponse addResponse(@RequestPayload Add request) {
        Integer summ = request.getN1() + request.getN2();

        ObjectFactory factory = new ObjectFactory();
        AddResponse responseSumm = factory.createAddResponse();
        responseSumm.setReturn(summ);

        return responseSumm;
    }
}
