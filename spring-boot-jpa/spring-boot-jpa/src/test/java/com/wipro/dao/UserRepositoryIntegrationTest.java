package com.wipro.dao;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.wipro.entity.User;
/*
 * 
 
 Test Environment Configuration
 
Setting up a proper test environment for JPA repositories can be time-consuming and tricky. 
The @DataJpaTest provides a ready-made testing environment that includes essential components for 
testing JPA repositories, such as the EntityManager and DataSource.

This environment is specifically designed for testing JPA repositories. It ensures that our repository methods 
run within the context of a test transaction, interacting with a safe, in-memory database like H2 instead 
of the production database.

1. Dependency Injection
	@DataJpaTest simplifies the process of dependency injection within our test classes. 
	Repositories, along with other essential beans, are automatically injected into the test context. 
	This seamless integration enables developers to focus on writing concise and effective test cases 
	without the hassle of explicit bean wiring.

2. Rollback by Default
	Moreover, keeping tests independent and reliable is crucial. By default, each test method annotated 
	with @DataJpaTest runs within a transactional boundary. This ensures that changes made to the 
	database are automatically rolled back at the end of the test, leaving a clean slate for the next test.

3. Configuration and Setup
	To use @DataJpaTest, we need to add the spring-boot-starter-test dependency to our project 
	with scope “test“. This lightweight dependency includes essential testing libraries like JUnit 
	for testing, ensuring it’s not included in our production build.
 
 
  The @DataJpaTest annotation is used to test JPA repositories in Spring Boot applications. 
  It’s a specialized test annotation that provides a minimal Spring context for testing the persistence layer. 
  This annotation can be used in conjunction with other testing annotations like @RunWith and @SpringBootTest.

  In addition, the scope of @DataJpaTest is limited to the JPA repository layer of the application. 
  It doesn’t load the entire application context, which can make testing faster and more focused. 
  This annotation also provides a pre-configured EntityManager and TestEntityManager for testing JPA entities.

  Optional Parameters
	@DataJpaTest does have some optional parameters we can use to customize the test environment.

	1. properties
		This parameter allows us to specify Spring Boot configuration properties that will be applied to 
		our test context. This can be useful for adjusting settings like database connection details, 
		transaction behavior, or other application properties relevant to our testing needs:

		@DataJpaTest(properties = {
    		"spring.datasource.url=jdbc:h2:mem:testdb",
    		"spring.jpa.hibernate.ddl-auto=create-drop"
		})
		public class UserRepositoryTest {
    		// ... test methods
		}

	2. showSql
		This enables SQL logging for our tests and allows us to see the actual SQL queries executed 
		by the repository methods. Moreover, this can help debug or understand how the JPA queries 
		are translated. By default, the SQL logging is enabled. We can turn it off by setting 
		the value to false:

		@DataJpaTest(showSql = false)
		public class UserRepositoryTest {
		    // ... test methods
		}
		
		
		@RunWith(SpringRunner.class) : JUnit4
		@ExtendWith(SpringExtension.class) : JUnit 5
		
		@ContextConfiguration(classes = { SpringBootJpaApplication.class })
		
		@DataJpaTest, testing framework configures a in-memory database by default, so provide H2 in-memory
		dependency in pom.xml file. Also note that @DataJpaTest uses @Transactional under the hood i.e. the
		test method is wrapped inside a transaction that is rolled back at the end of test method.
		
		To use the same data source as your regular application i.e to run DataJpaTest with MySQL
		instead of H2 database, apply the following annotation: 
		
			@AutoConfigureTestDatabase(replace=Replace.NONE)
		

 */
@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    private User testUser;

    @BeforeEach
    public void setUp() {
        // Initialize test data before each test method test
        testUser = new User();
        testUser.setUsername("testuser");
        testUser.setPassword("password");
        userRepository.save(testUser);
    }

    @AfterEach
    public void tearDown() {
        // Release test data after each test method
        userRepository.delete(testUser);
    }

    @Test
    void givenUser_whenSaved_thenCanBeFoundById() {
        // Verify that the user has been saved successfully
        User savedUser = userRepository.findById(testUser.getUserid())
            .orElse(null);

        assertNotNull(savedUser);
        assertEquals(testUser.getUsername(), savedUser.getUsername());
        assertEquals(testUser.getPassword(), savedUser.getPassword());
    }

    @Test
    void givenUser_whenUpdated_thenCanBeFoundByIdWithUpdatedData() {
        testUser.setUsername("updatedUsername");
        userRepository.save(testUser);

        User updatedUser = userRepository.findById(testUser.getUserid())
            .orElse(null);

        assertNotNull(updatedUser);
        assertEquals("updatedUsername", updatedUser.getUsername());
    }

    @Test
    void givenUser_whenFindByUsernameCalled_thenUserIsFound() {
        User foundUser = userRepository.findByUsername("testuser");

        assertNotNull(foundUser);
        assertEquals("testuser", foundUser.getUsername());
    }
}
