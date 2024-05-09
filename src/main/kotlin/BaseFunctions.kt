import kotlin.Double.Companion.NaN
import kotlin.math.abs
import kotlin.math.pow

class BaseFunctions {

    companion object{
        private const val BASE_PRECISION = 0.000001
    }

    fun sin(x: Double): Double {
        var result = 0.0
        var fact = 1.0
        var previousResult: Double
        var i = 0
        var xTmp = x

        while (xTmp > Math.PI) {
            xTmp -= 2.0 * Math.PI
        }

        while (xTmp < -Math.PI) {
            xTmp += 2.0 * Math.PI
        }

        do {
            previousResult = result
            if (i != 0) fact *= (i * (i - 1))
            val xSquare = xTmp.pow(i + 1)
            result += (-1.0).pow(i / 2) * xSquare / (fact * (i + 1))
            i += 2
        } while (abs(previousResult - result) >= BASE_PRECISION)

        return result
    }

    fun ln(x: Double): Double {
        if (x <= 0) return NaN

        val x1 = (x - 1) / (x + 1)
        var cur = x1
        var res = 0.0
        var n = 3

        while (abs(2 * cur) > BASE_PRECISION) {
            res += 2 * cur
            cur *= x1 * x1 / n * (n - 2)
            n += 2
        }

        return res
    }
}