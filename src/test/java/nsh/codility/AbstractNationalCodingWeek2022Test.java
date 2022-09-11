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

public abstract class AbstractNationalCodingWeek2022Test {
	abstract NationalCodingWeek2022Interface getTestObject();

	NationalCodingWeek2022Interface testObject;

	@BeforeEach
	void setup() {
		testObject = getTestObject();
	}

	@ParameterizedTest
	@MethodSource
	void test_samples(int E, int[] A, int[] B) {
		assertEquals(E, testObject.solution(A, B));
	}

	static Stream<Arguments> test_samples() {
		return Stream.of( //
				Arguments.of(6, new int[] {0, 3, 4, 2, 6, 3}, new int[] {3, 1, 3, 3, 3, 5}), //
				Arguments.of(9, new int[] {0, 4, 2, 2, 4}, new int[] {1, 3, 1, 3, 5}), //
				Arguments.of(16, new int[] {0, 4, 4, 2, 7, 6, 3,}, new int[] {3, 5, 1, 3, 4, 3, 4}));
	}

	@ParameterizedTest
	@MethodSource
	void test_extreme_small(int E, int[] A, int[] B) {
		assertEquals(E, testObject.solution(A, B));
	}

	static Stream<Arguments> test_extreme_small() {
		return Stream.of( //
				Arguments.of(0, new int[] {}, new int[] {}), //
				Arguments.of(0, new int[] {}, new int[] {}),
				Arguments.of(2, new int[] {0, 2}, new int[] {2, 1}),
				Arguments.of(2, new int[] {0, 2}, new int[] {1, 1}));
	}

	@ParameterizedTest
	@MethodSource
	void test1(int E, int[] A, int[] B) {
		assertEquals(E, testObject.solution(A, B));
	}

	static Stream<Arguments> test1() {
		return Stream.of( //
				Arguments.of(25, new int[] {9, 0, 1, 5, 4, 4, 3, 6, 6},
						new int[] {8, 1, 2, 2, 1, 8, 2, 3, 7}),
				Arguments.of(91, new int[] {1, 1, 1, 1, 1, 1, 1, 7, 7, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6},
						new int[] {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}));
	}

	private Duration getTimeoutDuration() {
		return Duration.ofMillis(2000);
	}

	@Test
	@DisplayName("Long Data")
	void test_long_data() {
		int N = 1000;
		int[] A = new int[N];
		int[] B = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = i;
			B[i] = i + 1;
		}
		int E = 250500;

		assertEquals(E, testObject.solution(A, B));
		assertTimeoutPreemptively(getTimeoutDuration(),
				() -> assertEquals(E, testObject.solution(A, B)));

	}
}
