package de.ecclesia.camunda.demo.views.vm;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Overflow;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;


/**
 * The main view is a top-level placeholder for other views.
 */
//@CssImport("./src/main/frontend/themes/styles/styles.css")
public class MainLayout extends AppLayout {

	public MainLayout() {
		addToNavbar(createHeaderContent());
	}

	private Component createHeaderContent() {
		Header header = new Header();
		header.setSizeFull();


		H3 appName = new H3("Veränderungsmeldung");
		appName.addClassNames(Margin.End.AUTO, FontSize.XLARGE, Margin.Start.AUTO, Padding.MEDIUM);
		appName.addClassNames(TextColor.PRIMARY_CONTRAST);
		header.add(appName);
		header.addClassName(LumoUtility.Background.PRIMARY);

		Nav nav = new Nav();
		//<theme-editor-local-classname>
		nav.addClassName("main-layout-nav-1");
		nav.addClassNames(Display.FLEX, Overflow.AUTO, Padding.Horizontal.MEDIUM, Padding.Vertical.XSMALL);

		header.add(nav);
		return header;
	}


}
