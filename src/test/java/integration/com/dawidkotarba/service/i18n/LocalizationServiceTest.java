package integration.com.dawidkotarba.service.i18n;

/**
 * Created by Dawid Kotarba on 14.11.2015.
 */

import com.dawidkotarba.playground.service.i18n.LocalizationService;
import integration.com.dawidkotarba.AbstractTestNgConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LocalizationServiceTest extends AbstractTestNgConfiguration {

    @Autowired
    private LocalizationService underTest;

    @Test
    public void getMessageTest() {
        String result = underTest.getMessage("app.name");
        assertEquals(result, "Playground");
    }
}
