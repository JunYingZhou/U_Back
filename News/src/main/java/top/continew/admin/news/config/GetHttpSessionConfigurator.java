package top.continew.admin.news.config;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.HandshakeResponse;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.ServerEndpointConfig;

public class GetHttpSessionConfigurator extends ServerEndpointConfig.Configurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        //获取HttpSession对象
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        //将httpSession对象保存起来
        sec.getUserProperties().put(HttpSession.class.getName(),httpSession);
    }
}
