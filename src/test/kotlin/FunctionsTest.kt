import org.junit.jupiter.api.Test
import org.mockito.kotlin.*
import kotlin.math.PI
import kotlin.math.sqrt
import kotlin.test.assertEquals

class FunctionsTest {
    private val baseFunctions = mock<BaseFunctions>()
    private val functions = Functions(baseFunctions)

    @Test
    fun sin() {
        whenever(baseFunctions.sin(any())).doReturn(1.0)

        assertEquals(functions.sin(10.0), 1.0)

        verify(baseFunctions).sin(10.0)
    }

    @Test
    fun ln() {
        whenever(baseFunctions.ln(any())).doReturn(5.0)

        assertEquals(functions.ln(10.0), 5.0)

        verify(baseFunctions).ln(10.0)
    }

    @Test
    fun cos() {
        whenever(baseFunctions.sin(any())).doReturn(1.0)

        assertEquals(functions.cos(10.0), 0.0)

        verify(baseFunctions).sin(10.0)
    }

    @Test
    fun tan() {
        whenever(baseFunctions.sin(any())).doReturn(1 / sqrt(2.0))

        assertEquals(functions.tan(PI / 4), 1.0, 0.000001)

        verify(baseFunctions, times(2)).sin(PI / 4)
    }

    @Test
    fun ctg() {
        whenever(baseFunctions.sin(any())).doReturn(0.5)

        assertEquals(functions.ctg(10.0), -sqrt(3.0), 0.0001)

        verify(baseFunctions, times(2)).sin(10.0)
    }

    @Test
    fun csc() {
        whenever(baseFunctions.sin(any())).doReturn(0.5)

        assertEquals(functions.csc(10.0), 2.0)

        verify(baseFunctions).sin(10.0)
    }

    @Test
    fun log5() {
        whenever(baseFunctions.ln(10.0)).doReturn(0.5)
        whenever(baseFunctions.ln(5.0)).doReturn(2.0)

        assertEquals(functions.log5(10.0), 0.25)

        verify(baseFunctions).ln(10.0)
        verify(baseFunctions).ln(5.0)
    }

    @Test
    fun log3() {
        whenever(baseFunctions.ln(10.0)).doReturn(0.5)
        whenever(baseFunctions.ln(3.0)).doReturn(2.0)

        assertEquals(functions.log3(10.0), 0.25)

        verify(baseFunctions).ln(10.0)
        verify(baseFunctions).ln(3.0)
    }

    @Test
    fun log2() {
        whenever(baseFunctions.ln(10.0)).doReturn(0.5)
        whenever(baseFunctions.ln(2.0)).doReturn(2.0)

        assertEquals(functions.log2(10.0), 0.25)

        verify(baseFunctions).ln(10.0)
        verify(baseFunctions).ln(2.0)
    }

    @Test
    fun log10() {
        whenever(baseFunctions.ln(3.0)).doReturn(0.5)
        whenever(baseFunctions.ln(10.0)).doReturn(2.0)

        assertEquals(functions.log10(3.0), 0.25)

        verify(baseFunctions).ln(3.0)
        verify(baseFunctions).ln(10.0)
    }
}