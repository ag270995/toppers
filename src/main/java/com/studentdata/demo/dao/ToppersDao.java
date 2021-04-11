package com.studentdata.demo.dao;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.studentdata.demo.model.Topper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.datastax.driver.mapping.Result;
import java.util.List;

@Component
public class ToppersDao {
    @Autowired
    Session session;
    @Autowired
    MappingManager mappingManager;

    public List<Topper> getToppers(String state, String standard, String subject, int pageSize) {
        Mapper<Topper> mapper = mappingManager.mapper(Topper.class);
        ResultSet resultSet = session.execute("select student_name, id, school, marks from assignment.toppers where state='" + state + "' and " +
                " standard='" + standard + "' and subject='" + subject + "' LIMIT " + pageSize);
        Result<Topper> results = mapper.map(resultSet);
        return results.all();
    }

    public void saveTopper(Topper topper) {
        Mapper<Topper> mapper = mappingManager.mapper(Topper.class);
        mapper.save(topper);
    }

}
