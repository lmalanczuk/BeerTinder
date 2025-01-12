//package com.bt.beertinder.websockettests;
//
//import com.bt.beertinder.model.ChatMessage;
//import java.lang.reflect.Type;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.messaging.converter.MappingJackson2MessageConverter;
//import org.springframework.messaging.simp.stomp.StompFrameHandler;
//import org.springframework.messaging.simp.stomp.StompHeaders;
//import org.springframework.messaging.simp.stomp.StompSession;
//import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.socket.client.standard.StandardWebSocketClient;
//import org.springframework.web.socket.messaging.WebSocketStompClient;
//import java.util.concurrent.TimeUnit;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//public class WebSocketChatTest {
//
//
//    @Autowired
//    private MockMvc mockMvc;
//    private WebSocketStompClient stompClient;
//    @LocalServerPort
//    private int port;
//
//    @BeforeEach
//    public void setup() {
//    stompClient = new WebSocketStompClient(new StandardWebSocketClient());
//    stompClient.setMessageConverter(new MappingJackson2MessageConverter());
//}
//
//    @Test
//    public void testWebSocketConnection() throws Exception {
//        StompSession session = stompClient
//            .connect("ws://localhost:8080/ws", new StompSessionHandlerAdapter() {})
//            .get(10, TimeUnit.SECONDS);
//
//        session.subscribe("/topic/messages/1", new StompFrameHandler() {
//            @Override
//            public Type getPayloadType(StompHeaders headers) {
//                return ChatMessage.class;
//            }
//
//            @Override
//            public void handleFrame(StompHeaders headers, Object payload) {
//                ChatMessage message = (ChatMessage) payload;
//                assertEquals("Hello, world!", message.getContent());
//            }
//        });
//
//        session.send("/app/chat.sendMessage", new ChatMessage("user1", "Hello, world!", 1L));
//    }
//}
