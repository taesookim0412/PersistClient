package com.example.persistclient.services;

import com.example.persistclient.global.ResponseCache;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.ObjectOutputStream;

@Service
public class PersistService {

    public static StreamingResponseBody getPersistStream() {
        return out -> {
            while (true) {
                System.out.println("Asd");
                //doesnt work with java classes
//                try (ObjectOutputStream outputClass = new ObjectOutputStream(out)) {
//                    outputClass.writeObject(ResponseCache.SuccessResponseBytes);
//                }
                out.write(ResponseCache.SuccessResponseBytes);
                out.flush();

                try {
//                    Thread.sleep(Constants.thirtyMinutesMillis);
                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
    }
}
