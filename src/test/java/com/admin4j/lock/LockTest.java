package com.admin4j.lock;

import com.admin4j.framework.lock.util.DistributedLockUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author andanyang
 * @since 2023/4/18 14:13
 */
@SpringBootTest
public class LockTest {

    @Test
    public void testLock() throws Exception {

        DistributedLockUtil.lock("test", () -> {
            System.out.println("i get the lock " + true);
        });
    }
}
