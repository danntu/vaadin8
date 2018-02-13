package kz.danntu;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUILabel extends UI {


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        final Label label1 = new Label();
        label1.setCaption("Empty constructor");
        label1.setValue("Test1");

        final Label label2 = new Label("Test2");
        label2.setCaption("With Parameter");

        final Label label3 = new Label("Test3", ContentMode.HTML);
        label3.setCaption("With Parameter and ContentMode");

        TextField editor = new TextField("Input text",label3.getValue());
        editor.addValueChangeListener(valueChangeEvent -> {
           label3.setValue(valueChangeEvent.getValue());
        });

        layout.addComponents(label1,label2,label3,editor);

        setContent(layout);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServletLabel", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUILabel.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

    }
}
