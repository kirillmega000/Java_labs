package com.proj1Spring.models;
import org.springframework.hateoas.RepresentationModel;
public class BaseResponse extends RepresentationModel<BaseResponse> {

    private final String status;
    private final Integer code;

    public BaseResponse(String status, Integer code)  {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }
}