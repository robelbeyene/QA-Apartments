/***
 * 	OWEN IS WORKING ON THIS
 */


//package com.qa.apartment.integration;
//
//import static org.junit.Assert.assertEquals;
//
//import java.io.IOException;
//
//import javax.ws.rs.core.Response;
//
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import com.qa.apartment.persistance.Person;
//import com.qa.apartment.util.JSONUtil;
//
//@RunWith(MockitoJUnitRunner.class)
//public class PersonEndpointTest {
//	
//	private Response res;
//	
//	@InjectMocks
//	private static PersonEndpoint endPoint;
//	public static InMemoryRestServer server;
//	
//	@Mock
//	private JSONUtil util;
//	
//	@BeforeClass
//	public static void setUp() throws Exception {
//		server = InMemoryRestServer.create(endPoint);
//	}
//	
//	@Before
//	public void buildUp() {
//		
//	}
//	
//	@Test
//	public void testGetAllPersonsWithoutMock() {
//		res = server.newRequest("/person/json").request().buildGet().invoke();
//		System.out.println("hi");
//		assertEquals(Response.Status.OK.getStatusCode(), res.getStatus());
//	}
//	
//	@Test
//	public void testGetAllPersonsWithMock() {
//		Mockito.when(endPoint.getAllPersons()).thenReturn("People here");
//		
//		res = server.newRequest("/person/json").request().buildGet().invoke();
//		assertEquals(Response.Status.OK.getStatusCode(), res.getStatus());
//		
//	}
//	
//	@AfterClass
//	public static void destroy() {
//		server.close();
//	}
//}
