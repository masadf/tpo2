import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.Double.Companion.NaN
import kotlin.test.assertEquals

class BaseFunctionsTest {
    private val baseFunctions = BaseFunctions()

    @ParameterizedTest
    @ValueSource(doubles = [-1.1, -5.0, 0.0, 0.2, 0.8, 1.0, 2.0, 10.0, 20.0, 100.0])
    fun sin(value: Double) {
        assertEquals(kotlin.math.sin(value), baseFunctions.sin(value), 0.0001)
    }

    @ParameterizedTest
    @ValueSource(doubles = [-1.1, -5.0, 0.2, 0.8, 1.0, 2.0, 10.0, 20.0, 100.0])
    fun ln(value: Double) {
        assertEquals(kotlin.math.ln(value), baseFunctions.ln(value), 0.0001)
    }

    @Test
    fun `ln with zero`() {
        assertEquals(NaN, baseFunctions.ln(0.0))
    }
}