package pnnl.goss.core.client.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


import pnnl.goss.core.client.ClientConfiguration;

@RunWith(MockitoJUnitRunner.class)
public class ClientConfigurationTest {
	
	@Test
	public void clientConfiguration_set_get_test(){
		
		ClientConfiguration clientConfiguration = new ClientConfiguration();
		
		clientConfiguration.set("key", "value");
		
		assertNotNull(clientConfiguration.get("key"));
		
		assertEquals(clientConfiguration.get("key"), "value");
		
		
	}

	@Test
	public void clientConfiguration_set_getAsString_test(){
		
		ClientConfiguration clientConfiguration = new ClientConfiguration();
		
		clientConfiguration.set("key", "value");
		
		assertNotNull(clientConfiguration.getAsString("key"));
		
		assertEquals(clientConfiguration.getAsString("key"), "value");
		
		
	}

}
