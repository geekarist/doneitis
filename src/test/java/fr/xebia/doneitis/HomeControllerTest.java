package fr.xebia.doneitis;

import java.util.Date;
import java.util.Locale;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.ui.Model;

public class HomeControllerTest {

	@Test
	public void testHome() {
		// Setup
		Locale locale = Locale.ENGLISH;

		DateService dateService = EasyMock.createMock(DateService.class);
		dateService.getFormattedDate(EasyMock.isA(Date.class), EasyMock.eq(locale));
		EasyMock.expectLastCall().andReturn("date");

		Story[] stories = new Story[] { //
		new Story("Show staffing between 2 days", "done"), //
				new Story("View tasks in taskboard view (application using spring mvc)", "ongoing"), //
				new Story("Test staffing with angular e2e scenario runner", "todo"), //
				new Story("Watch hadoop tutorial", "todo")};

		Model model = EasyMock.createMock(Model.class);
		
		model.addAttribute(EasyMock.eq("stories"), EasyMock.isA(stories.getClass()));
		EasyMock.expectLastCall().andReturn(model);

		model.addAttribute(EasyMock.eq("serverTime"), EasyMock.eq("date"));
		EasyMock.expectLastCall().andReturn(model);
		
		HomeController controller = new HomeController(dateService);

		EasyMock.replay(model, dateService);

		// Test
		String home = controller.home(locale, model);

		// Assert
		EasyMock.verify(model, dateService);
		Assert.assertEquals("home", home);
	}
}
