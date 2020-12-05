class PidValue: PassportValue {
    override fun isValid(input: String): Boolean {
        val regex = Regex("pid:(\\d+)")
        val pid = regex.find(input)?.groupValues?.get(1)
        return pid?.length == 9
    }
}