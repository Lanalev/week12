import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import static org.mockito.Mockito.doReturn;

import static org.mockito.Mockito.spy;

import org.junit.jupiter.params.provider.MethodSource;
class TestDemoTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
	testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")

	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
	if(!expectException) {
	assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
	} if (expectException) {
	assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
	}
	}

	static Stream<Arguments> argumentsForAddPositive() {
	return Stream.of(
	arguments(4, 5, 9, false),
	arguments(-3, 7, 4, true),
	arguments(2, -1, 1, true),
	arguments(0, 9, 9, true),
	arguments(12, 3, 15, false),
	arguments(1, 17, 18, false)
	);
	}


	@Test
	void assertThatNumberSquaredIsCorrect() {
	TestDemo mockDemo = spy(testDemo);
	doReturn(5).when(mockDemo).getRandomInt();
	int fiveSquared = mockDemo.randomNumberSquared();
	assertThat(fiveSquared).isEqualTo(25);
	}
	}
