fun main(args: Array<String>) {
    println("Hello World!")
}

fun countValidPassports(input: String): Int {
    return 1
}

fun isValidPassport(input: String): Boolean {
    val requiredString = listOf("ecl", "pid", "eyr", "hcl", "byr", "iyr", "cid", "hgt")

    val requiredRegex = requiredString.map { requiredString -> Regex(requiredString) }

    return requiredRegex.all { requiredRegex -> input.contains(requiredRegex) }
}