package pl.coderslab.springfinal;

import pl.coderslab.springfinal.entity.User;
import pl.coderslab.springfinal.repository.RoleRepository;
import pl.coderslab.springfinal.repository.UserRepository;
import pl.coderslab.springfinal.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.springfinal.service.UserServiceDb;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {
    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private RoleRepository mockRoleRepository;
    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;

    private UserService userServiceUnderTest;
    private User user;
    private User userFromDatabase;

    @Before
    public void setUp() {
        initMocks(this);
        userServiceUnderTest = new UserServiceDb(mockUserRepository, mockRoleRepository, mockBCryptPasswordEncoder);

        user = User.builder()
                .id(1L)
                .username("testUser")
                .password("1234567")
                .email("test@test.com")
                .build();

        userFromDatabase = userServiceUnderTest.save(user);

        Mockito.when(mockUserRepository.save(any())).thenReturn(user);
        Mockito.when(mockUserRepository.findByEmail(anyString())).thenReturn(user);
        Mockito.when(mockUserRepository.findByUsername(anyString())).thenReturn(user);
    }

    @Test
    public void testFindUserByEmail() {
        // Setup
        final String email = "test@test.com";

        // Run the test
        final User result = userServiceUnderTest.findOneByEmail(email);

        // Verify the results
        assertEquals(email, result.getEmail());
    }

    @Test
    public void testFindUserByUsername() {
        // Setup
        final String username = "testUser";

        // Run the test
        final User result = userServiceUnderTest.findByUserName(username);

        // Verify the results
        assertEquals(username, result.getUsername());
    }


    @Test
    public void testSaveUser() {
        // Setup
        final String email = "test@test.com";

        // Run the test
        User result = userServiceUnderTest.save(User.builder().build());

        // Verify the results
        assertEquals(email, result.getEmail());
    }

    @Test
    public void testToggleEnabled() {
        // Setup
        final Boolean defaultEnabled = true;
        final User user = userServiceUnderTest.save(User.builder().build());

        // Run the test
        Boolean result = user.getEnabled();

        // Verify the results
        assertEquals(defaultEnabled, result);
    }
}
