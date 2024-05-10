import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVRecord
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.kotlin.*
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SystemTest {
    private fun setUp(functions: Functions) {
        CSVFormat.DEFAULT.parse(javaClass.classLoader.getResourceAsStream("csv/cos.csv")!!.reader()).forEach {
            whenever(functions.cos(it[0].toDouble())).thenReturn(it[1].toDouble())
        }

        CSVFormat.DEFAULT.parse(javaClass.classLoader.getResourceAsStream("csv/csc.csv")!!.reader()).forEach {
            whenever(functions.csc(it[0].toDouble())).thenReturn(it[1].toDouble())
        }

        CSVFormat.DEFAULT.parse(javaClass.classLoader.getResourceAsStream("csv/ctg.csv")!!.reader()).forEach {
            whenever(functions.ctg(it[0].toDouble())).thenReturn(it[1].toDouble())
        }

        CSVFormat.DEFAULT.parse(javaClass.classLoader.getResourceAsStream("csv/ln.csv")!!.reader()).forEach {
            whenever(functions.ln(it[0].toDouble())).thenReturn(it[1].toDouble())
        }

        CSVFormat.DEFAULT.parse(javaClass.classLoader.getResourceAsStream("csv/log2.csv")!!.reader()).forEach {
            whenever(functions.log2(it[0].toDouble())).thenReturn(it[1].toDouble())
        }

        CSVFormat.DEFAULT.parse(javaClass.classLoader.getResourceAsStream("csv/log3.csv")!!.reader()).forEach {
            whenever(functions.log3(it[0].toDouble())).thenReturn(it[1].toDouble())
        }

        CSVFormat.DEFAULT.parse(javaClass.classLoader.getResourceAsStream("csv/log5.csv")!!.reader()).forEach {
            whenever(functions.log5(it[0].toDouble())).thenReturn(it[1].toDouble())
        }

        CSVFormat.DEFAULT.parse(javaClass.classLoader.getResourceAsStream("csv/log10.csv")!!.reader()).forEach {
            whenever(functions.log10(it[0].toDouble())).thenReturn(it[1].toDouble())
        }

        CSVFormat.DEFAULT.parse(javaClass.classLoader.getResourceAsStream("csv/sin.csv")!!.reader()).forEach {
            whenever(functions.sin(it[0].toDouble())).thenReturn(it[1].toDouble())
        }

        CSVFormat.DEFAULT.parse(javaClass.classLoader.getResourceAsStream("csv/tan.csv")!!.reader()).forEach {
            whenever(functions.tan(it[0].toDouble())).thenReturn(it[1].toDouble())
        }
    }

    @Test
    fun `with mocking all`() {
        val functions = mock<Functions>()
        setUp(functions)

        withCsvData {
            assertEquals(System(functions).system(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    @Test
    fun `with mocking all without sin`() {
        val functions = spy<Functions>()

        withCsvData {
            assertEquals(System(functions).system(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    @Test
    fun `with mocking all without cos`() {
        val functions = mock<Functions>()
        setUp(functions)
        whenever(functions.cos(any())).thenCallRealMethod()

        withCsvData {
            assertEquals(System(functions).system(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    @Test
    fun `with mocking all without tan`() {
        val functions = mock<Functions>()
        setUp(functions)
        whenever(functions.tan(any())).thenCallRealMethod()

        withCsvData {
            assertEquals(System(functions).system(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    @Test
    fun `with mocking all without ctg`() {
        val functions = mock<Functions>()
        setUp(functions)
        whenever(functions.ctg(any())).thenCallRealMethod()

        withCsvData {
            assertEquals(System(functions).system(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    @Test
    fun `with mocking all without csc`() {
        val functions = mock<Functions>()
        setUp(functions)
        whenever(functions.csc(any())).thenCallRealMethod()

        withCsvData {
            assertEquals(System(functions).system(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    @Test
    fun `with mocking all without log5`() {
        val functions = mock<Functions>()
        setUp(functions)
        whenever(functions.log5(any())).thenCallRealMethod()

        withCsvData {
            assertEquals(System(functions).system(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    @Test
    fun `with mocking all without log3`() {
        val functions = mock<Functions>()
        setUp(functions)
        whenever(functions.log3(any())).thenCallRealMethod()

        withCsvData {
            assertEquals(System(functions).system(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    @Test
    fun `with mocking all without log2`() {
        val functions = mock<Functions>()
        setUp(functions)
        whenever(functions.log2(any())).thenCallRealMethod()

        withCsvData {
            assertEquals(System(functions).system(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    @Test
    fun `with mocking all without log10`() {
        val functions = mock<Functions>()
        setUp(functions)
        whenever(functions.log10(any())).thenCallRealMethod()

        withCsvData {
            assertEquals(System(functions).system(it[0].toDouble()), it[1].toDouble(), 0.001)
        }
    }

    private fun withCsvData(block: (CSVRecord) -> Unit) {
        CSVFormat.DEFAULT.parse(javaClass.classLoader.getResourceAsStream("csv/function.csv")!!.reader()).forEach {
            block(it)
        }
    }
}