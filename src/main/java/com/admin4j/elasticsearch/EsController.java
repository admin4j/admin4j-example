package com.admin4j.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.admin4j.framework.web.pojo.R;
import com.admin4j.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author andanyang
 * @since 2023/5/23 17:25
 */
@RestController
@RequestMapping("ES")
public class EsController {

    @Autowired
    ElasticsearchClient elasticsearchClient;

    @GetMapping
    public R es() throws IOException {


        SearchResponse<User> search = elasticsearchClient.search(s -> s
                        .index("products")
                        .query(q -> q
                                .term(t -> t
                                        .field("name")
                                        .value(v -> v.stringValue("bicycle"))
                                )),
                User.class);

        for (Hit<User> hit : search.hits().hits()) {
            System.out.println("hit = " + hit);
        }

        return R.ok(search.hits().hits());
    }
//    @GetMapping("create")
//    public R create() throws IOException {
//
//        CreateRequest
//        elasticsearchClient.create()
//        SearchResponse<User> search = elasticsearchClient.search(s -> s
//                        .index("products")
//                        .query(q -> q
//                                .term(t -> t
//                                        .field("name")
//                                        .value(v -> v.stringValue("bicycle"))
//                                )),
//                User.class);
//
//        for (Hit<User> hit : search.hits().hits()) {
//            System.out.println("hit = " + hit);
//        }
//
//        return R.ok(search.hits().hits());
//    }
}
