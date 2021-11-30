package io.swagger.api;

import io.swagger.Swagger2SpringBoot;
import io.swagger.model.Player;
import io.swagger.model.User;
import io.swagger.service.MyUserDetailsService;
import io.swagger.service.playerService;
import io.swagger.service.teamService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
//@WebMvcTest(value = PlayersApiController.class, secure = false)
@SpringBootTest(classes = Swagger2SpringBoot.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class PlayersApiControllerTest {
    @Autowired
    private playerService playerService;

    private TestRestTemplate restTemplate = new TestRestTemplate("wanglinw","pass");
    @LocalServerPort
    private int port;
    @Test
    public void testAllEmployees()
    {

        String uri =  "http://localhost:" + port + "/players";
        System.out.println(uri);

        Arrays.stream(this.restTemplate
                        .getForObject(uri, Player[].class)).map(player -> player.toString()).forEach(System.out::println);
        assertEquals(Arrays.stream(this.restTemplate
                .getForObject(uri, Player[].class)).count(),3);
    }
    @Test
     void findAllTest1()  {
        List<Player> players = new ArrayList<Player>();
        players = playerService.findAll();
        System.out.println(players);
        assertTrue(players.size() >= 0);
    }
    @Test
    void findAllTest2(){

    }
}
