/*
package numerals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import numerals.Numerals;

class NumeralsTest
{
	private Numerals numeralsTest;
	
	private String[] testYears = { 																			// Invalid input formats ...
			
								   "",																		// Blank input
								   "?",																		// Input char invalid & too short
								   "9BC", 																	// Input too short
								   "0 BC", 																	// Invalid year
								   "0 AD", 																	// Invalid year
								   "1 AB", 																	// Invalid era string
								   "1 A.D.", 																// Era has periods
								   "AD 12", 																// Era before year
								   "1 ad", 																	// Era lower case
								   "? BC",																	// Year has invalid char
								   "-157 BC", 																// Negative year
								   "33.3 BC", 																// Non-integer year
								   "10  BC",																// Double spacing before era
								   
								    																		// Valid formats ...
								   
								   "9 BC",																	// Low BC year & IX test				
								   "99 AD", 																// Low AD year & XCIX v IC test
								   "432 AD", 																// CD test
								   "999 AD", 																// CM test & XCIX test
								   "1001 AD", 																// MI test
								   "1492 AD", 																// MCD test
								   "1690 AD", 																// MDC test
								   "1789 AD", 																// Bastille test !
								   "1899 AD", 																// Just before MCM test
								   "1900 AD", 																// MCM test
								   "2018 AD", 																// This year test
								   "4018 AD", 																// MV-prime test
								   "5092 AD", 																// V-prime test
								   "8999 AD", 																// Just before MX-prime test
								   "9999 AD", 																// Just before X-prime test
								   
								   "11700 AD"																// Out of allowed range input
								   };									
	
	private String[] expecteds = { 																			// Invalid input formats ...
			 
								  "Invalid input !" + " Cause: " + "Empty string", 
								  "Invalid input !" + " Cause: " + "String too short",											
								  "Invalid input !" + " Cause: " + "String too short", 
								  "Invalid input !" + " Cause: " + "No year 0 BC or 0 AD",
								  "Invalid input !" + " Cause: " + "No year 0 BC or 0 AD",
								  "Invalid input !" + " Cause: " + "Era string wrong",
								  "Invalid input !" + " Cause: " + "Era string wrong",
								  "Invalid input !" + " Cause: " + "Era string wrong",
								  "Invalid input !" + " Cause: " + "Era string wrong",
								  "Invalid input !" + " Cause: " + "Year in wrong format",
								  "Invalid input !" + " Cause: " + "Negative year",
								  "Invalid input !" + " Cause: " + "Year in wrong format",
								  "Invalid input !" + " Cause: " + "More than 1 space before era",
			   
																											// Valid formats ...
								  
								  "IX BC", 																	// 9 BC										
								  "XCIX AD", 																// 99 AD
								  "CDXXXII AD", 															// 432 AD
								  "CMXCIX AD", 																// 999 AD
								  "MI AD", 																	// 1001 AD
								  "MCDXCII AD", 															// 1492 AD
								  "MDCXCII AD", 															// 1692 AD
								  "MDCCLXXXIX AD", 															// 1789 AD
								  "MDCCCXCIX AD", 															// 1899 AD
								  "MCM AD", 																// 1900 AD						
								  "MMXVIII AD", 															// 2018 AD
								  "MV" + "\u0305" + "XVIII AD", 											// 4018 AD
								  "V" + "\u0305"  + "XCII AD", 												// 5092 AD
								  "V" + "\u0305"  + "MMMXCII AD", 											// 8092 AD
								  "MX" + "\u0305" + "XCIX",													// 9999 AD
								  																			// Out of range input
								  "Invalid input !" + " Cause: " + "Year out of range" 		
								};	
	
	private String yearString,																				// Global parameters for setUp() ...
				   expected;																				// ... and Test() methods
	
	
	@BeforeEach
	void setUp() 												
	{
		
	}
	
	@Test
	void testAllGetRomanYears()
	{
		
		for(int i = 0; i < testYears.length; i++)
		{
			yearString = testYears[i];
			expected = expecteds[i];
			
			try																				
			{
				numeralsTest = new Numerals(yearString);
			}
			catch(Exception iae)
			{
				assertEquals(expected, iae.getMessage() + " Cause: " + iae.getCause().getMessage());		// Invalid input string tests ...
				return;
			}

			testGetRomanYear(yearString, expected);															// Invalid output string tests ...
		}
	}

		
	
	void testGetRomanYear(String yearString, String expected)
	{
		assertTrue(expected.equals(numeralsTest.calcRomanYear()));											// Invalid output string tests ...
	}
	
}
*/
