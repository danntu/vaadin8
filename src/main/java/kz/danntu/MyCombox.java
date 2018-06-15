package kz.danntu;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdaniyar on 6/15/18.
 */
public class MyCombox extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        HorizontalLayout layout = new HorizontalLayout();
        setContent(layout);

        ComboBox comboBox = new ComboBox();
        List<String> list = new ArrayList<>();
        list.add("Test1");
        list.add("Test2");
        comboBox.setItems(list);
        layout.addComponent(comboBox);
        layout.setComponentAlignment(comboBox, Alignment.TOP_CENTER);
    }
    @WebServlet(urlPatterns = {"/combobox/*","/VAADIN/*"}, name = "MyUIServletLabel", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyCombox.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

    }
}
