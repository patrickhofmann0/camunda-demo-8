package de.ecclesia.camunda.demo.bpmn;

public class DemoProcessBpmn {

	public static final String PROCESS_ID = "demo_8_process";

	public static final String VAR_FORMULAR_ID = "formularId";
	public static final String VAR_TYPE = "type";
	public static final String VAR_REMINDER_DURATION = "reminderDuration";

	public static final String JOB_WORKER_MAGIC_PROCESS_DATA = "jb_magic_process_data";
	public static final String JOB_WORKER_PRINT_FORM_LINK = "jb_print_link";
	public static final String JOB_WORKER_PRINT_REMINDER = "jb_print_reminder";
	public static final String JOB_WORKER_MAGIC_FORM_DATA = "jb_magic_form_data";
	public static final String JOB_WORKER_PRINT_WRONG_CHOICE = "jb_print_wrong_choice";

	public static final String RECEIVE_TASK_EVENT_USER_FORM = "user_filled_form";


	private DemoProcessBpmn() {
		// hide constructor
	}
}
