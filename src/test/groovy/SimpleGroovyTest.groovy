import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

import static org.junit.jupiter.api.Assertions.assertEquals

/**
 @author akimov
  created at 21.11.2020 17:46
 */
class SimpleGroovyTest {
    @Test
    void "1 + 1 = 2"() {
        assertEquals(2, 1 + 1, "1 + 1 should equal 2")
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource([
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    ])
    void add(int first, int second, int expectedResult) {
        assertEquals(expectedResult, first + second) {
            first + " + " + second + " should equal " + expectedResult
        }
    }

}
