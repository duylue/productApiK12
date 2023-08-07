package com.productk12Api.repository;

import com.productk12Api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query(value = "select sum.pid, sum.pname, SUM(sum.quantity) as qty\n" +
            "from (select o.*, o2.pid, o2.quantity, p.pname\n" +
            "      from orders o,\n" +
            "           orderdetails o2,\n" +
            "           product p\n" +
            "      where o.oid = o2.oid\n" +
            "        and p.id = o2.pid) as sum\n" +
            "group by pid\n" +
            "order by pid", nativeQuery = true)
    List<Map<String, Object>> getListQtyPurchasedMap();

    @Query(value = "with a as (select avg(price) as avg ,\n" +
            "       cid from product group by cid)\n" +
            "select a.*, b.cname from a, category b\n" +
            "where a.cid = b.cid and b.cid =:cid", nativeQuery = true)
    List<Map<String, Object>> getAvgPrice(@Param("cid") int cid);
}
