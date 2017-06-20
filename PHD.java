/**NetIds: jz674, aam252. Time spend: 4 hours
 * An instance maintains info about the PHD of a person. */

//We have checked the Javadoc output and it was OK

public class PHD {
	private String name; // name of the person with a PHD, a String of length >0
	private char gender; // gender of the person. 'f' for female and 'm' for male.
	private int year; // year PHD was awarded. 
	private int month; // month PHD was awarded. Ranges 1...12 with 1 being Jan, etc
	private PHD advis1; //1st PHD advisor of this person. Null if unknown
	private PHD advis2; // 2nd PHD advisor of this person. Null if unknown or only had 
								//one advisor or advis1= null
	private int advisees; // number of advisees of this person

	/**Constructor: an instance for a person with name n, gender g, PHD year y,
  	and PHD month m. Its advisors are unknown, and it has no advisees.
	Precondition: n has at least 1 char. m is in 1..12. g is 'f' for female or 'm' for male*/
	public PHD(String n, char g, int y, int m) {
		assert n != null;
		assert 1 <= n.length();
		assert (1<= m && m<=12);
		assert g == 'f' || g == 'm';
		name = n;
		gender = g;
		year = y;
		month = m;
		advis1 = null;
		advis2 = null;
		advisees = 0;

	}
	
	/**Constructor: a PHD with name n, gender g, PHD year y, PHD month m,
 	first advisor adv, and no second advisor.
 	Precondition: n has at least 1 char, g is 'f' for female or 'm' for male,
 	m is in 1..12, and adv is not null */
	public PHD(String n, char g, int y, int m, PHD adv) {
		assert n != null;
		assert 1 <= n.length();
		assert (g == 'f') || (g == 'm');
		assert (1<= m && m<=12);
		assert adv != null;
		name = n;
		gender = g;
		year = y;
		month = m;
		advis1 = adv;
		advis2 = null;
		advisees = 0;
		adv.advisees = adv.advisees + 1;
	}
	
	/**Constructor: a PHD with name n, gender g, PHD year y, PHD month m,
 	first advisor adv1, and second advisor adv2.
	Precondition: n has at least 1 char. g is 'f' for female or 'm' for male.
	m is in 1..12. adv1 and adv2 are not null. adv1 and adv2 are different. */
	public PHD(String n, char g, int y, int m, PHD adv1, PHD adv2) {
		assert n != null;
		assert 1 <= n.length();
		assert (g == 'f') || (g == 'm');
		assert (1<= m && m<=12);
		assert adv1 != null;
		assert adv2 != null;
		assert adv1 != adv2;
		name = n;
		gender = g;
		year = y;
		month = m;
		advis1 = adv1;
		advis2 = adv2;
		advisees = 0;
		adv1.advisees = adv1.advisees + 1;
		adv2.advisees = adv2.advisees + 1;
	}

	/**return the person's name */
	public String getName() {
		return name;
	}
	/** return the year PHD was awarded **/
	public int getYear() {
		return year;
	}
	/** Return the month this person got their PHD. */
	public int getMonth() {
		return month;
	}
	
	/** Return the value of the sentence "This person is male." */
	public boolean isMale() {
		return gender == 'm';
	}
	
	/**  Return the first advisor of this PHD (null if unknown). */
	public PHD advisor1() {
		return advis1;
	}
	
	/** Return the second advisor of this PHD (null if unknown or
		non-existent).*/
	public PHD advisor2() {
		return advis2;
	}
	
	/** Return the number of PHD advisees of this person */
	public int numAdivses() {
		return advisees;
	}
	
	/** Add p as the first advisor of this person.
	Precondition: the first advisor is unknown and p is not null. */
	public void setAdvisor1(PHD p) {
		assert p != null;
		assert advis1 == null;
		advis1 = p;
		p.advisees = p.advisees + 1;
		
	}
	
	/**Add p as the second advisor of this person.
	Precondition: The first advisor (of this person) is known, the second advisor
	is unknown, p is not null, and p is different from the first advisor.*/
	public void setAdvisor2(PHD p) {
		assert p != null;
		assert advis1 != null;
		assert advis2 == null;
		advis2 = p;
		p.advisees = p.advisees + 1;

	}

	/**Return value of "this person got their PHD before p did."
	Precondition: p is not null.*/
	public boolean gotBefore(PHD p) {
		assert p != null;
		return (p.year > year) || (p.year == year && p.month > month); 
	}
		
	/**Return value of "p is not null and this person and p are
	intellectual siblings." */
	public boolean arePHDSiblings(PHD p) {
		return (p!= null) && (this!=p) && (p.advis1==advis1 && p.advis1 != null && 
																			advis1==null) || 
			(p.advis2==advis1 && p.advis2!=null && advis1!=null) || 
			(p.advis1==advis2 && p.advis1!=null && advis2!=null)|| 
			(p.advis2==advis2 && p.advis2!=null && advis2!=null);
	
	}

}
