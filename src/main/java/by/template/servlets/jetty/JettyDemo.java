package by.template.servlets.jetty;

import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Separate startup class for people that want to run the examples directly. Use parameter
 * -Dcom.sun.management.jmxremote to startup JMX (and e.g. connect with jconsole).
 */
public class JettyDemo {
    /**
     * Main function, starts the jetty server.
     *
     * @param args
     */
    public static void main(final String[] args) {
        startInstance(8081);
    }

    private static void startInstance(final int port) {
        final Server server = new Server();

        final HttpConfiguration http_config = new HttpConfiguration();
        http_config.setOutputBufferSize(32768);

        final ServerConnector http = new ServerConnector(server,
                new HttpConnectionFactory(http_config));
        http.setPort(port);
        http.setIdleTimeout(1000 * 60 * 60);

        server.addConnector(http);

        final Configuration.ClassList classlist = Configuration.ClassList.setServerDefault(server);
        classlist.addAfter("org.eclipse.jetty.webapp.FragmentConfiguration",
                "org.eclipse.jetty.plus.webapp.EnvConfiguration",
                "org.eclipse.jetty.plus.webapp.PlusConfiguration");
        classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
                "org.eclipse.jetty.annotations.AnnotationConfiguration");

        final WebAppContext bb = new WebAppContext();
        bb.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
                ".*/[^/]*jstl.*\\.jar$");
        bb.setServer(server);
        bb.setContextPath("/");
        bb.setWar("src/main/webapp");

        server.setHandler(bb);

        /*
         * MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer(); MBeanContainer
         * mBeanContainer = new MBeanContainer(mBeanServer);
         * server.addEventListener(mBeanContainer); server.addBean(mBeanContainer);
         */

        try {
            server.start();
            // server.join();
        } catch (final Exception e) {
            e.printStackTrace();
            System.exit(100);
        }
    }
}