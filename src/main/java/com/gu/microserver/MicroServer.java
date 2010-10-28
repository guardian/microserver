package com.gu.microserver;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHolder;
import org.mortbay.jetty.webapp.WebAppContext;

public class MicroServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        WebAppContext root = new WebAppContext(server,"/", null);
        root.addServlet(new ServletHolder(new PageServlet("templates/article.html")), "/article");
        root.addServlet(new ServletHolder(new PageServlet("templates/front.html")), "/front");
        root.addServlet(new ServletHolder(new PageServlet("templates/tv-and-radio.html")), "/tv-and-radio");
        root.addServlet(new ServletHolder(new PageServlet("templates/wide-resource.html")), "/resource");
        root.addServlet(new ServletHolder(new ResourceServlet("text/css", "cssUrl")), "/css");
        root.addServlet(new ServletHolder(new ResourceServlet("text/javascript", "javascriptUrl")), "/js");
        server.start();
    }

}
