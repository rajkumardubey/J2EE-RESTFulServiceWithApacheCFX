/**
 * <p>
 * 	HelloWorldService will be the entry point for the webservice
 * </p>
 */
package com.self.learning.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.self.learning.vo.HelloWorldVO;

/**
 * @author Raj Kumar Dubey
 */

@Path("/")
public interface HelloWorldService {

	@GET
	@Path("/echo/{input}")
	@Produces("text/plain")
	public String ping(@PathParam("input") String input);

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/helloworld")
	public Response modifyJson(HelloWorldVO input);
}
