package integration.com.dawidkotarba;

import com.dawidkotarba.playground.PlaygroundApplication;
import com.dawidkotarba.playground.config.DatabaseConfig;
import com.dawidkotarba.playground.config.GeneralConfig;
import com.dawidkotarba.playground.config.LocalizationConfig;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Dawid Kotarba on 17.11.2015.
 */

@SpringApplicationConfiguration(classes = PlaygroundApplication.class)
@WebAppConfiguration
@ContextConfiguration(classes = {DatabaseConfig.class, GeneralConfig.class, LocalizationConfig.class})
@IntegrationTest
@TestExecutionListeners(inheritListeners = false, listeners = {
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class})
public abstract class AbstractTestNgConfiguration extends AbstractTestNGSpringContextTests {

    protected AbstractTestNgConfiguration() {
        // intentionally left blank
    }
}
