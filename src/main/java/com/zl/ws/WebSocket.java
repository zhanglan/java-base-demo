package com.zl.ws;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;


@ServerEndpoint(value="/websocket/threadsocket/{user_id}")
// WebSocket实现类
@Component
@Slf4j
public class WebSocket {

    private Session session;

    private static ConcurrentHashMap<String,Session> sessionPool = new ConcurrentHashMap<>();

    private static ConcurrentHashMap<String,String> sessionIds = new ConcurrentHashMap<>();


    @OnOpen
    public void onOpen(Session session, @PathParam(value="user_id") String userId) {
        log.info("[websocket]消息:成功建立起连接");
        this.session = session;
        if (!sessionPool.containsKey(userId)) {
            sessionPool.put(userId, session);
            sessionIds.put(session.getId(), userId);
        }
        sendMessage(userId, "连接建立成功，当前用户：" + userId);
        log.info("【websocket消息】用户id为"+userId+"的用户加入了连接，总数为："+sessionPool.size());
    }

    // 连接关闭时触发，移除掉数据
    @OnClose
    public void OnClose() {
        log.info("[websocket消息]sessionIds的长度为:"+sessionIds.size());
        sessionPool.remove(sessionIds.get(session.getId()));
    }

    // 收到信息时触发
    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】userId为"+sessionIds.get(session.getId())+"的用户发来消息，内容为:"+message);
    }

    // 连接发生错误时触发
    @OnError
    public void onError(Session session,Throwable error) {
        log.error("【websocket消息】websocket occurs error.content is :"+error);
    }

    // 发送消息给前端的基础模块
    public void sendMessage(String userId, String message) {
        Session s = sessionPool.get(userId);
        if(s!=null) {
            try{
                s.getBasicRemote().sendText(message);
            }catch (Exception e) {
                log.error("【websocket消息】error occurs in WebSocket on sendMessage.error content is:"+e);
                e.printStackTrace();
            }
        }
    }

    // 发送消息给选定的用户
    public void sendMany(String msg, String[] userIds) {
        for(String userId: userIds) {
            sendMessage(userId, msg);
        }
    }

    // 广播消息到所有用户
    public void sendAll(String msg) {
        for(String key: sessionIds.keySet()) {
            sendMessage(sessionIds.get(key), msg);
        }
    }

}
