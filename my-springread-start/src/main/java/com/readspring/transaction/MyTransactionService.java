package com.readspring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yanggy
 */
@Service
public class MyTransactionService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void testSql() {
        jdbcTemplate.execute("insert into `user` values (null, 'user1','123456',1,1,1,1)");
        jdbcTemplate.execute("insert into `user` values (null, 'user2','123456',1,1,1,1)");
        jdbcTemplate.execute("insert into `user` values (null, 'user3','123456',1,1,1,1)");
        jdbcTemplate.execute("insert into `user` values (null, 'user4','123456',1,1,1,1)");
    }

    /**
     * Propagation.REQUIRES_NEW: 开启新的事务（会创建新的数据库连接）
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void aNew() {
        jdbcTemplate.execute("insert into `user` values (null, 'aNew','123456',1,1,1,1)");
    }
}
