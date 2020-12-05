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

    @Test
    fun `Example invalid input`() {
        val input = "eyr:1972 cid:100\r\n" +
                "hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926\r\n" +
                "\r\n" +
                "iyr:2019\r\n" +
                "hcl:#602927 eyr:1967 hgt:170cm\r\n" +
                "ecl:grn pid:012533040 byr:1946\r\n" +
                "\r\n" +
                "hcl:dab227 iyr:2012\r\n" +
                "ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277\r\n" +
                "\r\n" +
                "hgt:59cm ecl:zzz\r\n" +
                "eyr:2038 hcl:74454a iyr:2023\r\n" +
                "pid:3556412378 byr:2007"

        assertEquals(0, countValidPassports(input))
    }

    @Test
    fun `Example valid input`() {
        val input = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980\r\n" +
                "hcl:#623a2f\r\n" +
                "\r\n" +
                "eyr:2029 ecl:blu cid:129 byr:1989\r\n" +
                "iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm\r\n" +
                "\r\n" +
                "hcl:#888785\r\n" +
                "hgt:164cm byr:2001 iyr:2015 cid:88\r\n" +
                "pid:545766238 ecl:hzl\r\n" +
                "eyr:2022\r\n" +
                "\r\n" +
                "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719"

        assertEquals(4, countValidPassports(input))
    }
}