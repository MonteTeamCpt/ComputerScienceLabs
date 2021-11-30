import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.stream.IntStream;

public class Student implements Comparable<Student>
{
	private int id;
	private String name;
	private int grade;
	private double gpa;
	
	public Student(int id, String name, int grade, double gpa)
	{
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.gpa = gpa;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public int getGrade()
	{
		return grade;
	}

	public double getGpa()
	{
		return gpa;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return this.getId() == ((Student)obj).getId();
	}
	
	public int compareTo(Student other)
	{
		return this.getName().compareTo(((Student)other).getName());
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.lang.String#charAt(int)
	 */
	public char charAt(int arg0)
	{
		return name.charAt(arg0);
	}

	/**
	 * @return
	 * @see java.lang.CharSequence#chars()
	 */
	public IntStream chars()
	{
		return name.chars();
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.lang.String#codePointAt(int)
	 */
	public int codePointAt(int arg0)
	{
		return name.codePointAt(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.lang.String#codePointBefore(int)
	 */
	public int codePointBefore(int arg0)
	{
		return name.codePointBefore(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @return
	 * @see java.lang.String#codePointCount(int, int)
	 */
	public int codePointCount(int arg0, int arg1)
	{
		return name.codePointCount(arg0, arg1);
	}

	/**
	 * @return
	 * @see java.lang.CharSequence#codePoints()
	 */
	public IntStream codePoints()
	{
		return name.codePoints();
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.lang.String#compareTo(java.lang.String)
	 */
	public int compareTo(String arg0)
	{
		return name.compareTo(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.lang.String#compareToIgnoreCase(java.lang.String)
	 */
	public int compareToIgnoreCase(String arg0)
	{
		return name.compareToIgnoreCase(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.lang.String#concat(java.lang.String)
	 */
	public String concat(String arg0)
	{
		return name.concat(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.lang.String#contains(java.lang.CharSequence)
	 */
	public boolean contains(CharSequence arg0)
	{
		return name.contains(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.lang.String#contentEquals(java.lang.CharSequence)
	 */
	public boolean contentEquals(CharSequence arg0)
	{
		return name.contentEquals(arg0);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.lang.String#contentEquals(java.lang.StringBuffer)
	 */
	public boolean contentEquals(StringBuffer arg0)
	{
		return name.contentEquals(arg0);
	}

	/**
	 * @param suffix
	 * @return
	 * @see java.lang.String#endsWith(java.lang.String)
	 */
	public boolean endsWith(String suffix)
	{
		return name.endsWith(suffix);
	}

	/**
	 * @param anotherString
	 * @return
	 * @see java.lang.String#equalsIgnoreCase(java.lang.String)
	 */
	public boolean equalsIgnoreCase(String anotherString)
	{
		return name.equalsIgnoreCase(anotherString);
	}

	/**
	 * @return
	 * @see java.lang.String#getBytes()
	 */
	public byte[] getBytes()
	{
		return name.getBytes();
	}

	/**
	 * @param charset
	 * @return
	 * @see java.lang.String#getBytes(java.nio.charset.Charset)
	 */
	public byte[] getBytes(Charset charset)
	{
		return name.getBytes(charset);
	}

	/**
	 * @param srcBegin
	 * @param srcEnd
	 * @param dst
	 * @param dstBegin
	 * @deprecated
	 * @see java.lang.String#getBytes(int, int, byte[], int)
	 */
	public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin)
	{
		name.getBytes(srcBegin, srcEnd, dst, dstBegin);
	}

	/**
	 * @param charsetName
	 * @return
	 * @throws UnsupportedEncodingException
	 * @see java.lang.String#getBytes(java.lang.String)
	 */
	public byte[] getBytes(String charsetName) throws UnsupportedEncodingException
	{
		return name.getBytes(charsetName);
	}

	/**
	 * @param srcBegin
	 * @param srcEnd
	 * @param dst
	 * @param dstBegin
	 * @see java.lang.String#getChars(int, int, char[], int)
	 */
	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
	{
		name.getChars(srcBegin, srcEnd, dst, dstBegin);
	}

	/**
	 * @return
	 * @see java.lang.String#hashCode()
	 */
	public int hashCode()
	{
		return name.hashCode();
	}

	/**
	 * @param ch
	 * @param fromIndex
	 * @return
	 * @see java.lang.String#indexOf(int, int)
	 */
	public int indexOf(int ch, int fromIndex)
	{
		return name.indexOf(ch, fromIndex);
	}

	/**
	 * @param ch
	 * @return
	 * @see java.lang.String#indexOf(int)
	 */
	public int indexOf(int ch)
	{
		return name.indexOf(ch);
	}

	/**
	 * @param str
	 * @param fromIndex
	 * @return
	 * @see java.lang.String#indexOf(java.lang.String, int)
	 */
	public int indexOf(String str, int fromIndex)
	{
		return name.indexOf(str, fromIndex);
	}

	/**
	 * @param str
	 * @return
	 * @see java.lang.String#indexOf(java.lang.String)
	 */
	public int indexOf(String str)
	{
		return name.indexOf(str);
	}

	/**
	 * @return
	 * @see java.lang.String#intern()
	 */
	public String intern()
	{
		return name.intern();
	}

	/**
	 * @return
	 * @see java.lang.String#isEmpty()
	 */
	public boolean isEmpty()
	{
		return name.isEmpty();
	}

	/**
	 * @param ch
	 * @param fromIndex
	 * @return
	 * @see java.lang.String#lastIndexOf(int, int)
	 */
	public int lastIndexOf(int ch, int fromIndex)
	{
		return name.lastIndexOf(ch, fromIndex);
	}

	/**
	 * @param ch
	 * @return
	 * @see java.lang.String#lastIndexOf(int)
	 */
	public int lastIndexOf(int ch)
	{
		return name.lastIndexOf(ch);
	}

	/**
	 * @param str
	 * @param fromIndex
	 * @return
	 * @see java.lang.String#lastIndexOf(java.lang.String, int)
	 */
	public int lastIndexOf(String str, int fromIndex)
	{
		return name.lastIndexOf(str, fromIndex);
	}

	/**
	 * @param str
	 * @return
	 * @see java.lang.String#lastIndexOf(java.lang.String)
	 */
	public int lastIndexOf(String str)
	{
		return name.lastIndexOf(str);
	}

	/**
	 * @return
	 * @see java.lang.String#length()
	 */
	public int length()
	{
		return name.length();
	}

	/**
	 * @param regex
	 * @return
	 * @see java.lang.String#matches(java.lang.String)
	 */
	public boolean matches(String regex)
	{
		return name.matches(regex);
	}

	/**
	 * @param index
	 * @param codePointOffset
	 * @return
	 * @see java.lang.String#offsetByCodePoints(int, int)
	 */
	public int offsetByCodePoints(int index, int codePointOffset)
	{
		return name.offsetByCodePoints(index, codePointOffset);
	}

	/**
	 * @param ignoreCase
	 * @param toffset
	 * @param other
	 * @param ooffset
	 * @param len
	 * @return
	 * @see java.lang.String#regionMatches(boolean, int, java.lang.String, int, int)
	 */
	public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)
	{
		return name.regionMatches(ignoreCase, toffset, other, ooffset, len);
	}

	/**
	 * @param toffset
	 * @param other
	 * @param ooffset
	 * @param len
	 * @return
	 * @see java.lang.String#regionMatches(int, java.lang.String, int, int)
	 */
	public boolean regionMatches(int toffset, String other, int ooffset, int len)
	{
		return name.regionMatches(toffset, other, ooffset, len);
	}

	/**
	 * @param oldChar
	 * @param newChar
	 * @return
	 * @see java.lang.String#replace(char, char)
	 */
	public String replace(char oldChar, char newChar)
	{
		return name.replace(oldChar, newChar);
	}

	/**
	 * @param target
	 * @param replacement
	 * @return
	 * @see java.lang.String#replace(java.lang.CharSequence, java.lang.CharSequence)
	 */
	public String replace(CharSequence target, CharSequence replacement)
	{
		return name.replace(target, replacement);
	}

	/**
	 * @param regex
	 * @param replacement
	 * @return
	 * @see java.lang.String#replaceAll(java.lang.String, java.lang.String)
	 */
	public String replaceAll(String regex, String replacement)
	{
		return name.replaceAll(regex, replacement);
	}

	/**
	 * @param regex
	 * @param replacement
	 * @return
	 * @see java.lang.String#replaceFirst(java.lang.String, java.lang.String)
	 */
	public String replaceFirst(String regex, String replacement)
	{
		return name.replaceFirst(regex, replacement);
	}

	/**
	 * @param regex
	 * @param limit
	 * @return
	 * @see java.lang.String#split(java.lang.String, int)
	 */
	public String[] split(String regex, int limit)
	{
		return name.split(regex, limit);
	}

	/**
	 * @param regex
	 * @return
	 * @see java.lang.String#split(java.lang.String)
	 */
	public String[] split(String regex)
	{
		return name.split(regex);
	}

	/**
	 * @param prefix
	 * @param toffset
	 * @return
	 * @see java.lang.String#startsWith(java.lang.String, int)
	 */
	public boolean startsWith(String prefix, int toffset)
	{
		return name.startsWith(prefix, toffset);
	}

	/**
	 * @param prefix
	 * @return
	 * @see java.lang.String#startsWith(java.lang.String)
	 */
	public boolean startsWith(String prefix)
	{
		return name.startsWith(prefix);
	}

	/**
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 * @see java.lang.String#subSequence(int, int)
	 */
	public CharSequence subSequence(int beginIndex, int endIndex)
	{
		return name.subSequence(beginIndex, endIndex);
	}

	/**
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 * @see java.lang.String#substring(int, int)
	 */
	public String substring(int beginIndex, int endIndex)
	{
		return name.substring(beginIndex, endIndex);
	}

	/**
	 * @param beginIndex
	 * @return
	 * @see java.lang.String#substring(int)
	 */
	public String substring(int beginIndex)
	{
		return name.substring(beginIndex);
	}

	/**
	 * @return
	 * @see java.lang.String#toCharArray()
	 */
	public char[] toCharArray()
	{
		return name.toCharArray();
	}

	/**
	 * @return
	 * @see java.lang.String#toLowerCase()
	 */
	public String toLowerCase()
	{
		return name.toLowerCase();
	}

	/**
	 * @param locale
	 * @return
	 * @see java.lang.String#toLowerCase(java.util.Locale)
	 */
	public String toLowerCase(Locale locale)
	{
		return name.toLowerCase(locale);
	}

	/**
	 * @return
	 * @see java.lang.String#toUpperCase()
	 */
	public String toUpperCase()
	{
		return name.toUpperCase();
	}

	/**
	 * @param locale
	 * @return
	 * @see java.lang.String#toUpperCase(java.util.Locale)
	 */
	public String toUpperCase(Locale locale)
	{
		return name.toUpperCase(locale);
	}

	/**
	 * @return
	 * @see java.lang.String#trim()
	 */
	public String trim()
	{
		return name.trim();
	}

	@Override
	public String toString()
	{
		return "Student [id=" + id + ", name=" + name + ", grade=" + grade + ", gpa=" + gpa + "]";
	}
}
