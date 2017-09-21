package sample.websocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/query", configurator = CustomConfigurator.class)
public class WebSocketTestServer {

	@OnMessage
    public void onMessage(String message, Session session) 
    		throws IOException, InterruptedException {
		session.getBasicRemote().sendText("We got your query: " + message 
				+ "\nPlease wait for a while, we will response to you later.");
		Thread.sleep(5000);
		session.getBasicRemote().sendText("Sorry, we did not find the answer.");
    }
	
	@OnOpen
    public void onOpen () {
        System.out.println("Welcome to WebSocket world.");
    }

    @OnClose
    public void onClose () {
    	System.out.println("Connection closed, good bye!");
    }
}
