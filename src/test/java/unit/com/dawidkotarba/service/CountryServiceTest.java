package unit.com.dawidkotarba.service;

import com.dawidkotarba.playground.dao.CountryDao;
import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.service.CountryService;
import org.mockito.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Dawid Kotarba on 18.11.2015.
 */
public class CountryServiceTest {

    @InjectMocks
    private CountryService underTest;

    @Mock
    private CountryDao countryDao;

    @Captor
    private ArgumentCaptor<String> nameCaptor;

    @BeforeTest
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
        verify(countryDao).getAll();
        verifyNoMoreInteractions(countryDao);
    }

    @Test
    public void getByNameTest() {
        // given
        String testName = "test";
        doReturn(new ArrayList<CountryDto>()).when(countryDao).getByName(testName);

        // when
        List<CountryDto> result = underTest.getByName(testName);

        // then
        assertThat(result, is(notNullValue()));
        verify(countryDao).getByName(testName);

        verify(countryDao).getByName(nameCaptor.capture());
        assertThat(nameCaptor.getValue(), is(equalTo(testName)));

        verifyNoMoreInteractions(countryDao);
    }

    @Test
    public void addTest() {
        // when
        underTest.add(new CountryDto());

        // then
        verify(countryDao).add(any());
        verifyNoMoreInteractions(countryDao);
    }
}
