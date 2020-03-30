package com.chen.stream_producer;

import com.chen.stream_producer.producer.MessageSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StreamProducerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private MessageSender messageSender;

    @Test
    public void test(){
        for(int i=0;i<10;i++){
            messageSender.send("hello stream！--->"+i);
        }
    }

}
