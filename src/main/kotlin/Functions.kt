import kotlin.math.pow
import kotlin.math.sqrt

class Functions(private val baseFunctions: BaseFunctions) {
    fun sin(x: Double) = baseFunctions.sin(x)

    fun ln(x: Double) = baseFunctions.ln(x)

    fun cos(x: Double): Double {
        var xTmp = x

        while (xTmp > Math.PI) {
            xTmp -= 2.0 * Math.PI
        }

        while (xTmp < -Math.PI) {
            xTmp += 2.0 * Math.PI
        }
        val result = sqrt(1 - sin(x).pow(2))

        return if (result != 0.0 && (xTmp > Math.PI / 2 || xTmp < -Math.PI / 2)) {
            -result
        } else {
            result
        }
    }

    fun tan(x: Double) = sin(x) / cos(x)

    fun ctg(x: Double) = cos(x) / sin(x)

    fun csc(x: Double) = 1 / sin(x)

    fun log5(x: Double) = ln(x) / ln(5.0)

    fun log3(x: Double) = ln(x) / ln(3.0)

    fun log2(x: Double) = ln(x) / ln(2.0)

    fun log10(x: Double) = ln(x) / ln(10.0)
}