package com.gu.microserver;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHolder;
import org.mortbay.jetty.webapp.WebAppContext;

public class MicroServer {

    public static void main(String[] args) throws Exception {

        Config config = getConfiguration(args);
        
        Server server = new Server(config.port);
        WebAppContext root = new WebAppContext(server,"/", null);
        root.addServlet(new ServletHolder(new PageServlet("templates/article.html")), "/article");
        root.addServlet(new ServletHolder(new PageServlet("templates/front.html")), "/front");
        root.addServlet(new ServletHolder(new PageServlet("templates/tv-and-radio.html")), "/tv-and-radio");
        root.addServlet(new ServletHolder(new PageServlet("templates/wide-resource.html")), "/resource");
        root.addServlet(new ServletHolder(new ResourceServlet("text/css", "cssUrl")), "/css");
        root.addServlet(new ServletHolder(new ResourceServlet("text/javascript", "javascriptUrl")), "/js");
        server.start();
    }

    private static Config getConfiguration(String[] args) {
        Config config = new Config();
        if (args != null) {
            for (String arg : args) {
                if (arg.startsWith("--port=")) {
                    config.port = Integer.parseInt(arg.replace("--port=", ""));
                }
            }
        }
        return config;
    }

    private static class Config {
        //  --port=8080
        int port = 8080;
    }
}
