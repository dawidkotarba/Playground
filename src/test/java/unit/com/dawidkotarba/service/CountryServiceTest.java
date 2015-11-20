package unit.com.dawidkotarba.service;

import com.dawidkotarba.playground.dao.CountryDao;
import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.service.CountryService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Dawid Kotarba on 18.11.2015.
 */
public class CountryServiceTest {

    @InjectMocks
    private CountryService underTest;

    @Mock
    private CountryDao countryDao;

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
        verify(countryDao, Mockito.times(1)).getAll();
        verifyNoMoreInteractions(countryDao);
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
        verifyNoMoreInteractions(countryDao);
    }

    @Test
    public void addTest() {
        // when
        underTest.add(new CountryDto());

        // then
        verify(countryDao, Mockito.times(1)).add(any());
        verifyNoMoreInteractions(countryDao);
    }
}
