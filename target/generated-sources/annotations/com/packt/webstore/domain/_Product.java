package com.packt.webstore.domain;

/** */
@javax.annotation.Generated(value = { "Doma", "2.18.0" }, date = "2018-02-11T14:51:38.663+0900")
public final class _Product extends org.seasar.doma.jdbc.entity.AbstractEntityType<com.packt.webstore.domain.Product> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.18.0");
    }

    private static final _Product __singleton = new _Product();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = org.seasar.doma.jdbc.entity.NamingType.SNAKE_UPPER_CASE;

    /** the productId */
    public final org.seasar.doma.jdbc.entity.AssignedIdPropertyType<java.lang.Object, com.packt.webstore.domain.Product, java.lang.String, Object> $productId = new org.seasar.doma.jdbc.entity.AssignedIdPropertyType<>(com.packt.webstore.domain.Product.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "productId", "ID", __namingType, false);

    /** the name */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.packt.webstore.domain.Product, java.lang.String, Object> $name = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.packt.webstore.domain.Product.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "name", "", __namingType, true, true, false);

    /** the unitPrice */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.packt.webstore.domain.Product, java.math.BigDecimal, Object> $unitPrice = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.packt.webstore.domain.Product.class, java.math.BigDecimal.class, java.math.BigDecimal.class, () -> new org.seasar.doma.wrapper.BigDecimalWrapper(), null, null, "unitPrice", "", __namingType, true, true, false);

    /** the description */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.packt.webstore.domain.Product, java.lang.String, Object> $description = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.packt.webstore.domain.Product.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "description", "", __namingType, true, true, false);

    /** the manufacturer */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.packt.webstore.domain.Product, java.lang.String, Object> $manufacturer = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.packt.webstore.domain.Product.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "manufacturer", "", __namingType, true, true, false);

    /** the category */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.packt.webstore.domain.Product, java.lang.String, Object> $category = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.packt.webstore.domain.Product.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "category", "", __namingType, true, true, false);

    /** the unitsInStock */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.packt.webstore.domain.Product, java.lang.Long, Object> $unitsInStock = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.packt.webstore.domain.Product.class, java.lang.Long.class, java.lang.Long.class, () -> new org.seasar.doma.wrapper.LongWrapper(), null, null, "unitsInStock", "", __namingType, true, true, false);

    /** the unitsInOrder */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.packt.webstore.domain.Product, java.lang.Long, Object> $unitsInOrder = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.packt.webstore.domain.Product.class, java.lang.Long.class, java.lang.Long.class, () -> new org.seasar.doma.wrapper.LongWrapper(), null, null, "unitsInOrder", "", __namingType, true, true, false);

    /** the discontinued */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.packt.webstore.domain.Product, java.lang.Boolean, Object> $discontinued = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.packt.webstore.domain.Product.class, java.lang.Boolean.class, java.lang.Boolean.class, () -> new org.seasar.doma.wrapper.BooleanWrapper(), null, null, "discontinued", "", __namingType, true, true, false);

    /** the condition */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, com.packt.webstore.domain.Product, java.lang.String, Object> $condition = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(com.packt.webstore.domain.Product.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "condition", "CONDITION_OF", __namingType, true, true, false);

    private final java.util.function.Supplier<org.seasar.doma.jdbc.entity.NullEntityListener<com.packt.webstore.domain.Product>> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.packt.webstore.domain.Product, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.packt.webstore.domain.Product, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.packt.webstore.domain.Product, ?>> __entityPropertyTypeMap;

    private _Product() {
        __listenerSupplier = () -> ListenerHolder.listener;
        __immutable = false;
        __name = "Product";
        __catalogName = "";
        __schemaName = "";
        __tableName = "";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.packt.webstore.domain.Product, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.packt.webstore.domain.Product, ?>> __list = new java.util.ArrayList<>(10);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<com.packt.webstore.domain.Product, ?>> __map = new java.util.HashMap<>(10);
        __idList.add($productId);
        __list.add($productId);
        __map.put("productId", $productId);
        __list.add($name);
        __map.put("name", $name);
        __list.add($unitPrice);
        __map.put("unitPrice", $unitPrice);
        __list.add($description);
        __map.put("description", $description);
        __list.add($manufacturer);
        __map.put("manufacturer", $manufacturer);
        __list.add($category);
        __map.put("category", $category);
        __list.add($unitsInStock);
        __map.put("unitsInStock", $unitsInStock);
        __list.add($unitsInOrder);
        __map.put("unitsInOrder", $unitsInOrder);
        __list.add($discontinued);
        __map.put("discontinued", $discontinued);
        __list.add($condition);
        __map.put("condition", $condition);
        __idPropertyTypes = java.util.Collections.unmodifiableList(__idList);
        __entityPropertyTypes = java.util.Collections.unmodifiableList(__list);
        __entityPropertyTypeMap = java.util.Collections.unmodifiableMap(__map);
    }

    @Override
    public org.seasar.doma.jdbc.entity.NamingType getNamingType() {
        return __namingType;
    }

    @Override
    public boolean isImmutable() {
        return __immutable;
    }

    @Override
    public String getName() {
        return __name;
    }

    @Override
    public String getCatalogName() {
        return __catalogName;
    }

    @Override
    public String getSchemaName() {
        return __schemaName;
    }

    @Override
    public String getTableName() {
        return getTableName(org.seasar.doma.jdbc.Naming.DEFAULT::apply);
    }

    @Override
    public String getTableName(java.util.function.BiFunction<org.seasar.doma.jdbc.entity.NamingType, String, String> namingFunction) {
        if (__tableName.isEmpty()) {
            return namingFunction.apply(__namingType, __name);
        }
        return __tableName;
    }

    @Override
    public boolean isQuoteRequired() {
        return __isQuoteRequired;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preInsert(com.packt.webstore.domain.Product entity, org.seasar.doma.jdbc.entity.PreInsertContext<com.packt.webstore.domain.Product> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(com.packt.webstore.domain.Product entity, org.seasar.doma.jdbc.entity.PreUpdateContext<com.packt.webstore.domain.Product> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(com.packt.webstore.domain.Product entity, org.seasar.doma.jdbc.entity.PreDeleteContext<com.packt.webstore.domain.Product> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(com.packt.webstore.domain.Product entity, org.seasar.doma.jdbc.entity.PostInsertContext<com.packt.webstore.domain.Product> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(com.packt.webstore.domain.Product entity, org.seasar.doma.jdbc.entity.PostUpdateContext<com.packt.webstore.domain.Product> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(com.packt.webstore.domain.Product entity, org.seasar.doma.jdbc.entity.PostDeleteContext<com.packt.webstore.domain.Product> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.packt.webstore.domain.Product, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<com.packt.webstore.domain.Product, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<com.packt.webstore.domain.Product, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, com.packt.webstore.domain.Product, ?, ?> getGeneratedIdPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, com.packt.webstore.domain.Product, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public org.seasar.doma.jdbc.entity.TenantIdPropertyType<java.lang.Object, com.packt.webstore.domain.Product, ?, ?> getTenantIdPropertyType() {
        return null;
    }

    @Override
    public com.packt.webstore.domain.Product newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<com.packt.webstore.domain.Product, ?>> __args) {
        com.packt.webstore.domain.Product entity = new com.packt.webstore.domain.Product();
        if (__args.get("productId") != null) __args.get("productId").save(entity);
        if (__args.get("name") != null) __args.get("name").save(entity);
        if (__args.get("unitPrice") != null) __args.get("unitPrice").save(entity);
        if (__args.get("description") != null) __args.get("description").save(entity);
        if (__args.get("manufacturer") != null) __args.get("manufacturer").save(entity);
        if (__args.get("category") != null) __args.get("category").save(entity);
        if (__args.get("unitsInStock") != null) __args.get("unitsInStock").save(entity);
        if (__args.get("unitsInOrder") != null) __args.get("unitsInOrder").save(entity);
        if (__args.get("discontinued") != null) __args.get("discontinued").save(entity);
        if (__args.get("condition") != null) __args.get("condition").save(entity);
        return entity;
    }

    @Override
    public Class<com.packt.webstore.domain.Product> getEntityClass() {
        return com.packt.webstore.domain.Product.class;
    }

    @Override
    public com.packt.webstore.domain.Product getOriginalStates(com.packt.webstore.domain.Product __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(com.packt.webstore.domain.Product __entity) {
    }

    /**
     * @return the singleton
     */
    public static _Product getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _Product newInstance() {
        return new _Product();
    }

    private static class ListenerHolder {
        private static org.seasar.doma.jdbc.entity.NullEntityListener<com.packt.webstore.domain.Product> listener = new org.seasar.doma.jdbc.entity.NullEntityListener<>();
    }

}
