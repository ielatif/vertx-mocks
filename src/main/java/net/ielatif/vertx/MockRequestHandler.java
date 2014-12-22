package net.ielatif.vertx;

import org.vertx.java.core.Handler;
import org.vertx.java.core.buffer.Buffer;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.core.logging.Logger;

/**
 * Created by issam on 22/12/2014.
 */
public class MockRequestHandler implements Handler<HttpServerRequest> {

    Logger logger;

    String xmlResponse = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
            "<soap:Body>" + "<ns2:insertBookResponse xmlns:ns2=\"http://services.weblog4j.aranin.com/\">" +
            "<return>Book with name : Foundation and Earth is now available on the shelf</return>" +
            "</ns2:insertBookResponse></soap:Body></soap:Envelope>";

    @Override
    public void handle(HttpServerRequest httpServerRequest) {
        // log the request path
        logger.info(httpServerRequest.path());
        // the bodyHandler to parse request content
        httpServerRequest.bodyHandler(new Handler<Buffer>() {
            @Override
            public void handle(Buffer buffer) {
                String soapRequest = buffer.toString("UTF-8");
                logger.info(soapRequest);
            }
        });
        // send the response
        httpServerRequest.response().end(xmlResponse);
    }
}