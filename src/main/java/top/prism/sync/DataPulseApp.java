package top.prism.sync;

import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;

@SolonMain
public class DataPulseApp {
    public static void main(String[] args) {
        Solon.start(DataPulseApp.class, args);
    }
}