package com.example.persistclient.controllers;

import com.example.persistclient.global.Constants;
import com.example.persistclient.global.ResponseCache;
import com.example.persistclient.services.PersistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Controller
public class SocketApi {

    @GetMapping("/socket/persist")
    public ResponseEntity<StreamingResponseBody> getPersist(HttpServletRequest req, HttpServletResponse response) {
        StreamingResponseBody stream = PersistService.getPersistStream();
        return new ResponseEntity(stream, HttpStatus.OK);
    }
}
