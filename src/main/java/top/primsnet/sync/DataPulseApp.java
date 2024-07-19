package top.primsnet.sync;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;
import org.noear.solon.core.event.AppLoadEndEvent;

@SolonMain
public class DataPulseApp {
    public static void main(String[] args) {
        Solon.start(DataPulseApp.class, args);
    }
}