package model.specification;

import appmanager.ApplicationManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class SpecificationRequest {

    protected ApplicationManager app;

    private RequestSpecification requestRegular;

    public SpecificationRequest(ApplicationManager app) {
        this.app = app;

        requestRegular = new RequestSpecBuilder()
                .setBaseUri(app.getURL())
                .setPort(app.getApiPort())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public RequestSpecification getRequestRegular() {
        return requestRegular;
    }
}
