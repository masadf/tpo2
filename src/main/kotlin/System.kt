import kotlin.math.pow

class System(private val functions: Functions) {
    fun system(x: Double): Double = with(functions) {
        if (x <= 0) {
            ((ctg(x) * sin(x) / ctg(x)).pow(3) * (csc(x) * tan(x).pow(2))).pow(3)
        } else {
            ((log5(x).pow(2).pow(3)) - log3(x)) * (log2(x) / log10(x)) + (log5(x) - log5(x))
        }
    }
}