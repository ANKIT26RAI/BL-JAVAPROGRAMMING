//Printing
//1.System.out.println() - prints the text and moves to the next line
//2.System.out.print() - prints the text without moving to the next line
//3.System.out.printf() - prints formatted text     
//4.String.format() - returns a formatted string without printing it    

//Format Specifiers:
//%d - integer
//%f - floating-point number
//%s - string
//%c - character
//%n - new line
//Example:
//int age = 25;
//String name = "Alice";
//System.out.printf("Name: %s, Age: %d%n", name, age);

//  String:
// 1.String is a sequence of characters enclosed in double quotes.
// 2.Strings are immutable, meaning once created, they cannot be changed.
// 3.Strings can be concatenated using the + operator.
// 4.Strings can be compared using the equals() method for content comparison and == operator for reference comparison. 
//Example:
//  String str1 = "Hello";
//  String str2 = "World";
//  String str3 = str1 + " " + str2; // Concatenation
//  System.out.println(str3); // Output: Hello World

//Constructors for creating strings:
//1.String str = new String("Hello"); - creates a new string object with the value "Hello".
//2.String str = "Hello"; - creates a string literal, which may be interned by the Java compiler for memory efficiency. 
//Example:
//String str1 = new String("Hello");
//String str2 = "Hello";
//System.out.println(str1.equals(str2)); // Output: true (content comparison)

//Character Arrays:
//1.Characters can be stored in an array of type char[].    
//2.Characters in a char array can be accessed using their index, starting from 0.
//3.Char arrays can be converted to strings using the String constructor or the valueOf() method.
//Example:  
//char c[]={'H','e','l','l','o'};
//String str = new String(c); // Convert char array to string 

//new means creating a object in heap memory and returns the reference of that object.
//why do we need to create a new string object when we can use string literals?
//String literals are stored in a common pool and can be reused, which can save memory.
//However, using the new keyword allows you to create a new string object even if an identical string already exists in the pool, which can be useful in certain situations where you want to ensure that you have a distinct object reference.
//Example:
// String str1 = new String("Hello");
// String str2 = "Hello";
// System.out.println(str1 == str2); // Output: false (different references)
// System.out.println(str1.equals(str2)); // Output: true (content comparison) 



import java.util.Scanner;


// public class StringPrinting {
//     public static void main(String[] args) {
//         byte b[]={65,66,67,68,69};
//         String s=new String(b);
//         System.out.println(s); // Output: ABCDE
//     }
    
// }

// public class StringPrinting {
//     public static void main(String[] args) {
//         char c[]={'H','e','l','l','o'};
//         String s=new String(c);
//         System.out.println(s); // Output: Hello
//     }
    
// }


//String Methods:
//1.length() - returns the length of the string
//2.charAt(int index) - returns the character at the specified index
//3.substring(int beginIndex, int endIndex) - returns a substring from the specified beginIndex to endIndex-1
//4.toUpperCase() - converts the string to uppercase    
//5.toLowerCase() - converts the string to lowercase
//6.equals(Object obj) - compares the string with another object for content equality   
//7.equalsIgnoreCase(String anotherString) - compares the string with another string for content equality, ignoring case differences
//8.trim() - removes leading and trailing whitespace from the string
//9.replace(char oldChar, char newChar) - replaces all occurrences of oldChar with newChar in the string
//10.split(String regex) - splits the string into an array of substrings based on the specified regular expression
//11.contains(CharSequence s) - checks if the string contains the specified sequence of characters
//12.startsWith(String prefix) - checks if the string starts with the specified prefix  
//13.endsWith(String suffix) - checks if the string ends with the specified suffix
//14.indexOf(String str) - returns the index of the first occurrence of the specified substring in the string, or -1 if it is not found
//15.lastIndexOf(String str) - returns the index of the last occurrence of the specified substring in the string, or -1 if it is not found
//16.isEmpty() - checks if the string is empty (length is 0)
//17.concat(String str) - concatenates the specified string to the end of the current string
//18.format(String format, Object... args) - returns a formatted string using the specified format and arguments
//19.valueOf(Object obj) - returns the string representation of the specified object
//20.toCharArray() - converts the string to a char array

// public class StringPrinting {
//     public static void main(String[] args) {
//         String str = "Hello, World!";
//         System.out.println("Length of String: " + str.length()); // Output: 13
//         System.out.println("Character at index 7: " +  str.charAt(7)); // Output: W
//         System.out.println("Substring from index 0 to 5: "+ str.substring(0,5)); // Output: Hello
//         System.out.println(str.toUpperCase()); // Output: HELLO, WORLD!
//         System.out.println(str.toLowerCase()); // Output: hello, world!
//         System.out.println(str.equals("Hello, World!")); // Output: true
//         System.out.println(str.equalsIgnoreCase("hello, world!")); // Output: true
//         System.out.print(" hello world ".trim()); // Output: hello world
//         System.out.println(str.replace('o', 'x')); // Output: Hellx, Wxrld!
//         System.out.println(str.split(",")[0]); // Output: Hello
//         System.out.println(str.contains("World")); // Output: true
//         System.out.println(str.startsWith("Hello")); // Output: true
//         System.out.println(str.endsWith("!")); // Output: true  
//         System.out.println(str.indexOf("o")); // Output: 4
//         System.out.println(str.lastIndexOf("o")); // Output: 8  
//         System.out.println(str.isEmpty()); // Output: false
//         System.out.println(str.concat(" Welcome!")); // Output: Hello, World! Welcome!  
//         System.out.println(String.format("Formatted String: %s, Length: %d", str, str.length())); // Output: Formatted String: Hello, World!, Length: 13
//         System.out.println(String.valueOf(123)); // Output: 123
//         char[] charArray = str.toCharArray();
//         System.out.println(charArray); // Output: Hello, World!
//         System.out.println(str.toCharArray()); // Output: Hello, World!
//         System.out.println(str.toCharArray()[0]); // Output: H
//         System.out.println(str.toCharArray()[7]); // Output: W
//         System.out.println(str.toCharArray()[str.length() - 1]); // Output: !
//         System.out.println(str.toCharArray().length); // Output: 13
//         System.out.println(str.compareTo("Hello, World!")); // Output: 0 (strings are equal)
//         System.out.println(str.compareTo("Hello, World")); // Output: 1 (str is greater than the other string)
//         System.out.println(str.compareTo("Hello, World!!")); // Output: -1 (str is less than the other string)
//     }
// }


