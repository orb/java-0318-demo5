package letmein;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SetupApplication implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("********** /letmein loaded");

        UserManager userManager = new UserManager();
        userManager.addUser(new User("bob", "secret"));
        userManager.addUser(new User("fred", "stillabadpassword"));
        userManager.addUser(new User("norman","42vwDL+bn2V6dKTV"));

        sce.getServletContext().setAttribute("userManager", userManager);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
