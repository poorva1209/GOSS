package pnnl.goss.core.client.test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.naming.ConfigurationException;

import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import pnnl.goss.core.Client.PROTOCOL;
import pnnl.goss.core.GossCoreContants;
import pnnl.goss.core.client.ClientServiceFactory;
import pnnl.goss.core.client.GossClient;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceFactoryTest {
	
	@Mock
	GossClient gossClient;
	
	@Captor
	ArgumentCaptor<Boolean> argCaptorBoolean;
	
	ClientServiceFactory clientServiceFactory;
	
	
	@Before
	public void before(){
		clientServiceFactory = new ClientServiceFactory();
	}
	
	
	
	@Test
	public void setOpenwireUri_test(){
		
		
		clientServiceFactory.setOpenwireUri("tcp://0.0.0.0:61616");
		assertEquals(clientServiceFactory.getOpenwireUri(GossCoreContants.PROP_OPENWIRE_URI), "tcp://0.0.0.0:61616");
		
	}
	
	@Test
	public void addClient_whenCreatecalled() throws Exception{
		
		Credentials credentials = new UsernamePasswordCredentials("system","manager");
		clientServiceFactory.create(PROTOCOL.OPENWIRE, credentials);
		
		Mockito.verify(gossClient).setUsed(argCaptorBoolean.capture());
		
		Boolean arg = argCaptorBoolean.getValue();
		assertEquals(arg, "true");
		
		
	}
	
	
	@Test
	public void checkProperties_whenUpdatedcalled() throws FileNotFoundException, IOException, ConfigurationException{
		
		Dictionary<String, String> dictionary = new Hashtable<String, String>();
		dictionary.put(GossCoreContants.PROP_OPENWIRE_URI, "tcp://0.0.0.0:61616");
		dictionary.put(GossCoreContants.PROP_STOMP_URI, "tcp://0.0.0.0:61614");
		
		clientServiceFactory.updated(dictionary);
		
		Dictionary<String, Object> properties = clientServiceFactory.getProperties();

		Enumeration<String> keyEnum = properties.keys();
	     while(keyEnum.hasMoreElements()){
	         String key = keyEnum.nextElement();
	         assertEquals(properties.get(key), dictionary.get(key));
	     }
		
	}
	
	@Test
	public void checkProperties_whenUpdatedcalledWithSslEnabledTrue() throws FileNotFoundException, IOException, ConfigurationException{
		
		Dictionary<String, String> dictionary = new Hashtable<String, String>();
		dictionary.put(GossCoreContants.PROP_SSL_ENABLED, "true");
		dictionary.put(GossCoreContants.PROP_SSL_URI, "ssl://0.0.0.0:61443");
		dictionary.put(GossCoreContants.PROP_SSL_CLIENT_TRUSTSTORE,"mybroker.ks");
		dictionary.put(GossCoreContants.PROP_SSL_CLIENT_TRUSTSTORE_PASSWORD,"GossServerTemp");
		
		clientServiceFactory.updated(dictionary);
		
		Dictionary<String, Object> properties = clientServiceFactory.getProperties();

		Enumeration<String> keyEnum = dictionary.keys();
	     while(keyEnum.hasMoreElements()){
	    	 String key = keyEnum.nextElement();
	    	 System.out.println(key);
	    	 assertEquals(properties.get(key), dictionary.get(key));
	     }
		
	}

}
