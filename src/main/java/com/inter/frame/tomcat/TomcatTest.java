package com.inter.frame.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

/**
 * 代码启动 tomcat
 * @author AthyLau
 **/
public class TomcatTest {

    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(8089);
        connector.setURIEncoding("UTF-8");

        tomcat.getService().addConnector(connector);
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
        // 启动完成后不让tomcat处于等待状态的话 tomcat 会跟随线程执行而结束
        tomcat.getServer().await();
    }

}
