fun main() {
    val baseFunctions = BaseFunctions()
    val functions = Functions(baseFunctions)
    val system = System(functions)

    CsvUtils.printCsv(0.1, -10.0, 10.0, "sin") {
        functions.sin(it)
    }
    CsvUtils.printCsv(0.1, -10.0, 10.0, "ln") {
        functions.ln(it)
    }
    CsvUtils.printCsv(0.1, -10.0, 10.0, "cos") {
        functions.cos(it)
    }
    CsvUtils.printCsv(0.1, -10.0, 10.0, "tan") {
        functions.tan(it)
    }
    CsvUtils.printCsv(0.1, -10.0, 10.0, "ctg") {
        functions.ctg(it)
    }
    CsvUtils.printCsv(0.1, -10.0, 10.0, "csc") {
        functions.csc(it)
    }
    CsvUtils.printCsv(0.1, -10.0, 10.0, "log5") {
        functions.log5(it)
    }
    CsvUtils.printCsv(0.1, -10.0, 10.0, "log3") {
        functions.log3(it)
    }
    CsvUtils.printCsv(0.1, -10.0, 10.0, "log2") {
        functions.log2(it)
    }
    CsvUtils.printCsv(0.1, -10.0, 10.0, "log10") {
        functions.log10(it)
    }
    CsvUtils.printCsv(0.1, -10.0, 10.0, "function") {
        system.system(it)
    }
}