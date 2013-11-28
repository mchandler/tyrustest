package com.zonkware.tyrustest.endpoint;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class TestEndPoint {
	
	@OnOpen
	public void onOpen(Session session) throws IOException {
		session.getBasicRemote().sendText("onOpen");
	}
	
	@OnMessage
	public String echo(String message) {
		return message + " (from your server)";
	}
	
	@OnError
	public void onError(Throwable t) {
		t.printStackTrace();
	}
	
	@OnClose
	public void onClose(Session session) {
		// do nothing
	}
	
}
