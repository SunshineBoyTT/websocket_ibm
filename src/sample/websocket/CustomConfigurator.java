package sample.websocket;

import javax.websocket.server.ServerEndpointConfig;

public class CustomConfigurator extends ServerEndpointConfig.Configurator {
	
	private static final String ORIGIN = "http://jeremy.laptop:8080";

    @Override
    public boolean checkOrigin(String originHeaderValue) {
    	System.out.println(originHeaderValue);
    	if(originHeaderValue==null || originHeaderValue.trim().length()==0)
    		return true;
    	return true;
    }
}