package nsh.codility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import java.time.Duration;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public abstract class AbstractChallenge2021Test {
	abstract Challenge2021Interface getTestObject();

	Challenge2021Interface testObject;

	@BeforeEach
	void setup() {
		testObject = getTestObject();
	}

	@ParameterizedTest
	@MethodSource
	void test_samples(int E, int[] A, int X, int Y) {
		assertEquals(E, testObject.solution(A, X, Y));
	}

	@ParameterizedTest
	@MethodSource(value = "test_samples")
	void test_samples_reverse(int E, int[] A, int X, int Y) {
		A = TestUtils.reverseArray(A);
		assertEquals(E, testObject.solution(A, X, Y));
	}

	static Stream<Arguments> test_samples() {
		return Stream.of( //
				Arguments.of(1, new int[] {4, 1, 4, 3, 3}, 1, 2), //
				Arguments.of(1, new int[] {0, 10, 0}, 3, 4), //
				Arguments.of(1, new int[] {0, 1, 0, 1, 1, 1, 0}, 5, 6));
	}

	@Test
	@DisplayName("Sample 1")
	void test01() {
		int[] A = new int[] {2, 3, 3, 4};
		int L = 3;
		int R = 1;
		int E = 3;

		assertEquals(E, testObject.solution(A, L, R));
	}

	@Test
	@DisplayName("Sample 2")
	void test02() {
		int[] A = new int[] {2, 3, 3, 4};
		int L = 3;
		int R = 1;
		int E = 3;

		assertEquals(E, testObject.solution(A, L, R));
	}

	@Test
	@DisplayName("Sample 2")
	void test03() {
		int[] A = new int[] {2, 3, 3, 4};
		int L = 3;
		int R = 1;
		int E = 3;

		assertEquals(E, testObject.solution(A, L, R));
	}

	private Duration getTimeoutDuration() {
		return Duration.ofMillis(2000);
	}

	@Test
	void test_long_1() {
		int L = 700;
		int[] A = new int[L];
		for (int i = 0; i < L; i++) {
			A[i] = 1;
		}
		int R = 3;

		int E = L;
		assertTimeoutPreemptively(getTimeoutDuration(),
				() -> assertEquals(E, testObject.solution(A, L, R)));
	}
}
