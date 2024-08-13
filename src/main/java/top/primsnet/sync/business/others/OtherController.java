package top.primsnet.sync.business.others;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.MethodType;

/**
 * Author: joshua
 * Description: TODO
 * DateTime: 2024/7/29 下午4:56
 **/
@Controller
public class OtherController {

    @Mapping(value = "/login",method = MethodType.POST)
    public JSONObject login(){
        JSONObject jo = new JSONObject();
        JSONObject data = new JSONObject();
        jo.put("code", 0);
        jo.put("msg", "登录成功");
        data.put("token","System_Token");
        jo.put("data", data);
        return jo;
    }

    @Mapping("/user")
    public JSONObject user(){
        JSONObject jo = new JSONObject();
        JSONObject data = new JSONObject();
        JSONArray roles = new JSONArray();
        JSONArray buttons = new JSONArray();
        JSONArray routes = new JSONArray();
        jo.put("code", 0);
        jo.put("msg", "登录成功");

        data.put("userId",2);
        data.put("avatar","https://s1.aigei.com/prevfiles/a51818e3e5e84376bae80b10d2aa2ef8.gif?e=1735488000&token=P7S2Xpzfz11vAkASLTkfHN7Fw-oOZBecqeJaxypL:8aJsLngoetNa2SoIsHVsmsccPPo=");
        data.put("username","admin");
        data.put("password",123456);
        data.put("desc","系统管理员");
        roles.add("系统管理员");
        data.put("roles",roles);
        buttons.add("cuser.detail");
        buttons.add("cuser.user");
        data.put("buttons",buttons);
        routes.add("document");
        routes.add("pagination");
        routes.add("pub");
        routes.add("dataSource");
        routes.add("middleware");
        routes.add("edit");
        routes.add("home");
        routes.add("components");
        routes.add("menu-one");
        routes.add("moremenu");
        routes.add("menu-two");
        routes.add("menu-three");
        routes.add("menu-three-1");
        routes.add("menu-three-2");
        routes.add("canvas");
        data.put("routes",routes);
        data.put("token","System_Token");
        jo.put("data", data);
        return jo;
    }
}
