class HairColorValue: PassportValue("hcl") {
    override fun isValid(input: String): Boolean {
        val regex = Regex("${token}:#([0-9abdcef]{6})\\s+")
        return regex.find(input)?.groupValues?.get(1) != null
    }
}