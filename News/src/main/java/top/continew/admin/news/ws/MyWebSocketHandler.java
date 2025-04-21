package top.continew.admin.news.ws;

import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import top.continew.admin.news.service.ChatService;


@RequiredArgsConstructor
@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

    private final ChatService chatService;
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("连接已建立：" + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("收到消息：" + message.getPayload());
//        session.sendMessage(chatService.getRepoByCategoryId(Long.valueOf(message.getPayload())));
        session.sendMessage(new TextMessage("服务端回应:" + chatService.getRepoByCategoryId(Long.valueOf(message.getPayload())) ));
    }

    // 连接后发送默认消息

    @Override
    public void afterConnectionClosed(WebSocketSession session, org.springframework.web.socket.CloseStatus status) throws Exception {
        System.out.println("连接关闭：" + session.getId());
    }
}