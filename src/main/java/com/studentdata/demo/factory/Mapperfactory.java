package com.studentdata.demo.factory;


import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Mapperfactory {
@Autowired
Session session;
    @Bean
    public MappingManager getMappingManager() {
        return new MappingManager(session);
    }

}
