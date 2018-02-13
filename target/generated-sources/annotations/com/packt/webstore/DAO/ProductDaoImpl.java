package com.packt.webstore.DAO;

/** */
@javax.annotation.Generated(value = { "Doma", "2.18.0" }, date = "2018-02-11T14:51:38.753+0900")
public class ProductDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements com.packt.webstore.DAO.ProductDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.18.0");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(com.packt.webstore.DAO.ProductDao.class, "getAllProduct");

    /** */
    public ProductDaoImpl() {
        super(com.packt.webstore.config.DomaConfig.singleton());
    }

    /**
     * @param connection the connection
     */
    public ProductDaoImpl(java.sql.Connection connection) {
        super(com.packt.webstore.config.DomaConfig.singleton(), connection);
    }

    /**
     * @param dataSource the dataSource
     */
    public ProductDaoImpl(javax.sql.DataSource dataSource) {
        super(com.packt.webstore.config.DomaConfig.singleton(), dataSource);
    }

    /**
     * @param config the configuration
     */
    protected ProductDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    /**
     * @param config the configuration
     * @param connection the connection
     */
    protected ProductDaoImpl(org.seasar.doma.jdbc.Config config, java.sql.Connection connection) {
        super(config, connection);
    }

    /**
     * @param config the configuration
     * @param dataSource the dataSource
     */
    protected ProductDaoImpl(org.seasar.doma.jdbc.Config config, javax.sql.DataSource dataSource) {
        super(config, dataSource);
    }

    @Override
    public java.util.List<com.packt.webstore.domain.Product> getAllProduct() {
        entering("com.packt.webstore.DAO.ProductDaoImpl", "getAllProduct");
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method0);
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/com/packt/webstore/DAO/ProductDao/getAllProduct.sql");
            __query.setEntityType(com.packt.webstore.domain._Product.getSingletonInternal());
            __query.setCallerClassName("com.packt.webstore.DAO.ProductDaoImpl");
            __query.setCallerMethodName("getAllProduct");
            __query.setResultEnsured(true);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<com.packt.webstore.domain.Product>> __command = getCommandImplementors().createSelectCommand(__method0, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<com.packt.webstore.domain.Product>(com.packt.webstore.domain._Product.getSingletonInternal()));
            java.util.List<com.packt.webstore.domain.Product> __result = __command.execute();
            __query.complete();
            exiting("com.packt.webstore.DAO.ProductDaoImpl", "getAllProduct", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("com.packt.webstore.DAO.ProductDaoImpl", "getAllProduct", __e);
            throw __e;
        }
    }

}
