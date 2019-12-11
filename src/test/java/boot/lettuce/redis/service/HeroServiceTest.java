package boot.lettuce.redis.service;

import boot.lettuce.redis.config.RedisConfigurationTest;
import boot.lettuce.redis.domain.Hero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisConfigurationTest.class)
public class HeroServiceTest {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void ValueOperationsTest() {
        //given
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        Hero input = Hero.builder()
                .id("github.com/hong-il")
                .name("github.com/hong-il")
                .build();

        valueOperations.set("key", input);

        //when
        Hero output = (Hero) valueOperations.get("key");

        //then
        assertThat(input.getId(), is(output.getId()));
        assertThat(input.getName(), is(output.getName()));
    }
}
