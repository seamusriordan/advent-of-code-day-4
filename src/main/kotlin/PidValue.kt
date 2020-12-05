class PidValue: PassportValue("pid") {
    override fun isValid(input: String): Boolean {
        val regex = Regex("${token}:(\\d+)")
        val pid = regex.find(input)?.groupValues?.get(1)
        return pid?.length == 9
    }
}