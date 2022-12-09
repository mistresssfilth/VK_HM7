package core;

import org.eclipse.jetty.server.*;

public class DefaultServer {
    private final Server server = new Server();
    private static final int port = 3466;

    public Server build() {
        return build(port);
    }

    public Server build(int port) {
        final var httpConfig = new HttpConfiguration();
        final var httpConnectionFactory = new HttpConnectionFactory(httpConfig);
        final var serverConnector = new ServerConnector(server, httpConnectionFactory);
        serverConnector.setHost("localhost");
        serverConnector.setPort(port);
        server.setConnectors(new Connector[]{serverConnector});
        return server;
    }
}
