import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MainTests {
    @Test
    fun `Eight fields on one line is valid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertTrue(isValidPassport(input))
    }

    @Test
    fun `Missing ecl is invalid`() {
        val input = "pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `Missing pid is invalid`() {
        val input = "ecl:gry eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `Missing eyr is invalid`() {
        val input = "ecl:gry pid:860033327 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `Missing hcl is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `Missing byr is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `Missing iyr is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `Missing cid is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `Missing hgt is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `One valid passport on one line counts one`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147"

        assertEquals(1, countValidPassports(input))
    }
}