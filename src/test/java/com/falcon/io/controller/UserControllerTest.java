package com.falcon.io.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.falcon.io.entity.FalconChatUserEntity;
import com.falcon.io.service.FalconChatUserServiceable;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private FalconChatUserServiceable service;
    
    @Test
    public void findFalconChatUsers_whenGetEmployees_thenReturnJsonArray() throws Exception {
         
    	FalconChatUserEntity falconChatUserEntity = new FalconChatUserEntity();
    	falconChatUserEntity.setNickName("Nickname");
        List<FalconChatUserEntity> falconChatUserEntitiesList = Arrays.asList(falconChatUserEntity);
     
        given(service.findFalconChatUsers()).willReturn(falconChatUserEntitiesList);
     
        mvc.perform(get("/user")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$", hasSize(1)))
          .andExpect(jsonPath("$[0].usersNickname", is(falconChatUserEntity.getNickName())));
    }
}
