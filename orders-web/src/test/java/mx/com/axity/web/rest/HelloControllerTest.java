package mx.com.axity.web.rest;

import mx.com.axity.commons.to.OrdersTO;
import mx.com.axity.web.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class HelloControllerTest extends BaseTest {

    @Test
    public void exampleTest() {

        //this.entityManager.persist(new UserDO("Javier", "Rodriguez", 1));

        List<OrdersTO> users = this.ordersFacade.getAllOrders();

        Assert.assertNotNull(users);
        Assert.assertEquals(2, users.size());
    }
}
