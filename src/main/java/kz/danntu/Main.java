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
        HorizontalLayout mainLayout = new HorizontalLayout();
        setContent(mainLayout);

        VerticalLayout primary = new VerticalLayout();
        primary.setSizeFull();
        Label labelString = new Label("Example for Link class");
        primary.addComponent(labelString);
        Label labelString2 = new Label("Example for MultiSelect");
        primary.addComponent(labelString2);

        VerticalLayout secondary = new VerticalLayout();
        Link linkLabel = new Link("Open link http://host:port/label/", new ExternalResource("/label/"));
        secondary.addComponent(linkLabel);
        Link linkLabel2 = new Link("Open link http://host:port/combobox/", new ExternalResource("/combobox/"));
        secondary.addComponent(linkLabel2);



        mainLayout.addComponents(primary,secondary);
        mainLayout.setComponentAlignment(primary,Alignment.TOP_CENTER);
        mainLayout.setComponentAlignment(secondary,Alignment.TOP_CENTER);


    }

    @WebServlet(urlPatterns = "/*", name = "Main", asyncSupported = true)
    @VaadinServletConfiguration(ui = Main.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

    }

}
