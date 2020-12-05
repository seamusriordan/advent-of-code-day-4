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
    fun `Missing hgt is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `One valid passport on one line counts one`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertEquals(1, countValidPassports(input))
    }

    @Test
    fun `Two valid passports on two lines counts two`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm\r\n\r\n" +
                "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertEquals(2, countValidPassports(input))
    }

    @Test
    fun `One valid one invalid passports on two lines counts one`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm\r\n\r\n" +
                "fdl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertEquals(1, countValidPassports(input))
    }

    @Test
    fun `One valid passports on two lines counts one`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\r\n byr:1937 iyr:2017 cid:147 hgt:183cm\r\n"

        assertEquals(1, countValidPassports(input))
    }

    @Test
    fun `Example input`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\r\n" +
                "byr:1937 iyr:2017 cid:147 hgt:183cm\r\n" +
                "\r\n" +
                "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\r\n" +
                "hcl:#cfa07d byr:1929\r\n" +
                "\r\n" +
                "hcl:#ae17e1 iyr:2013\r\n" +
                "eyr:2024\r\n" +
                "ecl:brn pid:760753108 byr:1931\r\n" +
                "hgt:179cm\r\n" +
                "\r\n" +
                "hcl:#cfa07d eyr:2025 pid:166559648\r\n" +
                "iyr:2011 ecl:brn hgt:59in"

        assertEquals(2, countValidPassports(input))
    }
}