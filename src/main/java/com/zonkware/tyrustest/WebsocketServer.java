package com.zonkware.tyrustest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.glassfish.tyrus.server.Server;

import com.zonkware.tyrustest.endpoint.TestEndPoint;

public class WebsocketServer {
	
	public static void main(String args[]) {
		runServer();
	}
	
	public static void runServer() {
		Map<String, Object> properties = new HashMap<String, Object>();
		
		Server server = new Server("localhost", 8025, "/websockets", TestEndPoint.class);
		
		try {
			server.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Please press a key to stop the server.");
			reader.readLine();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			server.stop();
		}
	}
	
}
