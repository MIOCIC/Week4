package hr.dream.factory.learning;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import hr.dream.factory.learning.models.Rune;
import hr.dream.factory.learning.models.Runeword;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MySqlDao {
    private Sql2o dataSource;

    public MySqlDao() {
        this.dataSource = createConnection();
    }

    private Sql2o createConnection() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/learning");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("secret");
        hikariConfig.setMaxLifetime(TimeUnit.MINUTES.toMillis(5L));
        hikariConfig.setConnectionTestQuery("/* ping */ SELECT 1");
        hikariConfig.setIdleTimeout(TimeUnit.SECONDS.toMillis(30L));

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return new Sql2o(dataSource);
    }
    void insert(String queryString){
        try (Connection open = dataSource.open();
             Query query = open.createQuery(queryString)) {
            query.executeUpdate();
        }
    }

    public List<Rune> select(String queryString){
        try (Connection open = dataSource.open();
             Query query = open.createQuery(queryString)) {
            query.setAutoDeriveColumnNames(true);
            return query.executeAndFetch(Rune.class);
        }
    }

    public List<Runeword> select2(String queryString){
        try (Connection open = dataSource.open();
             Query query = open.createQuery(queryString)) {
            query.setAutoDeriveColumnNames(true);
            return query.executeAndFetch(Runeword.class);
        }
    }

}
