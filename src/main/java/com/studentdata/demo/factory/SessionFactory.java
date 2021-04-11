package com.studentdata.demo.factory;
import com.datastax.driver.core.*;
import com.datastax.driver.core.policies.DCAwareRoundRobinPolicy;
import com.datastax.driver.core.policies.DefaultRetryPolicy;
import com.datastax.driver.core.policies.TokenAwarePolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@Configuration
@EnableReactiveCassandraRepositories
public class SessionFactory {
    @Bean
    public Session getSession() {
        return Cluster.builder().withoutMetrics().withQueryOptions(new QueryOptions().setConsistencyLevel(ConsistencyLevel.LOCAL_QUORUM))
                .withLoadBalancingPolicy(new TokenAwarePolicy(DCAwareRoundRobinPolicy.builder().build()))
                .withCredentials("cassandra", "cassandra")
                .withoutJMXReporting()
                .withPort(9042)
                .withRetryPolicy(DefaultRetryPolicy.INSTANCE).addContactPoint("127.0.0.1").build().connect("assignment");
    }
}
