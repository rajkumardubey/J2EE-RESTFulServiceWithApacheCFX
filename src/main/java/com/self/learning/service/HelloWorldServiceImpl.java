/**
 * <p>
 * 	HelloWorldServiceImpl is the implementation class for HelloWorldService Interface.
 * </p>
 */
package com.self.learning.service;

import javax.ws.rs.core.Response;

import com.self.learning.vo.HelloWorldVO;

/**
 * @author Raj Kumar Dubey
 */
public class HelloWorldServiceImpl implements HelloWorldService {

	public String ping(String input) {
		return input;
	}

	public Response modifyJson(HelloWorldVO input) {
		input.setVal2(input.getVal1());
		return Response.ok().entity(input).build();
	}
}
