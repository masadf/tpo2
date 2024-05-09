import org.junit.jupiter.api.Test
import org.mockito.kotlin.*
import kotlin.test.assertEquals

class SystemTest {
    private val functions = mock<Functions>()
    private val system = System(functions)

    @Test
    fun `system with negative input`() {
        whenever(functions.ctg(any())).doReturn(10.0)
        whenever(functions.sin(any())).doReturn(2.0)
        whenever(functions.csc(any())).doReturn(3.0)
        whenever(functions.tan(any())).doReturn(-1.0)

        assertEquals(system.system(-5.0), 13824.0)

        verify(functions, times(2)).ctg(-5.0)
        verify(functions).sin(-5.0)
        verify(functions).csc(-5.0)
        verify(functions).tan(-5.0)
    }

    @Test
    fun `system with zero input`() {
        whenever(functions.ctg(any())).doReturn(10.0)
        whenever(functions.sin(any())).doReturn(2.0)
        whenever(functions.csc(any())).doReturn(3.0)
        whenever(functions.tan(any())).doReturn(-1.0)

        assertEquals(system.system(0.0), 13824.0)

        verify(functions, times(2)).ctg(0.0)
        verify(functions).sin(0.0)
        verify(functions).csc(0.0)
        verify(functions).tan(0.0)
    }

    @Test
    fun `system with positive input`() {
        whenever(functions.log10(any())).doReturn(10.0)
        whenever(functions.log2(any())).doReturn(2.0)
        whenever(functions.log3(any())).doReturn(3.0)
        whenever(functions.log5(any())).doReturn(1.0)

        assertEquals(system.system(3.0), -0.4)

        verify(functions, times(3)).log5(3.0)
        verify(functions).log10(3.0)
        verify(functions).log3(3.0)
        verify(functions).log2(3.0)
    }
}