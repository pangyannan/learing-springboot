package cn.atomc.learing.springboot.web.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author Eric
 * @create 2019-06-02
 */
public class UserControllerTest {
    private MockMvc mockMvc;
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }
    @Test
    public void getUser() throws Exception {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.get("/user/"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result : "+responseString);
    }
    @Test
    public void listUser() throws Exception {
        String responseString = mockMvc.perform(MockMvcRequestBuilders.get("/user/list"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result : "+responseString);
    }

    @Test
    public void getUserByName() throws Exception {
        String responseString = mockMvc
                .perform(MockMvcRequestBuilders.get("/user/xiaoMing"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result : "+responseString);
    }

    @Test
    public void saveUserValid() throws Exception {
        String responseString = mockMvc
                .perform(MockMvcRequestBuilders.post("/user/valid")
                        .param("name","")
                        .param("age","888")
                        .param("password","test"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result : "+responseString);
    }
}