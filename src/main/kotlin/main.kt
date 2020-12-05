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
        PassportValue("pid"),
        PassportValue("eyr"),
        PassportValue("hcl"),
        PassportValue("byr"),
        PassportValue("iyr"),
        PassportValue("hgt")
    )

    return requiredValues.all { required -> required.isValid(input) }
}