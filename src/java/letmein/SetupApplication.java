package letmein;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class SetupApplication implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("********** Let's GO!!!!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
