package pnnl.goss.core.server.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;

import pnnl.goss.core.server.TokenIdentifierMap;

@Path("/login")
public class LoginService {
	
	private volatile SecurityManager securityManager;
	
	private volatile TokenIdentifierMap tokenMap;	
	
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	@Produces(MediaType.APPLICATION_JSON)
	public String authenticate(UsernamePasswordToken params){
		String sessionToken = null;
		try{
			AuthenticationInfo info = securityManager.authenticate(params);
			sessionToken = tokenMap.registerIdentifier("ipaddress", params.getUsername());
			
		} catch(AuthenticationException e){
			return "{\"error\": \"Invalid Login\"}";
		}
		
		return "{\"token\": \"" + sessionToken + "\"}";
	}

}
