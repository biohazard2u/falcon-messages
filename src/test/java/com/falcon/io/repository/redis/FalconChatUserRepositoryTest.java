package com.falcon.io.repository.redis;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.falcon.io.entity.FalconChatUserEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test") 
public class FalconChatUserRepositoryTest {

	private static final Integer USER1_ID = 1;
	private static final String EMAIL1 = "test1@email";
	private static final String NICKNAME1 = "nicknameTest1";
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private FalconChatUserRepository falconChatUserRepository;
	
	@Ignore
	@Test
	public void findByEmail_returnsUserWithThatEmail() {
		FalconChatUserEntity expected = new FalconChatUserEntity();
		expected.setUserId(USER1_ID);
		expected.setEmail(EMAIL1);
		expected.setNickName(NICKNAME1);
		
		entityManager.persist(expected);
		entityManager.flush();
		
		FalconChatUserEntity actual = falconChatUserRepository.findByEmail(EMAIL1);
		
		assertEquals(expected, actual);		
	}
}
