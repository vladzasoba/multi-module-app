package faces;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "welcome")
public class WelcomePageBean {
    public String getWelcomeMessage() {
        return "Hello!\n Please enter your name below";
    }
}
