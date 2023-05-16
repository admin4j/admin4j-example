package com.admin4j.limiter;

import com.admin4j.limiter.core.constant.LimiterType;
import com.admin4j.limiter.core.util.RateLimiterUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author andanyang
 * @since 2023/5/12 13:11
 */
@SpringBootTest
@AutoConfigureMockMvc
public class RateLimiterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {

    }

    void testRateLimiter(String limitStr) throws Exception {
        // 发送 20 次请求
        for (int i = 0; i < 20; i++) {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/limiter/" + limitStr)
                            .header("X-RateLimit-Token", "test"))
                    .andReturn();
            int status = result.getResponse().getStatus();
            //Thread.sleep(500);
            //if (i < 10) {
            //    // 前 10 次请求应该返回 200
            //    ResultMatcher resultMatcher = MockMvcResultMatchers.status().isOk();
            //    System.out.println("resultMatcher = " + resultMatcher);
            //} else {
            //    // 后 10 次请求应该返回 429（Too Many Requests）
            //    ResultMatcher resultMatcher = MockMvcResultMatchers.status().is(429);
            //    System.out.println("resultMatcher = " + resultMatcher);
            //}
            System.out.println("time = " + System.currentTimeMillis() / 1000 + " ; status = " + status + "; success:" + (status == 200) + " ; i=" + i);
            //if (i > 10) {
            //    Thread.sleep(2000);
            //}
        }
    }

    @Test
    void test_SLIDING_WINDOW() throws Exception {
        testRateLimiter("SLIDING_WINDOW");
    }

    @Test
    void test_FIX_WINDOW() throws Exception {
        testRateLimiter("FIX_WINDOW");
    }

    @Test
    void test_SLIDING_LOG() throws Exception {
        testRateLimiter("SLIDING_LOG");
    }

    @Test
    void test_LEAKY_BUCKET() throws Exception {
        testRateLimiter("LEAKY_BUCKET");
    }

    @Test
    void test_TOKEN_BUCKET() throws Exception {
        testRateLimiter("TOKEN_BUCKET");
    }

    @Test
    void test_util() {

        for (int i = 0; i < 20; i++) {
            boolean token = RateLimiterUtil.rateLimiter(LimiterType.TOKEN_BUCKET, "token", 1, 2);
            System.out.println("time = " + System.currentTimeMillis() + " ;token = " + token);
        }

    }
}
