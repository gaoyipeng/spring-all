package com.sxdx.springmvc.entity.response;

public enum ResponseCode {
    SUCCESS(200, "Success!"),
    UNAUTHORIZED(401, "Unauthorized!"),
    ACCESS_DENIED(403, "Access denied!"),
    NOT_FOUND(404, "Not found!"),
    INTERNAL_ERROR(5000, "Internal server error!"),
    MISSING_REQUEST_BODY(9000, "Required request body is missing!"),
    DUPLICATED_KEY(9001, "Duplicated key!"),
    INVALID_FIELD_VALUE(9002, "Invalid field value."),
    INVALID_PROPERTY_VALUE(9003, "Invalid property values.");

    private int code;
    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }

}
