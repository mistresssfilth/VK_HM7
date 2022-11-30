import commons.FlywayInit;
import core.DefaultServer;
import handlers.SecurityHandlerBuilder;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.security.LoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import servlets.ProductServlet;

import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        final Server server = new DefaultServer().build();

        FlywayInit.initDb();
        ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.NO_SESSIONS);

        context.setContextPath("/");
        final URL resource = LoginService.class.getResource("/static/index.html");
        context.setBaseResource(Resource.newResource(resource.toExternalForm()));
        context.addServlet(new ServletHolder("default", DefaultServlet.class), "/*");
        context.addServlet(new ServletHolder("products", ProductServlet.class),"/products");

        final String hashConfig = Main.class.getResource("/hash_config").toExternalForm();
        final HashLoginService hashLoginService = new HashLoginService("login", hashConfig);
        final ConstraintSecurityHandler securityHandler = new SecurityHandlerBuilder().build(hashLoginService);

        server.addBean(hashLoginService);
        securityHandler.setHandler(context);
        server.setHandler(securityHandler);
        server.start();
    }
}
