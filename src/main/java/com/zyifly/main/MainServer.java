package com.zyifly.main;

import com.zyifly.util.ConfigUtil;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.core.io.ClassPathResource;

public class MainServer {
	public static void main(String[] args) throws Exception {
		Server server = new Server();
		SelectChannelConnector nioconnector = new SelectChannelConnector();
		nioconnector.setName("nioconnector");
		nioconnector.setPort(ConfigUtil.getInstance().getInt("jetty.nio.port", 9000));
		// 连接空闲的时间 如果为-1则连接一直保持
		nioconnector.setMaxIdleTime(ConfigUtil.getInstance().getInt("jetty.nio.maxidletime", 3000));
		// ThreadPoolExecutor
		nioconnector.setThreadPool(new QueuedThreadPool(ConfigUtil.getInstance().getInt("jetty.nio.pool.size", 200)));
		// 连接在accept前等待的连接限制 默认50
		nioconnector.setAcceptQueueSize(ConfigUtil.getInstance().getInt("jetty.nio.acceptqueue.size", 5000));
		// 1~(core + 1)
		nioconnector.setAcceptors(ConfigUtil.getInstance().getInt("jetty.nio.acceptor.size", 2));
		// 每个acceptor的连接数=(lowResourceConnection + acceptor - 1)/acceptor
		nioconnector.setLowResourcesConnections(ConfigUtil.getInstance().getInt("jetty.nio.lowresourcesconnection.size", 20000));

		nioconnector.setLowResourcesMaxIdleTime(ConfigUtil.getInstance().getInt("jetty.nio.lowresourcesmaxidletime", 1000));
		// close socket 时是否立即关闭socket 还是等待一段时间将套接字上的数据发送出去
		// 如果设置为0,直接关闭socket 可以避免time_wait状态
		nioconnector.setSoLingerTime(ConfigUtil.getInstance().getInt("jetty.bio.solingertime", 50));
		nioconnector.setStatsOn(false);
		server.setConnectors(new Connector[]{nioconnector});

		WebAppContext webContext = new WebAppContext();
		String resourceBase = new ClassPathResource(".").getURI().toString();
		System.out.println("resourceBase:" + resourceBase);
		webContext.setResourceBase(resourceBase);
		String descriptor = MainServer.class.getClassLoader().getResource("").getPath() + "web.xml";
		System.out.println("descriptor:" + descriptor);
		webContext.setDescriptor(descriptor);
		webContext.setContextPath(ConfigUtil.getInstance().get("application.name", "microservices"));
		//
		HandlerList handlers = new HandlerList();
		handlers.addHandler(webContext);
		server.setHandler(handlers);
		server.start();
		System.err.println("init complete...");
		server.join();
		// 设置在JVM退出时关闭Jetty的钩子。
		server.setStopAtShutdown(true);
	}

}