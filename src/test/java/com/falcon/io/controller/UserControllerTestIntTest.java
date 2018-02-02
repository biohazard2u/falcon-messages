package com.falcon.io.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.falcon.io.Application;
import com.falcon.io.entity.FalconChatUserEntity;
import com.falcon.io.repository.redis.FalconChatUserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yml")
public class UserControllerTestIntTest {

	@Autowired
    private MockMvc mvc;
 
    @Autowired
    private FalconChatUserRepository repository;
    
    @Ignore // DB containers need to be up and running!
	@Test
	public void findFalconChatUsers___() throws Exception{
		
		FalconChatUserEntity falconChatUserEntity = new FalconChatUserEntity();
    	falconChatUserEntity.setNickName("Nickname");
        //repository.saveAndFlush(falconChatUserEntity);
        repository.save(falconChatUserEntity);
        
		mvc.perform(get("/user")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      //.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			      .andExpect(jsonPath("$[0].name", is("bob")));
	}
}
