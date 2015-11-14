package integration.com.dawidkotarba.service.i18n;

/**
 * Created by Dawid Kotarba on 14.11.2015.
 */

import com.dawidkotarba.playground.PlaygroundApplication;
import com.dawidkotarba.playground.service.i18n.LocalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@SpringApplicationConfiguration(classes = PlaygroundApplication.class)
@WebAppConfiguration
@IntegrationTest
@TestExecutionListeners(inheritListeners = false, listeners = {
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class})
public class LocalizationServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private LocalizationService underTest;

    @Test
    public void getMessageTest() {
        String result = underTest.getMessage("app.name");
        assertEquals(result, "Playground");
    }
}
