package faces;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean(name = "welcome")
public class WelcomePageBean {
    public String getWelcomeMessage() {
        return "Hello and welcome\n Click the button below to get started";
    }
}
