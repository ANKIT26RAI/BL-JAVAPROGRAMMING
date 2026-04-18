// Program to Check Palindrome String 
// Problem Statement:  Create a PalindromeChecker class with an attribute text. Add 
// methods to: 
// ● Check if the text is a palindrome. 
// ● Display the result. 
// Explanation: The PalindromeChecker class holds the text attribute. The methods 
// operate on this attribute to verify its palindrome status and display the result.
// class PalindromeChecker {
//     String text;
//     PalindromeChecker(String text) {
//         this.text = text;
//     }
//     boolean isPalindrome(){
//         int i=0;
//         int j= text.length()-1;
//         while(i<j){
//             if(text.charAt(i)!=text.charAt(j)){
//                 return false;
//             }else{
//                 i++;
//                 j--;
//             }

//         }
//         return true;
//     }
//     void displayResult(){
//         if(isPalindrome()){
//             System.out.println(text + " is a palindrome.");
//         }else{
//             System.out.println(text + " is not a palindrome.");
//         }
//     }
// }
// public class Palindrome {
//     public static void main(String[] args) {
//         PalindromeChecker checker = new PalindromeChecker("racecar");
//         checker.displayResult();
//     }
// }
