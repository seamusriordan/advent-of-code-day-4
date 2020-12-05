open class PassportValue(protected val token: String) {
    open fun isValid(input: String): Boolean {
        return Regex(token).containsMatchIn(input)
    }
}