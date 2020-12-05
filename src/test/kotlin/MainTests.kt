import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MainTests {
    @Test
    fun `Eight fields on one line is valid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertTrue(isValidPassport(input))
    }
}