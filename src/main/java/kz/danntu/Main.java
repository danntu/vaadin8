package kz.danntu;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

/**
 * Created by mdaniyar on 6/15/18.
 */
public class Main extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();
        Label label = new Label("Text");
        Link linklabel = new Link("Label", new ExternalResource("/label/"));
        layout.addComponent(label);
        layout.addComponent(linklabel);
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "Main", asyncSupported = true)
    @VaadinServletConfiguration(ui = Main.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

    }

}
