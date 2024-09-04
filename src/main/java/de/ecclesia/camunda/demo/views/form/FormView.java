package de.ecclesia.camunda.demo.views.form;

import java.util.Map;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.beans.factory.annotation.Autowired;

import de.ecclesia.camunda.demo.bpmn.DemoProcessBpmn;
import de.ecclesia.camunda.demo.form.FormService;
import de.ecclesia.camunda.demo.form.Formular;

@PageTitle("form")
@Route(value = "form")
public class FormView extends VerticalLayout implements HasUrlParameter<String> {

	private final FormService formService;
	private final ZeebeClient zeebeClient;

	public FormView(@Autowired FormService formService,
					@Autowired ZeebeClient zeebeClient) {
		this.formService = formService;
		this.zeebeClient = zeebeClient;
		setSpacing(false);
		setSizeFull();
		setDefaultHorizontalComponentAlignment(Alignment.CENTER);
		getStyle().set("text-align", "center");
	}

	@Override
	public void setParameter(BeforeEvent beforeEvent, String s) {
		initView(s);
	}

	private void initView(String formId) {
		final H3 header = new H3("Form ID: " + formId);
		add(header);

		Formular formular = formService.findByFormularId(formId);
		if (formular == null) {
			add(new H3("Formular not found"));
			return;
		}
		add(new H3(formular.getAdditionalInfo()));
		TextField type = new TextField();
		type.setLabel("Guess a type");
		add(type);

		Binder<Formular> binder = new Binder<>();
		binder.forField(type).asRequired().bind(Formular::getType, Formular::setType);
		binder.setBean(formular);

		Button button = new Button("Submit");
		button.setEnabled(false);
		binder.addStatusChangeListener(event -> {
			button.setEnabled(binder.isValid());
		});
		add(button);

		button.addClickListener(event -> submit(binder.getBean()));

	}

	private void submit(Formular bean) {
		formService.save(bean);

		zeebeClient.newSetVariablesCommand(bean.getProcessInstanceId())
				.variables(Map.of(DemoProcessBpmn.VAR_TYPE, bean.getType()))
				.send()
				.join();
		zeebeClient.newPublishMessageCommand()
				.messageName(DemoProcessBpmn.RECEIVE_TASK_EVENT_USER_FORM)
				.correlationKey(bean.getFormularId())
				.send()
				.join();

		Dialog dialog = new Dialog();
		dialog.add(new H3("Formular saved"));
		dialog.add(new Paragraph("See on console if it is the right guess"));
		dialog.setModal(true);
		dialog.setSizeFull();
		dialog.open();
	}
}
