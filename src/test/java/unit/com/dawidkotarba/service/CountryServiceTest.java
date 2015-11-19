package unit.com.dawidkotarba.service;

import com.dawidkotarba.playground.dao.CountryDao;
import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.service.CountryService;
import integration.com.dawidkotarba.AbstractTestNgConfiguration;
import org.mockito.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * Created by Dawid Kotarba on 18.11.2015.
 */
public class CountryServiceTest extends AbstractTestNgConfiguration {

    @InjectMocks
    private CountryService underTest;

    @Mock
    private CountryDao countryDao;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllTest() {

        // given
        doReturn(new ArrayList<CountryDto>()).when(countryDao).getAll();

        // when
        List<CountryDto> result = underTest.getAll();

        // then
        assertThat(result, is(notNullValue()));
        verify(countryDao, Mockito.times(1)).getAll();
    }

    @Test
    public void getByNameTest() {
        // given
        doReturn(new ArrayList<CountryDto>()).when(countryDao).getByName(anyString());

        // when
        List<CountryDto> result = underTest.getByName("test");

        // then
        assertThat(result, is(notNullValue()));
        verify(countryDao, Mockito.times(1)).getByName(anyString());
    }

    @Test
    public void addTest() {
        // when
        underTest.add(new CountryDto());

        // then
        verify(countryDao, Mockito.times(1)).add(any());
    }
}
