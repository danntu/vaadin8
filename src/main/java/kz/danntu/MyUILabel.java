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

        Panel panel = new Panel("Panel Containing a Label and TextField");
        panel.setWidth("600px");

        FormLayout content = new FormLayout();
        content.addComponents(label3,editor);
        panel.setContent(content);


        Label textLabel = new Label(
                "Text where formatting characters, such as \\n, " +
                        "and HTML, such as <b>here</b>, are quoted.",
                ContentMode.TEXT);

        Label preLabel = new Label(
                "Preformatted text is shown in an HTML <pre> tag.\n" +
                        "Formatting such as\n" +
                        " * newlines\n" +
                        " * whitespace\n" +
                        "and such are preserved. HTML tags, \n"+
                        "such as <b>bold</b>, are quoted.",
                ContentMode.PREFORMATTED);

        Label htmlLabel = new Label(
                "In HTML mode, all HTML formatting tags, such as \n" +
                        "<ul>"+
                        " <li><b>bold</b></li>"+
                        " <li>itemized lists</li>"+
                        " <li>etc.</li>"+
                        "</ul> "+
                        "are preserved.",
                ContentMode.HTML);



        layout.addComponents(label1,label2,panel,textLabel,preLabel,htmlLabel);

        setContent(layout);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServletLabel", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUILabel.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

    }
}
