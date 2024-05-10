import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVRecord
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*
import kotlin.math.PI
import kotlin.math.sqrt
import kotlin.test.assertEquals

class FunctionsTest {
    private val baseFunctions = mock<BaseFunctions>()
    private val functions = Functions(baseFunctions)

    @BeforeEach
    fun setUp() {
        CSVFormat.DEFAULT.parse(javaClass.classLoader.getResourceAsStream("csv/ln.csv")!!.reader()).forEach {
            whenever(baseFunctions.ln(it[0].toDouble())).thenReturn(it[1].toDouble())
        }

        CSVFormat.DEFAULT.parse(javaClass.classLoader.getResourceAsStream("csv/sin.csv")!!.reader()).forEach {
            whenever(baseFunctions.sin(it[0].toDouble())).thenReturn(it[1].toDouble())
        }
    }

    @Test
    fun sin() {
        whenever(baseFunctions.sin(any())).doReturn(1.0)

        assertEquals(functions.sin(10.0), 1.0)

        verify(baseFunctions).sin(10.0)
    }

    @Test
    fun `sin integration`() {
        whenever(baseFunctions.sin(any())).thenCallRealMethod()

        withCsvData("sin") {
            assertEquals(functions.sin(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    @Test
    fun ln() {
        whenever(baseFunctions.ln(any())).doReturn(5.0)

        assertEquals(functions.ln(10.0), 5.0)

        verify(baseFunctions).ln(10.0)
    }

    @Test
    fun `ln integration`() {
        whenever(baseFunctions.ln(any())).thenCallRealMethod()

        withCsvData("ln") {
            assertEquals(functions.ln(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    @Test
    fun cos() {
        whenever(baseFunctions.sin(any())).doReturn(1.0)

        assertEquals(functions.cos(10.0), 0.0)

        verify(baseFunctions).sin(10.0)
    }

    @Test
    fun `cos integration`() {
        withCsvData("cos") {
            assertEquals(functions.cos(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    @Test
    fun tan() {
        whenever(baseFunctions.sin(any())).doReturn(1 / sqrt(2.0))

        assertEquals(functions.tan(PI / 4), 1.0, 0.000001)

        verify(baseFunctions, times(2)).sin(PI / 4)
    }

    @Test
    fun `tan integration`() {
        withCsvData("tan") {
            assertEquals(functions.tan(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    @Test
    fun ctg() {
        whenever(baseFunctions.sin(any())).doReturn(0.5)

        assertEquals(functions.ctg(10.0), -sqrt(3.0), 0.0001)

        verify(baseFunctions, times(2)).sin(10.0)
    }

    @Test
    fun `ctg integration`() {
        withCsvData("ctg") {
            assertEquals(functions.ctg(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    @Test
    fun csc() {
        whenever(baseFunctions.sin(any())).doReturn(0.5)

        assertEquals(functions.csc(10.0), 2.0)

        verify(baseFunctions).sin(10.0)
    }

    @Test
    fun `csc integration`() {
        withCsvData("csc") {
            assertEquals(functions.csc(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
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
    fun `log5 integration`() {
        withCsvData("csc") {
            assertEquals(functions.log5(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
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
    fun `log3 integration`() {
        withCsvData("log3") {
            assertEquals(functions.log3(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
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
    fun `log2 integration`() {
        withCsvData("log2") {
            assertEquals(functions.log2(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    @Test
    fun log10() {
        whenever(baseFunctions.ln(3.0)).doReturn(0.5)
        whenever(baseFunctions.ln(10.0)).doReturn(2.0)

        assertEquals(functions.log10(3.0), 0.25)

        verify(baseFunctions).ln(3.0)
        verify(baseFunctions).ln(10.0)
    }

    @Test
    fun `log10 integration`() {
        withCsvData("log10") {
            assertEquals(functions.log10(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    private fun withCsvData(functionName: String, block: (CSVRecord) -> Unit) {
        CSVFormat.DEFAULT.parse(javaClass.classLoader.getResourceAsStream("csv/$functionName.csv")!!.reader()).forEach {
            block(it)
        }
    }
}