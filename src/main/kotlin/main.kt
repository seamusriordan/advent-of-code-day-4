import java.io.File

fun main() {
    val input = File("src/main/resources/input.txt").readText()

    println(countValidPassports(input))
}

fun countValidPassports(input: String): Int {
    return input.split(Regex("\r\n\r\n")).filter { line -> isValidPassport(line) }.size
}

fun isValidPassport(input: String): Boolean {
    val requiredString = listOf("ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt")

    val requiredRegex = requiredString.map { token -> Regex(token) }

    return requiredRegex.all { regex -> input.contains(regex) }
}