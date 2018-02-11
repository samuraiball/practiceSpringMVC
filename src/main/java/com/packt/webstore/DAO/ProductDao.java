package com.packt.webstore.DAO;


import com.packt.webstore.config.DomaConfig;
import com.packt.webstore.domain.Product;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import java.util.List;

@Dao(config = DomaConfig.class)
public interface ProductDao {

    @Select(ensureResult = true)
    List<Product> getAllProduct();
}
