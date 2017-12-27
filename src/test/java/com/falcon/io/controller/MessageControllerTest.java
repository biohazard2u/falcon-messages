package com.falcon.io.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.falcon.io.service.FalconMessageServiceable;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = TestContext.class)
@WebAppConfiguration
public class MessageControllerTest {

	private MockMvc mockMvc;

	@Mock
	private FalconMessageServiceable messageService;

	@InjectMocks
	private MessageController sut;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
//		doReturn(null).when(messageService).findFalconMessageByOwner("m");
//		doReturn(null).when(messageService).saveFalconMessage((any()));
		mockMvc = MockMvcBuilders.standaloneSetup(sut).build();
	}

	@Test
	public void getMessageByOwner_hasNoExceptions() throws Exception {
		mockMvc.perform(get("http://localhost:8081/falcon-message-service/message/messagesByOwner?owner=m"));
	}
	
	@Test
	public void saveMessage_hasOkResponse() throws Exception {
		mockMvc.perform(post("http://localhost:8081/falcon-message-service/message"));		
	}
}