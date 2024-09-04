package de.ecclesia.camunda.demo.views.task;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import org.springframework.beans.factory.annotation.Autowired;

import de.ecclesia.camunda.demo.bpmn.DemoProcessBpmn;
import de.ecclesia.camunda.demo.form.FormService;
import de.ecclesia.camunda.demo.form.Formular;

@PageTitle("task")
@Route(value = "")
@RouteAlias(value = "")
public class TaskView extends VerticalLayout {

	private final FormService formularService;
	private final ZeebeClient zeebeClient;

	public TaskView(@Autowired FormService formularService,
					@Autowired ZeebeClient zeebeClient) {
		this.formularService = formularService;
		this.zeebeClient = zeebeClient;
		setSpacing(false);

		H3 h3 = new H3("Start your demo process here :)");
		add(h3);

		TextField additionalInfo = new TextField();
		additionalInfo.setLabel("Enter Additional Info");
		add(additionalInfo);

		Binder<Formular> binder = new Binder<>();
		binder.forField(additionalInfo).asRequired().bind(Formular::getAdditionalInfo, Formular::setAdditionalInfo);
		binder.setBean(new Formular());

		Button button = new Button("Submit");
		button.setEnabled(false);
		binder.addStatusChangeListener(event -> {
			button.setEnabled(binder.isValid());
		});
		add(button);

		button.addClickListener(event -> submit(binder.getBean()));

		setSizeFull();
		setJustifyContentMode(JustifyContentMode.CENTER);
		setDefaultHorizontalComponentAlignment(Alignment.CENTER);
		getStyle().set("text-align", "center");
	}

	private void submit(Formular bean) {
		bean.setFormularId(UUID.randomUUID().toString());
		Map<String, Object> variables = new HashMap<>();
		variables.put(DemoProcessBpmn.VAR_FORMULAR_ID, bean.getFormularId());
		variables.put(DemoProcessBpmn.VAR_TYPE, bean.getType());
		variables.put(DemoProcessBpmn.VAR_REMINDER_DURATION, "PT1M");
		formularService.save(bean);

		final ProcessInstanceEvent join = zeebeClient.newCreateInstanceCommand()
				.bpmnProcessId(DemoProcessBpmn.PROCESS_ID)
				.latestVersion()
				.variables(variables)
				.send()
				.join();
		bean.setProcessInstanceId(join.getProcessInstanceKey());
		formularService.save(bean);

		Dialog dialog = new Dialog();
		dialog.add(new H3("Formular saved"));
		dialog.add(new Paragraph("Refresh page to start a new process"));
		dialog.setModal(true);
		dialog.setSizeFull();
		dialog.open();
	}

}
