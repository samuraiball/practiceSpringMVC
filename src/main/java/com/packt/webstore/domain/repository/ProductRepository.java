package com.packt.webstore.domain.repository;

import java.util.List;
import java.util.Map;

import com.packt.webstore.domain.Product;

/*
* 商品データベースへのアクセス用リポジトリ
*/
public interface ProductRepository {

    /*
    * 全商品の検索
     */
    List <Product> getAllProducts();

    /*
    *　商品数が400以下の場合、商品数を+1000に更新する。
    */
    void updateStock(String productId, long noOfUnits);

    /*
    *　商品のカテゴリー検索
     */
    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    void addProduct(Product product);

}