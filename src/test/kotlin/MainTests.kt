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
    fun `ecl red invalid`() {
        val input = "ecl:red pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }


    @Test
    fun `Missing pid is invalid`() {
        val input = "ecl:fff eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `Eight digit pid is invalid`() {
        val input = "ecl:gry pid:86003332 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `Missing eyr is invalid`() {
        val input = "ecl:gry pid:860033327 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `2019 eyr is invalid`() {
        val input = "ecl:gry pid:860033323 eyr:2019 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }
    @Test
    fun `2031 eyr is invalid`() {
        val input = "ecl:gry pid:860033323 eyr:2031 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `Missing hcl is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `hcl without hash is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `hcl with seven hex values is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd2 byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `hcl with invalid hex letter is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#rfffff byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `Missing byr is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `1919 byr is invalid`() {
        val input = "ecl:gry pid:860033323 eyr:2020 hcl:#fffffd byr:1919 iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }
    @Test
    fun `2003 eyr is invalid`() {
        val input = "ecl:gry pid:860033323 eyr:2020 hcl:#fffffd byr:2003 iyr:2017 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `Missing iyr is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `2009 iyr is invalid`() {
        val input = "ecl:gry pid:860033323 eyr:2020 hcl:#fffffd byr:2002 iyr:2009 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }
    @Test
    fun `2021 iyr is invalid`() {
        val input = "ecl:gry pid:860033323 eyr:2020 hcl:#fffffd byr:2002 iyr:2021 cid:147 hgt:183cm"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `Missing hgt is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `hgt with units inches valid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147  hgt:62in"

        assertTrue(isValidPassport(input))
    }

    @Test
    fun `hgt of 58 inches is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:58in"

        assertFalse(isValidPassport(input))
    }
    @Test
    fun `hgt of 77 inches is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:77in"

        assertFalse(isValidPassport(input))
    }

    @Test
    fun `hgt of 149cm is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:149cm"

        assertFalse(isValidPassport(input))
    }
    @Test
    fun `hgt of 194cm is invalid`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:194cm"

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