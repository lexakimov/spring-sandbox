import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.CountDownLatch;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertTimeout;

/**
 * @author akimov
 * created at 14.11.2020 16:26
 */
@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = { com.example.spring_4_demo.configuration.ApplicationConfiguration.class })
//@SpringJUnitConfig
public class SimpleTest {

	@Test
	void assumptions() {
		Assumptions.assumeTrue(false);
	}

	@Test
	void hamcrest() {
		MatcherAssert.assertThat("String", Matchers.hasToString("String"));
	}

	@Test
	void hamcrestFail() {
		MatcherAssert.assertThat("String", Matchers.hasToString("1String"));
	}

	@Test
	void junit5() {
		Assertions.assertAll
				(() -> {
							Assertions.assertThrows(RuntimeException.class, () -> {
								throw new RuntimeException();
							});
						}
				);
	}

	@Test
	void junit5Fail() {
		Assertions.fail();
	}

	@Test
	@Disabled("for demonstration purposes")
	void disabled() {

	}

	@Nested
	@DisplayName("some nested name")
	class Nest {

		@Test
		void junit5() {
		}

		@Test
		@DisplayName("😱")
		void junit5_2() {
		}

		@Test
		@DisplayName("╯°□°）╯")
		void junit5Fail() {
			Assertions.fail();
		}

		@Test
		@Disabled("for demonstration purposes")
		void disabled() {

		}

	}

	@Nested
	@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
	class Some_suit {
		@Test
		void some_test_my_test() {

		}

	}

	@Nested
	class Standard_tests {

		@Test
		void timeoutNotExceeded() {
			// The following assertion succeeds.
			assertTimeout(ofMinutes(2), () -> {
				// Perform task that takes less than 2 minutes.
			});
		}

		@Test
		void timeoutNotExceededWithResult() {
			// The following assertion succeeds, and returns the supplied object.
			String actualResult = assertTimeout(ofMinutes(2), () -> {
				return "a result";
			});
			Assertions.assertEquals("a result", actualResult);
		}

		@Test
		void timeoutNotExceededWithMethod() {
			// The following assertion invokes a method reference and returns an object.
			String actualGreeting = assertTimeout(ofMinutes(2), this::greeting);
			Assertions.assertEquals("Hello, World!", actualGreeting);
		}

		@Test
		void timeoutExceeded() {
			// The following assertion fails with an error message similar to:
			// execution exceeded timeout of 10 ms by 91 ms
			assertTimeout(ofMillis(10), () -> {
				// Simulate task that takes more than 10 ms.
				Thread.sleep(100);
			});
		}

		@Test
		void timeoutExceededWithPreemptiveTermination() {
			// The following assertion fails with an error message similar to:
			// execution timed out after 10 ms
			Assertions.assertTimeoutPreemptively(ofMillis(10), () -> {
				// Simulate task that takes more than 10 ms.
				new CountDownLatch(1).await();
			});
		}

		private String greeting() {
			return "Hello, World!";
		}
	}


}