//Regular Expressions:
//1.Regular expressions are patterns used to match character combinations in strings.   
//2.Java provides the java.util.regex package for working with regular expressions.
//3.Pattern class is used to compile a regular expression into a pattern that can be used for matching.
//4.Matcher class is used to perform match operations on a character sequence using a pattern.
//Example:
// import java.util.regex.Pattern;
// import java.util.regex.Matcher;  
// public class StringPrinting {
//     public static void main(String[] args) {
//         String str = "Hello, World!";
//         String regex = "Hello,\\sWorld!"; // Regular expression to match the string
//         Pattern pattern = Pattern.compile(regex);
//         Matcher matcher = pattern.matcher(str);
//         if (matcher.matches()) {
//             System.out.println("The string matches the regular expression."); // Output: The string matches the regular expression.
//         } else { 
//             System.out.println("The string does not match the regular expression.");
//         }
//     }
// }    


//Matching Symbols in Regular Expressions:
//1. . (dot) - matches any single character except newline
//2. \d - matches any digit (0-9)
//3. \D - matches any non-digit character
//4. \s - matches any whitespace character
//5. \S - matches any non-whitespace character
//6. \w - matches any word character (alphanumeric or underscore)
//7. \W - matches any non-word character    
//8. [abc] - matches any one of the characters a, b, or c
//9. [^abc] - matches any character that is not a, b, or c
//10. (abc) - matches the exact sequence of characters "abc"    
//11. [abc][vw] - matches any two-character sequence where the first character is a, b, or c and the second character is v or w
//12. a{3} - matches exactly three occurrences of the character 'a' 
//13. a{3,} - matches three or more occurrences of the character 'a'
//14. a{3,5} - matches between three and five occurrences of the character 'a'
//15. a? - matches zero or one occurrence of the character 'a'  

// public class StringPrinting {
//     public static void main(String[] args) {
//         String str = "f";
//         System.out.println(str.matches("."));//true
//         String str1 ="ac";
//         String str2="AzD8";
//         System.out.println(str1.matches("[abc]"));//false
//         System.out.println(str.matches("[^abc]"));//true
//         System.out.println(str2.matches("[a-z0-9A-Z]+"));//true
//     }
// }


// Quantifiers in Regular Expressions:
//1. * - matches zero or more occurrences of the preceding element
//2. + - matches one or more occurrences of the preceding element
//3. ? - matches zero or one occurrence of the preceding element
//4. {n} - matches exactly n occurrences of the preceding element
//5. {n,} - matches n or more occurrences of the preceding element  
//6. {n,m} - matches between n and m occurrences of the preceding element
//Example:
// public class StringPrinting {

//     public static void main(String[] args) {
//         String str1 = "aaabbb";
//         String str2 = "abc";
//         String str3 = "a";
//         System.out.println(str1.matches("a*b*")); // Output: true (matches zero or more 'a' followed by zero or more 'b')
//         System.out.println(str2.matches("a+b+")); // Output: false (does not match one or more 'a' followed by one or more 'b')
//         System.out.println(str3.matches("a?")); // Output: true (matches zero or one occurrence of 'a')
//     }
// }


//Student Challenge:
//Find if the email id is on gmail or not .
//Find user and domain name from the email id.
// public class StringPrinting {
//     public static void main(String[] args) {
//         String email = "blamepause26@gmail.com";
//         if(email.endsWith("@gmail.com")) {
//             System.out.println("The email id is on gmail.");
//             String[] parts = email.split("@");
//             String userName = parts[0];
//             String domainName = parts[1];
//             System.out.println("User Name: " + userName); // Output: blamepause26
//             System.out.println("Domain Name: " + domainName); // Output: gmail.com
//         } else {
//             System.out.println("The email id is not on gmail.");
//         }
//     }
// }   


//Remove Special Characters from a String:
// public class StringPrinting {
//     public static void main(String[] args) {
//         String str = "H@e#l$l%o^&*()_+|}{\":?><,./;'[]\\=-`~";
//         String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", ""); // Remove special characters
//         System.out.println(cleanedStr); // Output: Hello
//     }
//}

//Remove Extra Spaces from a String:
// public class StringPrinting {
//     public static void main(String[] args) {
//         String str = "   Hello   World!   ";
//         String cleanedStr = str.trim().replaceAll("\\s+", " "); // Remove leading/trailing spaces and reduce multiple spaces to a single space
//         System.out.println(cleanedStr); // Output: Hello World!
//     }
// }

//Find number of words in a String using Regular Expressions:
// public class StringPrinting {
//     public static void main(String[] args) {
//         String str = "Hello, World! Welcome to Java programming.";
//         String[] words = str.split("\\s+"); // Split the string into words based on whitespace
//         System.out.println("Number of words: " + words.length); // Output: Number of words: 6
//     }
// }