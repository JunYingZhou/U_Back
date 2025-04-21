package top.continew.admin.news.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import top.continew.admin.news.ws.MyWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig1 implements WebSocketConfigurer {

    @Autowired
    private MyWebSocketHandler myWebSocketHandler;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myWebSocketHandler, "/ws/anti/analysis").setAllowedOrigins("*");
    }
}
