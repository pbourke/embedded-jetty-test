package com.pb;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by pbourke on 11/11/14.
 */
public class StartServer {
    public static void main(String[] args) throws Exception {
        final Server server = new Server(8001);

        final ServletHolder servletHolder = new ServletHolder(new DispatcherServlet());
        servletHolder.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
        servletHolder.setInitParameter("contextConfigLocation", MvcConfig.class.getName());

        final ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.setContextPath("/");
        servletContextHandler.addServlet(servletHolder, "/");
        servletContextHandler.addEventListener(new ContextLoaderListener());
        servletContextHandler.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
        servletContextHandler.setInitParameter("contextConfigLocation", AppConfig.class.getName());

        server.setHandler(servletContextHandler);
        server.start();
        server.join();
    }
}
