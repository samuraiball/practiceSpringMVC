package com.packt.webstore.config;

import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;
import org.seasar.doma.jdbc.tx.LocalTransaction;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;

import static org.seasar.doma.jdbc.ConfigSupport.defaultJdbcLogger;

@SingletonConfig
public class DomaConfig implements Config {

    private static DomaConfig INSTANCE = new DomaConfig();
    private final TransactionManager transactionManager;
    private final LocalTransactionDataSource dataSource;
    private final Dialect dialect;

     private DomaConfig() {
        dialect = new MysqlDialect();
        dataSource = new LocalTransactionDataSource("jdbc:mysql://localhost:3306/trial","root","");
         transactionManager = new LocalTransactionManager(dataSource.getLocalTransaction(getJdbcLogger()));
     }

    @Override
    public LocalTransactionDataSource getDataSource() {
        return dataSource;
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }

    public static DomaConfig singleton(){
         return INSTANCE;
    }

    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    public LocalTransaction getLocalTransaction() {
        return dataSource.getLocalTransaction(defaultJdbcLogger);
    }

}
