package com.example.persistclient.global;

import java.nio.charset.StandardCharsets;

public class ResponseCache {
    public static StatusResponse SuccessResponse = new StatusResponse(Constants.SUCCESS);
//    public static byte[] SuccessResponseBytesUTF = SuccessResponse.toString().getBytes(StandardCharsets.UTF_8);
    public static byte[] SuccessResponseBytes = ("{ \"status\": " + "\"success\" }").getBytes();
    public static byte[] FailResponseBytes = ("{ \"status\": " + "\"fail\"}").getBytes();

}
