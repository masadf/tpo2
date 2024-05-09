import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter


object CsvUtils {
    fun BufferedWriter.printRow(x: Double, value: Double) {
        this.write(x.toString())
        this.write(",")
        this.write(value.toString())
        this.newLine()
    }

    fun printCsv(
        step: Double,
        min: Double,
        max: Double,
        fileName: String,
        func: (Double) -> Double
    ) {
        val file = File("src/main/resources/csv/$fileName.csv")
        file.delete()
        file.createNewFile()

        BufferedWriter(FileWriter(file)).use { bufferedWriter ->

            bufferedWriter.write("x" + "," + "value")
            bufferedWriter.newLine()
            var i = 0

            while (i <= (max - min) / step) {
                (min + i * step).let { x -> bufferedWriter.printRow(x, func(x)) }
                i++
            }
        }
    }
}