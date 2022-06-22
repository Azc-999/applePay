package dao;

import com.CMe388.dao.OrdersMapper;
import com.CMe388.pojo.Orders;
import com.CMe388.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-dao.xml"})
public class OrdersTest {
    private OrdersMapper orderMapper;

    @Autowired
    public void setOrderMapper(OrdersMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Test
    public void OrderAndProductResult() {
        List<Orders> orders = orderMapper.findOrderWithProductByUserId(1);
        for (Orders order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void addOrder() {
        Orders orders = new Orders();
        orders.setUserId(2);
        System.out.println(orders);
        System.out.println("=============================");
        Integer result = orderMapper.addOrder(orders);
        System.out.println(result);
        System.out.println("=============================");
        System.out.println(orders);
    }

    @Test
    public void addOrderItem() {
        Orders orders = new Orders();
        Product p1 = new Product();
        p1.setId(10);
        Product p2 = new Product();
        p2.setId(9);
        List<Product> productList = new ArrayList<Product>();
        productList.add(p1);
        productList.add(p2);
        orders.setProducts(productList);
        orders.setId(8);
        System.out.println(orders);
        System.out.println("=============================");
        Integer result = orderMapper.addOrderItem(orders);
        System.out.println(result);
        System.out.println("=============================");
        System.out.println(orders);
    }
}
