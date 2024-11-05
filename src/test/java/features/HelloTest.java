package features;

import org.junit.jupiter.api.Test;
import org.noear.esearchx.EsContext;
import org.noear.esearchx.EsGlobal;
import org.noear.solon.annotation.Inject;
import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;
import top.primsnet.sync.DataPulseApp;
import top.primsnet.sync.datapush.from.listener.master.to.OrderTO;

import java.io.IOException;
import java.util.Date;

@SolonTest(DataPulseApp.class)
public class HelloTest extends HttpTester {
    @Test
    public void hello() throws IOException {
        assert path("/hello?name=world").get().contains("world");
        assert path("/hello?name=solon").get().contains("solon");
    }

    @Inject("${test.esx}")
    EsContext context;

    @Test
    public void testEsCreateIndex() throws IOException {
        //执行前打印dsl
        EsGlobal.onCommandBefore(cmd -> System.out.println("dsl:::" + cmd.getDsl()));

//        String dsl = Utils.getResourceAsString("esindex/order.json", "utf-8");
//        context.indiceCreate("order_2024",dsl);
//        assert context.indiceExist("order_2024") == true;
    }

    @Test
    public void testAddData() throws IOException {
        OrderTO userEsTO = new OrderTO();
        userEsTO.setId(111L);
        userEsTO.setAge(28L);
        userEsTO.setUserName("张三");
        userEsTO.setMobile("12345678901");
        userEsTO.setAddress("北京市朝阳区");
        userEsTO.setCity("北京市");
        userEsTO.setProvince("北京市");
        userEsTO.setCounty("朝阳区");
        userEsTO.setOrderNum("12345678901");
        userEsTO.setOrderTime(new Date());
        userEsTO.setOrderStatus("1");
        userEsTO.setOrderType("1");
        userEsTO.setOrderSource("1");
        userEsTO.setOrderFlag(1);
        userEsTO.setRechargeMoney(100.0);
        userEsTO.setRechargeTag(1);
        userEsTO.setSellMobile("12345678901");
        userEsTO.setMerchantId(1L);
        userEsTO.setMerchantUserId(1L);
        userEsTO.setMerchantEigenValId(1L);
        userEsTO.setMerchantEigenValCode("12345678901");
        userEsTO.setCommodityId(1L);
        userEsTO.setCommodityName("测试商品");
        userEsTO.setParentCommodityId(1L);
        userEsTO.setParentCommodityName("测试商品");
        userEsTO.setOutOrderNum("12345678901");
        userEsTO.setOrderSource("1");
        userEsTO.setOrderStatus("1");
        userEsTO.setOrderType("1");
        userEsTO.setOrderFlag(1);
        userEsTO.setRechargeMoney(100.0);
        userEsTO.setRechargeTag(1);
        userEsTO.setActiveTime(new Date());
        String rst = context.indice("order_2024").upsert(userEsTO.getId()+"", userEsTO);
        System.out.println(rst);
    }
}