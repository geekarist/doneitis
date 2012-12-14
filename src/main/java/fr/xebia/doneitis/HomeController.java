package fr.xebia.doneitis;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private DateService dateService;

	public HomeController() {
	}

	protected HomeController(DateService dateService) {
		this.dateService = dateService;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		String formattedDate = dateService.getFormattedDate(date, locale);
		model.addAttribute("serverTime", formattedDate);
		Story[] stories = new Story[] { //
		new Story("Show staffing between 2 days", "done"), //
				new Story("View tasks in taskboard view (application using spring mvc)", "ongoing"), //
				new Story("Test staffing with angular e2e scenario runner", "todo"), //
				new Story("Watch hadoop tutorial", "todo") };
		model.addAttribute("stories", stories);
		return "home";
	}
}
