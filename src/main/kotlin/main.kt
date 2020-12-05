import java.io.File

fun main() {
    val input = File("src/main/resources/input.txt").readText()

    println(countValidPassports(input))
}

fun countValidPassports(input: String): Int {
    return input.split(Regex("\r\n\r\n")).filter { line -> isValidPassport(line) }.size
}

fun isValidPassport(input: String): Boolean {
    val requiredValues = listOf(
        EyeColorValue(),
        PidValue(),
        YearValue("eyr", 2020, 2030),
        HairColorValue(),
        YearValue("byr", 1920, 2002),
        YearValue("iyr", 2010, 2020),
        HeightValue()
    )

    return requiredValues.all { required -> required.isValid(input) }
}