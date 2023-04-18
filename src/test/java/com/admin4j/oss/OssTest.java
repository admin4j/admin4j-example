package com.admin4j.oss;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author andanyang
 * @since 2023/4/13 15:41
 */
@SpringBootTest
public class OssTest {

    @Autowired
    OssTemplate ossTemplate;

    @Test
    /**
     * 创建 Bucket
     */
    public void testCreateBucket() {

        ossTemplate.createBucket("oss-template");
    }

    @Test
    /**
     * 获取所有Bucket
     */
    public void testGetAllBuckets() {

        List<Bucket> allBuckets = ossTemplate.getAllBuckets();
        System.out.println("allBuckets = " + allBuckets);
    }

    @Test
    /**
     * 上传文件
     */
    public void testPut() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\andanyang\\Downloads\\012408-167976504839ee.jpg");
        PutObjectResult putObjectResult = ossTemplate.putObject("oss-template", "test/Test.jpg", fileInputStream);
        System.out.println("putObjectResult = " + putObjectResult);
    }

    @Test
    /**
     * 获取文件
     */
    public void testGet() throws IOException {

        String objectURL = ossTemplate.getObjectURL("oss-template", "test/Test.jpg", 1, TimeUnit.DAYS);
        System.out.println("objectURL = " + objectURL);
    }


}
