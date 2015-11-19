package unit.com.dawidkotarba.service;

import com.dawidkotarba.playground.dao.UserDao;
import com.dawidkotarba.playground.integration.dto.UserInDto;
import com.dawidkotarba.playground.integration.dto.UserOutDto;
import com.dawidkotarba.playground.service.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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
 * Created by Dawid Kotarba on 19.11.2015.
 */
public class UserServiceTest {

    @InjectMocks
    private UserService underTest;

    @Mock
    private UserDao userDao;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllTest() {

        // given
        doReturn(new ArrayList<UserOutDto>()).when(userDao).getAll();

        // when
        List<UserOutDto> result = underTest.getAll();

        // then
        assertThat(result, is(notNullValue()));
        verify(userDao, Mockito.times(1)).getAll();
    }

    @Test
    public void getByNameTest() {
        // given
        doReturn(new ArrayList<UserOutDto>()).when(userDao).getByName(anyString());

        // when
        List<UserOutDto> result = underTest.getByName("test");

        // then
        assertThat(result, is(notNullValue()));
        verify(userDao, Mockito.times(1)).getByName(anyString());
    }

    @Test
    public void addTest() {
        // when
        underTest.add(new UserInDto());

        // then
        verify(userDao, Mockito.times(1)).add(any());
    }
}
