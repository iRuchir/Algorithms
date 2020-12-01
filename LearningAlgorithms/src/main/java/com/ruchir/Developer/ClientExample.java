package com.ruchir.Developer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class ClientExample {
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		String url = "https://jsonplaceholder.typicode.com/users";
		String name = client.target(url).request(MediaType.TEXT_PLAIN).get(String.class);
		/*
		 * WebTarget target = client.target(url); Response response =
		 * target.request().get();
		 * System.out.println(target.getUri()+":"+response.toString());
		 */
		System.out.println(name);
		client.close();
	}
}
