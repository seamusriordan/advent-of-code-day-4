class YearValue(token: String, private val minYear: Int, private val maxYear: Int): PassportValue(token) {
    override fun isValid(input: String): Boolean {
        val regex = Regex("${token}:(\\d{4})")
        val year = regex.find(input)?.groupValues?.get(1)?.toInt() ?: return false

        return year in minYear..maxYear
    }
}