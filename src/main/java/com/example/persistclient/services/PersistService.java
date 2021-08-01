package com.example.persistclient.services;

import com.example.persistclient.global.ResponseCache;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Function;

@Service
public class PersistService {
    static Function[] responses = new Function[1];

    public static StreamingResponseBody getPersistStream() {
        try {
            setResponsesToSuccess();
            setAfterDelay(10000);
            StreamingResponseBody responseBody = out -> {
                while (true) {
                    responses[0].apply(out);
                }
            };

            return responseBody;
        } catch (Exception e) {

        }
        return out -> {
        };
    }

    public static void setAfterDelay(long delay) {
        try {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        setResponsesToFail();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }, delay); // 300 is the delay in millis
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setResponsesToSuccess() throws IOException {
        try {
            responses[0] = out -> {
                OutputStream newOut = (OutputStream) out;
//            System.out.println("Asd");
                //doesnt work with java classes
//                try (ObjectOutputStream outputClass = new ObjectOutputStream(out)) {
//                    outputClass.writeObject(ResponseCache.SuccessResponseBytes);
//                }
                try {
                    newOut.write(ResponseCache.SuccessResponseBytes);
                    newOut.flush();
//              Thread.sleep(Constants.thirtyMinutesMillis);
                    Thread.sleep(3000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            };
        } catch (Exception e) {
        }
    }

    public static void setResponsesToFail() throws IOException {
        try {
            responses[0] = out -> {
                OutputStream newOut = (OutputStream) out;
//            System.out.println("Asd");
                //doesnt work with java classes
//                try (ObjectOutputStream outputClass = new ObjectOutputStream(out)) {
//                    outputClass.writeObject(ResponseCache.SuccessResponseBytes);
//                }
                try {
                    newOut.write(ResponseCache.FailResponseBytes);
                    newOut.flush();
//              Thread.sleep(Constants.thirtyMinutesMillis);
                    Thread.sleep(3000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            };
        } catch (Exception e) {
        }
    }
}
