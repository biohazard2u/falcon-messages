package com.falcon.io.repository.postgre;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.falcon.io.entity.FalconChatMessageEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test") 
public class FalconChatMessageRepositoryTest {

	private static final Integer USER1_ID = 1;
	private static final String MESSAGE1 = "test message 1";
	private static final String MESSAGE2 = "test message 2";

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private FalconChatMessageRepository falconChatMessageRepository;
	
	@Test
	public void findByUserId_returnsMessagesForThatUser() {
		List<FalconChatMessageEntity> expected = new ArrayList<>();
		FalconChatMessageEntity message1 = new FalconChatMessageEntity(USER1_ID, MESSAGE1);
		FalconChatMessageEntity message2 = new FalconChatMessageEntity(USER1_ID, MESSAGE2);
		expected.add(message1);
		expected.add(message2);
		
		entityManager.persist(expected.get(0));
		entityManager.persist(expected.get(1));
		entityManager.flush();
		
		List<FalconChatMessageEntity> actual = falconChatMessageRepository.findByUserId(message1.getUserId());
		
		assertEquals(message1, actual.get(0));		
		assertThat(actual, is(expected));
	}
}
