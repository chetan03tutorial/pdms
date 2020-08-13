package com.nataraj.management.auction.pdms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import javax.servlet.*;


@Configuration
@ComponentScan(basePackages = {"com.nataraj.management.auction.pdms.controller"})
@PropertySource({"classpath:/${env}/application.properties"})
@EnableAutoConfiguration
public class WebConfig {

    private Environment environment;

    @Autowired
    public WebConfig(Environment environment){
        this.environment = environment;
    }

    @Bean
    public ServletWebServerFactory jettyWebServerFactory(){
        JettyServletWebServerFactory jetty = new JettyServletWebServerFactory();
        WebAppConfig webAppConfig = new WebAppConfig();
        jetty.addInitializers(webAppConfig:: onStartup);
        jetty.setContextPath("/pdms");
        jetty.setPort(9080);
        return jetty;
    }

    private class WebAppConfig {
        public void onStartup(ServletContext servletContext) throws ServletException {
            // Start up functionality
        }
    }

    private static class ApplicationServletContextLister implements ServletContextListener {
        public void contextInitialized(ServletContextEvent sce) {
            System.out.println("Servlet Context is being initialized, I am going to select a profile" +
                    "or perform some meaningful work");
        }
        public void contextDestroyed(ServletContextEvent sce) {}
    }
}
