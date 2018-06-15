package kz.danntu;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;

import java.util.Arrays;

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
        final HorizontalLayout twoColumns = new HorizontalLayout();
        twoColumns.setWidth("100%");
        twoColumns.setMargin(true);
        twoColumns.setSpacing(true);
        setContent(twoColumns);

        // first column
        VerticalLayout primary = new VerticalLayout();

        TextField firstName = buildTF("First name");
        TextField lastName = buildTF("Last name");
        TextField email = buildTF("email");
        //PopupDateField birthDate = buildPDF("Date of Birth");
        ComboBox gender = buildCB("Gender", "Male", "Female");
        gender.setWidth("100%");


        primary.setCaption("Primary");
        primary.addComponents(firstName, lastName, email, gender);

        twoColumns.addComponent(primary);

        // second column
        VerticalLayout secondary = new VerticalLayout();
        secondary.setCaption("Secondary");

        TextField weight = buildTF("Weight");
        TextField height = buildTF("Height");
        CheckBox active = new CheckBox("Active");
        Label spacer = new Label("");
        spacer.setHeight("62px");
        HorizontalLayout checkbox = new HorizontalLayout();
        checkbox.addComponents(active, spacer);

        //PopupDateField registration = buildPDF("Time of registration");
        ComboBox nationality = buildCB("Nationality", "German", "American",
                "Finnish", "Polish");

        secondary.addComponents(weight, height, checkbox,
                nationality);

//        setup the checkbox
//        active.setHeight("62px");
        checkbox.setComponentAlignment(active, Alignment.MIDDLE_LEFT);

        twoColumns.addComponent(secondary);
    }
    private ComboBox buildCB(String caption, String... options) {
        ComboBox cb = new ComboBox(caption, Arrays.asList(options));
        cb.setWidth("100%");
        return cb;
    }

//    private PopupDateField buildPDF(String caption) {
//        PopupDateField pdf = new PopupDateField(caption);
//        pdf.setWidth("100%");
//        return pdf;
//    }

    private TextField buildTF(String caption) {
        TextField tf = new TextField(caption);
        tf.setWidth("100%");
        return tf;
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServletLabel", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUILabel.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

    }
}
