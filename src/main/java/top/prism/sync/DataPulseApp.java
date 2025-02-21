package top.prism.sync;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;

@SolonMain
@Slf4j
public class DataPulseApp {
    public static void main(String[] args) {
        Solon.start(DataPulseApp.class, args);
    }
}