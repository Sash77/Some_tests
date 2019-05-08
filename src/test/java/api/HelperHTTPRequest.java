package api;

import appmanager.ApplicationManager;
import model.entity.EntityHeader;

import java.io.IOException;
import java.util.HashMap;

public class HelperHTTPRequest extends APIBase {

    public HelperHTTPRequest(ApplicationManager app) {
        super(app);
    }

    public int sendHeadersPost(EntityHeader header, String endPoint) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {

        String body = String.format("{\"id\":%s}", app.getDocID());

        HashMap<String, String> mapHandle = new HashMap<>();
        mapHandle.put("address", endPoint);

        return sendRequestHttpPost(mapHandle, returnHeaderParams(header), body);

    }

//    public int worklistTreeGetOperation(HashMap<String, String> params, String body, String endPoint) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
//        HashMap<String, String> mapHandle = new HashMap<>();
//        mapHandle.put("address",endPoint);
//
//
//        return sendRequestHttpGet(mapHandle, params, false);
//
//    }

}
