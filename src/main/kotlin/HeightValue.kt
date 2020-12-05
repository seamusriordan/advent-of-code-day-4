class HeightValue: PassportValue {
    override fun isValid(input: String): Boolean {
        listOf("cm", "in")

        val regex = Regex("hgt:(\\d+)(\\w+)")
        val units = regex.find(input)?.groupValues?.get(2) ?: return false
        val value = regex.find(input)?.groupValues?.get(1)?.toInt() ?: return false

        return when(units) {
            "in" -> value in 59..76
            "cm" -> value in 150..193
            else -> false
        }
    }
}