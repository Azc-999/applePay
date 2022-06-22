package service;

import com.CMe388.pojo.Orders;
import com.CMe388.pojo.Product;
import com.CMe388.service.OrdersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class OrdersServiceTest {
    private OrdersService ordersService;

    @Autowired
    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @Test
    public void findOrderWithProductByUserId() {
        List<Orders> ordersList = ordersService.findOrderWithProductByUserId(2);
        for (Orders orders : ordersList) {
            System.out.println(orders);
        }
    }

    @Test
    public void addOrder() {
        Product p1 = new Product();
        p1.setId(7);
        Product p2 = new Product();
        p2.setId(5);
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);
        Orders orders = new Orders();
        orders.setUserId(2);
        orders.setProducts(productList);
        System.out.println(orders+"orders Begging");
        Integer result = ordersService.addOrder(orders);
        System.out.println(result);
    }
}
