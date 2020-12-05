class EyeColorValue : PassportValue {
    override fun isValid(input: String): Boolean {
        val validEyeColors = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
        val regex = Regex("ecl:(\\w+)")
        val eyeColor = regex.find(input)?.groupValues?.get(1)
        return validEyeColors.contains(eyeColor)
    }
}