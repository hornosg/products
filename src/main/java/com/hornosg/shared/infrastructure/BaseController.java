package com.hornosg.shared.infrastructure;

import java.util.Map;

public abstract class BaseController {
    public static final String BASE_URI = "hornosg";
    public static final String MESSAGE_REQUEST_WITHOUT_BODY = "Request body does not empty";
    protected Boolean emptyBody(Map<String, Object> requestBody) {
        return requestBody.isEmpty();
    }
}