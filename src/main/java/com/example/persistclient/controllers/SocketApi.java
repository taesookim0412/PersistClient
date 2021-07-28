package com.example.persistclient.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Controller
public class SocketApi {

    @GetMapping("/socket/persist")
    public ResponseEntity<StreamingResponseBody> getPersist(HttpServletRequest req, HttpServletResponse response){
        StreamingResponseBody stream = out -> {
            for (int i = 0; i < 10; i++){
                String msg = "/srb" + " @ " + new Date();
                out.write(msg.getBytes());
                System.out.println("Sending");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        System.out.println("Responded");
        return new ResponseEntity(stream, HttpStatus.OK);
    }
}
