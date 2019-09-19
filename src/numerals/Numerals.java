package numerals;

/**
 * A small class to allow generation & manipulation of years in Roman numeral format. 
 * This program covers all years from 9999 BC to 9999 AD inclusive.
 * Input year strings must conform to the format: YYYY BC or YYYY AD,
 * where YYYY is a positive integer between 1 and 9999 inclusive. 
 * Only one space is allowed before the era string, "BC" or "AD".
 */

public class Numerals
{
	private String era; // Era initials, e.g. "BC" or "AD"
	private int year; // Arabic year alone, e.g. 1916
	private String yearSt; // Input year string with era and space removed

	public Numerals(String stringYear) // Full Arabic year as a string, e.g.
										// 1916 AD
	{
		if (stringYear.equals(""))
		{
			throw new IllegalArgumentException("Invalid input !", new Throwable("Empty string"));
		}
		if (stringYear.length() < 4)
		{
			throw new IllegalArgumentException("Invalid input !", new Throwable("String too short"));
		}
		era = stringYear.substring(stringYear.length() - 2);
		if (!era.equals("BC") && !era.equals("AD")) // Invalid era string, i.e not BC or AD
		{
			throw new IllegalArgumentException("Invalid input !", new Throwable("Era string wrong"));
		}
		yearSt = stringYear.substring(0, stringYear.length() - 3);
		if (!yearSt.equals(yearSt.trim()))
			throw new IllegalArgumentException("Invalid input !", new Throwable("More than 1 space before era"));
		try
		{
			year = Integer.parseInt(yearSt);
		}
		catch (Exception e)
		{
			throw new IllegalArgumentException("Invalid input !", new Throwable("Year in wrong format"));
		}
		if (year < 0)
			throw new IllegalArgumentException("Invalid input !", new Throwable("Negative year"));
	}

	public static void main(String[] args)
	{
		Numerals numerals;
		String[] testYears = { // Invalid input formats ...

				"", // Blank input
				"?", // Input char invalid & too short
				"9BC", // No space between year and era & too short
				"0 BC", // Invalid year
				"0 AD", // Invalid year
				"1 AB", // Invalid era string
				"1 A.D.", // Era has periods
				"AD 12", // Era before year
				"1 ad", // Era lower case
				"? BC", // Year has invalid char
				"-157 BC", // Negative year
				"33.3 BC", // Non-integer year
				"10  BC", // Double spacing before era

				// Valid formats ...

				"9 BC", // Low BC year & IX test
				"99 AD", // Low AD year & XCIX vs IC test
				"432 AD", // CD test
				"999 AD", // CM test & XCIX test
				"1001 AD", // MI test
				"1492 AD", // MCD test
				"1690 AD", // MDC test
				"1789 AD", // Bastille test !
				"1899 AD", // Just before MCM test
				"1900 AD", // MCM test
				"2018 AD", // This year test
				"4018 AD", // MV-prime test
				"5092 AD", // V-prime test
				"8999 AD", // Just before MX-prime test
				"9999 AD", // Just before X-prime test

				"11700 AD" // Out of allowed range input
		};

		for (String testYear : testYears)
		{
			try
			{
				numerals = new Numerals(testYear);
			}
			catch (Exception iae)
			{
				System.out.printf("\n%-20s%-20s", testYear,
						iae.getMessage() + " Cause: " + iae.getCause().getMessage());
				continue;
			}
			try
			{
				numerals.calcRomanYear();
			}
			catch (Exception iae)
			{
				System.out.printf("\n%-20s%-20s", testYear,
						iae.getMessage() + " Cause: " + iae.getCause().getMessage());
				continue;
			}
			System.out.printf("\n%-20s%-20s", testYear, numerals.calcRomanYear());
		}

	}

	public String calcRomanYear()
	{
		if (year == 0) // 0 BC/AD check ...
			throw new IllegalArgumentException("Invalid input !", new Throwable("No year 0 BC or 0 AD"));

		if (year / 1000 > 9) // Date range check ...
			throw new IllegalArgumentException("Invalid input !", new Throwable("Year out of range"));

		StringBuilder romanYear = new StringBuilder(); // Initialise output string

		final String[][] numerals = { // Numerals for ...

								{ "I", // ... XXX1
								 "II", // ... XXX2
								 "III", // ... XXX3
								 "IV", // ... XXX4
								 "V", // ... XXX5
								 "VI", // ... XXX6
								 "VII", // ... XXX7
								 "VIII", // ... XXX8
								 "IX" }, // ... XXX9

								{ "X", // ... XX1X
								  "XX", // ... XX2X
								  "XXX", // ... XX3X
								  "XL", // ... XX4X
								  "L", // ... XX5X
								  "LX", // ... XX6X
								  "LXX", // ... XX7X
								  "LXXX", // ... XX8X
								  "XC" }, // ... XX9X

								{ "C", // ... X1XX
								 "CC", // ... X2XX
								 "CCC", // ... X3XX
								 "CD", // ... X4XX
								 "D", // ... X5XX
								 "DC", // ... X6XX
								 "DCC", // ... X7XX
								 "DCCC", // ... X8XX
								 "CM" }, // ... X9XX

								{ "M", // ... 1XXX
								  "MM", // ... 2XXX
								  "MMM", // ... 3XXX
								  "MV" + "\u0305", // ... 4XXX
								  "V" + "\u0305", // ... 5XXX
								  "V" + "\u0305" + "M", // ... 6XXX
								  "V" + "\u0305" + "MM", // ... 7XXX
								  "V" + "\u0305" + "MMM", // ... 8XXX
								  "MX" + "\u0305" } // ... 9XXX

					         };

		int period = 1000, remYear = year, // Remaining year
				numPeriods, // Number of periods
				decExp; // Decade exponent
		for (decExp = 3; decExp > -1; decExp--) // Generate period substrings
		{
			numPeriods = remYear / period;
			switch (numPeriods)
			{
				case 0:
					break;
				case 1:
					romanYear.append(numerals[decExp][0]);
					break;
				case 2:
					romanYear.append(numerals[decExp][1]);
					break;
				case 3:
					romanYear.append(numerals[decExp][2]);
					break;
				case 4:
					romanYear.append(numerals[decExp][3]);
					break;
				case 5:
					romanYear.append(numerals[decExp][4]);
					break;
				case 6:
					romanYear.append(numerals[decExp][5]);
					break;
				case 7:
					romanYear.append(numerals[decExp][6]);
					break;
				case 8:
					romanYear.append(numerals[decExp][7]);
					break;
				case 9:
					romanYear.append(numerals[decExp][8]);
					break;
				default:
					break;
			}
			remYear = (remYear - numPeriods * period);
			period /= 10;
		}
		return romanYear.toString() + " " + era; // Conversion to output String
	}

}
