
package com.tayo.test.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author otalabi
 *
 */
@JsonAutoDetect
public class Response {
    private String responseCode;
    private String responseMessage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Data data;

    public Response(String s, String message) {
    }

    public Response() {
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }



    @Override
    public String toString() {
        return "Response{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", data=" + data +
                '}';
    }
}

