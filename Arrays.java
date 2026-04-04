//Array means all data is stored in a contiguous block of memory. This allows for fast access to elements in the array, but it also means that the size of the array must be specified at the time of creation and cannot be changed later.
//Arrays is a utility class that provides various methods for manipulating arrays, such as sorting and searching. It also provides methods for converting arrays to lists and vice versa. The Arrays class is part of the java.util package and is available in Java 1.2 and later versions.    
//Arrays is a class that contains methods for manipulating arrays. It is part of the java.util package and provides various methods for sorting, searching, and manipulating arrays. The Arrays class also provides methods for converting arrays to lists and vice versa. The Arrays class is available in Java 1.2 and later versions.    

//how to declare an array in java
//To declare an array in Java, you can use the following syntax:
//dataType[] arrayName; // Preferred way
//or
//dataType arrayName[]; // Also valid, but less common
//For example, to declare an array of integers, you can use:
//int[] myArray; // Preferred way
//or
//int myArray[]; // Also valid, but less common
//To create an array, you can use the following syntax:
//arrayName = new dataType[arraySize];        
//For example, to create an array of integers with a size of 5, you can use:
//myArray = new int[5];
//You can also combine the declaration and creation of an array in a single line:   
//int[] myArray = new int[5]; // Preferred way
//or        
//int myArray[] = new int[5]; // Also valid, but less common
//You can also initialize an array with values at the time of declaration:  
//int[] myArray = {1, 2, 3, 4, 5}; // Preferred way
//or
//int myArray[] = {1, 2, 3, 4, 5}; // Also valid, but less common
//In this example, we declare and initialize an array of integers with the values 1, 2, 3, 4, and 5.    

// public class Arrays {
//     public static void main(String[] args){
//         int[] myArray = {1,2,3,4,5};
//         int n = myArray.length; // length of the array
//         System.out.println("Length of the array: " + n);
//         // Accessing elements of the array
//         System.out.println("First element: " + myArray[0] );
//         System.out.println("Second element: " + myArray[1] );
//         System.out.println("Third element: " + myArray[2] );
//         System.out.println("Fourth element: " + myArray[3] );
//         System.out.println("Fifth element: " + myArray[4] );
//     // Accessing an element that is out of bounds will throw an ArrayIndexOutOfBoundsException
//         // System.out.println(myArray[5]); // This will throw an exception  
//     // Modifying elements of the array
//         myArray[0] = 10; // Change the first element to 10
//         myArray[4] = 20; // Change the second element to 20
//     //Printning the modified array
//     for(int i=0;i<n;i++){
//         System.out.print(myArray[i] + " "); 

//     }
// }
// }

//Taking input from the user to create an array and print its elements
// import java.util.Scanner;
// public class Arrays{
//     public static void main(String[] args) {
//         Scanner sc= new Scanner(System.in);
//         System.out.print("Enter the length of Array : ");
//         int n = sc.nextInt();
//         int[] arr=  new int[n];
//         for(int i=0;i<n;i++){
//             System.out.print("Enter the element at index " + i + " : ");
//             arr[i] = sc.nextInt();
            
//         }
//         System.out.println("The elements of the array are:");
//         for(int i=0;i<n;i++){
//             System.out.print(arr[i] + " ");
//         }
//     }
// }


// //Sum of all elements in an array
// import java.util.Scanner;
// public class Arrays {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the length of Array : ");
//         int n = sc.nextInt();
//         int[] arr = new int[n];

//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         int sum =0;
//         for(int x :arr){
//             sum+=x;
//         }
//         System.out.print(sum);
//     }
// }

// import java.util.Scanner;
// public class Arrays{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the length of Array : ");
//         int n = sc.nextInt();
//         int[] arr= new int[n];
//         int sum=0;
//         for(int i=0;i<n;i++){
//             arr[i]= sc.nextInt();
//             sum+=arr[i];
//         }
//         System.out.print("Sum of all elements of array are : " + sum);

//     }
// }

//Searching an Elenment in array.
// import java.util.Scanner;
// public class Arrays{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the length of array : ");
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         for(int i=0;i<n;i++){
//             arr[i] = sc.nextInt();
//         }
//         System.out.print("Enter the element to search : ");
//         int key = sc.nextInt();
//         boolean found = false;
//         int index = -1;
//         for(int i=0;i<n;i++){
//             if(arr[i]==key){
//             index = i;
//             found = true;
//             break;    
//         }
//     }
//     if(!found){
//         System.out.print("Element not found"  );
//     }else{
//         System.out.print("Element found at index : " + index);
//     }
// }
// }


//Finding the maximum and minimum element in an array
// import java.util.Scanner;
// public class Arrays{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the length of Array : ");
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         int max = arr[0];
//         int min = arr[0];
//         for(int i=1;i<n;i++){
//             if(arr[i]>max){
//                 max = arr[i];
//             }
//             if(arr[i]<min){
//                 min = arr[i];
//             }
//         }
//         System.out.print("Maximum element in the array is : " + max);
//         System.out.print("\nMinimum element in the array is : " + min);

//         sc.close();
//     }
// }

//Second largest element in an array
// import java.util.Scanner;
// public class Arrays{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the length of arrays: ");
//         int n= sc.nextInt(); 
//         int[] arr = new int[n];
//         int max1= arr[0];
//         int max2 = Integer.MIN_VALUE;
//          for(int i=0;i<n;i++){
//              arr[i]= sc.nextInt();
//          }
//         for(int i=1;i<n;i++){
//             if(arr[i]>max1){
//                 max2= max1;
//                 max1= arr[i];
//             }else if (arr[i]>max2){
//                 max2=arr[i];

//             }
//         }
//         System.out.print("Second largest element in the array is : " + max2);
//         sc.close();
//     }
// }

//Rotate the the array .
// import java.util.*;
// public class Arrays{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the length of arr :");
//         int n= sc.nextInt();
//         int[] arr = new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }

//         int left = 0;
//         int right =n-1;
//         while(left<right){
//             int temp = arr[left];
//             arr[left]=arr[right];
//             arr[right]=temp;
//         left++;
//         right--;
//         }

//         for(int x: arr){
//             System.out.print(x + " ");
//         }
//         sc.close();

//     }
// }

//Finding the average of all elements in an array
// import java.util.Scanner;
// public class Arrays{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n;
//         System.out.print("Enter the length of array : ");
//         n = sc.nextInt();
//         int[] arr = new int[n]; 
//         int sum=0;
//         for(int i=0;i<n;i++){
//            arr[i]=sc.nextInt();
//             sum+=arr[i];
//         }

//         System.out.println("The average of all element in array is : " + sum/n);
//         sc.close();
        
//     }
// }

//2-D array in java
//we can declare a 2-D array in java using the following syntax:
//dataType[][] arrayName; // Preferred way
//or
//dataType arrayName[][]; // Also valid, but less common
//For example, to declare a 2-D array of integers, you can use:
//int[][] myArray; // Preferred way
//or
//int myArray[][]; // Also valid, but less common
//To create a 2-D array, you can use the following syntax:
//arrayName = new dataType[rows][columns];  
//For example, to create a 2-D array of integers with 3 rows and 4 columns, you can use:
//myArray = new int[3][4];
//You can also combine the declaration and creation of a 2-D array in a single line:
//int[][] myArray = new int[3][4]; // Preferred way
//or
//int myArray[][] = new int[3][4]; // Also valid, but less
//Lets code: a 2-D array in java and print its elements
// import java.util.Scanner;
// public class Arrays {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner (System.in);
//         System.out.print("Enter the number of rows : ");
//         int rows = sc.nextInt();
//         System.out.print("Enter the number of columns : ");
//         int cols = sc.nextInt();
//         int[][] arr = new int[rows][cols];
//         System.out.println("Enter the elements of the array : ");
//         for(int i=0;i<rows;i++){
//             for(int j=0;j<cols;j++){
//                 arr[i][j]=sc.nextInt();
//             }
//         }
//         System.out.println("The elements of the array are : ");
//         for(int i=0;i<rows;i++){
//             for(int j=0;j<cols;j++){
//                 System.out.print(arr[i][j] + " ");
//             }
//             System.out.println();
//         }
//         sc.close();

//     }
// }

//Finding the sum of all elements in a 2-D array
// import java.util.Scanner;
// public class Arrays{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int rows;
//         System.out.print("Enter the rows of arrays : ");
//         rows = sc.nextInt();
//         int column;
//         System.out.print("Enter the column of arrays :");
//         column = sc.nextInt();
//         int[][] arr = new int[rows][column];
//         for(int i=0;i<rows;i++){
//             for(int j=0;j<column;j++){
//                 arr[i][j]=sc.nextInt();
//             }
//         }
//         int sum =0;
//         for(int i=0;i<rows;i++){
//             for(int j=0;j<column;j++){
//                 sum+=arr[i][j];
//             }
//         } 
//         System.out.print("Sum of all elements in array are : " + sum);
//     }
// }

//Find even and odd elements in a array.
// import java.util.Scanner;
// public class Arrays{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the length of arr :");
//         int n = sc.nextInt();
//         int[] arr= new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }

//         int even =0; int odd =0;
//         for(int i=0;i<n;i++){
//             if(arr[i]%2==0){
//                 even++;
//             }else{
//                 odd++;
//             }
//         }

//         System.out.println("Even Elements Count "+ even);
//         System.out.println("Odd Elements Count "+  odd);
//         sc.close();
//     }
// }


//Second smallest element in an array
// import java.util.Scanner;
// public class Arrays{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
        
//         int n= sc.nextInt();
//         int[] arr = new int[n];
//         for(int i=0;i<n;i++){
//             arr[i] = sc.nextInt();
//         }
//         int smallest = arr[0];
//         int secondSmallest = Integer.MAX_VALUE;
//         for(int i=1;i<n;i++){
//             if(arr[i]<smallest){
//                 secondSmallest = smallest;
//                 smallest = arr[i];
//             }else if(arr[i]<secondSmallest && arr[i]!=smallest){
//                 secondSmallest = arr[i];

//             }

//         }
//         if(secondSmallest == Integer.MAX_VALUE){
//             System.out.print("There is no second smallest element in the array.");
//         }else{
//             System.out.print("Second smallest element in the array is : " + secondSmallest);
//         }
//         sc.close();
//     }
// }

//Finding the frequency of each element in an array not sorted using loop.
// import java.util.Scanner;
// public class Arrays{
//     public static void main(String[] args) {
//         Scanner sc= new Scanner(System.in);
//         System.out.print("Enter the length of arr :");
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         Boolean[] visited = new Boolean[n];
//         System.out.println("Frequency of each element in the array : ");
//         for(int i=0;i<n;i++){
//             if(visited[i]==null || visited[i]==false){
//                 int count =1;
//                 for(int j=i+1;j<n;j++){
//                     if(arr[i]==arr[j]){
//                         count++;
//                         visited[j]=true;
//                     }
//                 }
//                 System.out.println(arr[i] + " : " + count);
//             }
//         }
//     }
// }

//Check if array is sorted or not
// import java.util.Scanner;
// public class Arrays {

//      public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         boolean sorted = true;
//         for(int i=0;i<n-1;i++){
//             if(arr[i]>arr[i+1]){
//                 sorted = false;
//                 break;
//             }
//         }

//         if(!sorted){
//             System.out.println("Array is not Sorted .");
//         }else{
//             System.out.println("Array is Sorted true");
//         }

//         sc.close();

//      }
// }

//Rotate the array to the left by one position
// import java.util.Scanner;
// public class Arrays{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the length of the array :");
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]= sc.nextInt();
//         }
//         int temp=arr[0];
//         for(int i=0;i<n-1;i++){
//             arr[i]=arr[i+1];
//         }
//         arr[n-1]= temp;
//         System.out.println("Array after rotation by 1 position : ");
//         for(int x:arr){
//             System.out.print(x +" ");
//         }
//         sc.close();
//     }
// }


//Rotate the array to the right by one position
// import java.util.Scanner;
// public class Arrays{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the length of array : ");
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i=0;i<n;i++){
//         arr[i]=sc.nextInt();
//        }
//        int temp =arr[n-1];
//        for(int i = n-1;i>0;i--){
//         arr[i]=arr[i-1];
//        }
//        arr[0]=temp;
//          System.out.println("Array after rotation by 1 position : ");
//          for(int x:arr){
//              System.out.print(x +" ");
//          }
//          sc.close();

//     }

// }


//Find the missing number in an array of size n-1 containing numbers from 1 to n
// import java.util.Scanner;
// public class Arrays{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the length of array");
//         int n= sc.nextInt();
//         int sum = n*(n+1)/2;
//         int[] arr= new int[n-1];
//         for(int i=0;i<n-1;i++){
//             arr[i]=sc.nextInt();
//         }
//         int sumOfElements =0;
//         for(int x:arr){
//             sumOfElements+=x;
//         }
//         int missingNumber = sum - sumOfElements;
//         System.out.print("The missing number in the array is : " + missingNumber);
//             sc.close();

//     }
// }

// //Merge two arrays into a single array.
// import java.util.Scanner;
// public class Arrays {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the length of arr 1 : ");
//         int n = sc.nextInt();
//         int[] arr1= new int[n];

//         for(int i=0;i<n;i++){
//             arr1[i]=sc.nextInt();
//         }
//         System.out.print("Enter the length of arr 2 :");
//         int m = sc.nextInt();
//         int[] arr2  = new int[m];
//         for(int i=0;i<m;i++){
//             arr2[i]=sc.nextInt();
//         }
//         int[] mergeArr = new int[n+m];
//         int j=0;
//         for(int i=0;i<n;i++){
//             mergeArr[j++]=arr1[i];
//         }
//         for(int k=0;k<m;k++){
//            mergeArr[j++]=arr2[k];
//         }

//         for(int x:mergeArr){
//             System.out.print(x + " ");
//         }
//         sc.close();

        
//     }
// }


//Find the pair of elements in an array whose sum is equal to a given target value
// import java.util.Scanner;
// public class Arrays {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the length of arr : ");
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.nextInt();
//         }
//         System.out.print("Enter the target value : ");
//         int k = sc.nextInt();
//         boolean found = false;
//         for(int i=0;i<n-1;i++){
//             for(int j=i+1;j<n;j++){
//                 if(arr[i]+arr[j]==k){
//                     System.out.print("Pair : "+ "( "+arr[i] +" , "+arr[j]+" )");
//                     found = true;
//                 }
//             }
//         }
//         if(!found){
//             System.out.print("No pair found with the given target value.");
//         }
//         sc.close();
//     }
// }

//Find Transpose of a matrix
// import java.util.Scanner;
// public class Arrays{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the number of rows  : ");
//         int rows = sc.nextInt();
//         System.out.print("Enter the number of columns : ");
//         int cols= sc.nextInt();
//         int[][] arr = new int[rows][cols];
//         System.out.println("Enter the elements of Matrix : " );
//         for(int i = 0;i<rows;i++){
//             for(int j=0;j<cols;j++){
//                 arr[i][j] = sc.nextInt();
//             }
//         }

//         int[][] trans = new int[cols][rows];
//         for(int i =0;i<rows;i++){
//             for(int j=0;j<cols;j++){
//                 trans[j][i]=arr[i][j];
//             }
//         }
        
//         System.out.println("Transpose of the matrix is : ");
//         for(int i=0;i<cols;i++){
//             for(int j=0;j<rows;j++){
//                 System.out.print(trans[i][j] + " ");    
//             }
//             System.out.println();
//         }
//         sc.close();
//     }
// }

//Multiply two matrices
// import java.util.Scanner;
// public class Arrays{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the number of rows of matrix 1 : ");
//         int rows1 = sc.nextInt();
//         System.out.print("Enter the number of columns of matrix 1 : ");
//         int cols1 = sc.nextInt();
//         int[][] matrix1 = new int[rows1][cols1];
//         System.out.println("Enter the elements of matrix 1 : ");
//         for(int i=0;i<rows1;i++){
//             for(int j=0;j<cols1;j++){
//                 matrix1[i][j]=sc.nextInt();
//             }
//         }
//         System.out.print("Enter the number of rows of matrix 2 : ");
//         int rows2 = sc.nextInt();   
//         System.out.print("Enter the number of columns of matrix 2 : ");
//         int cols2 = sc.nextInt();
//         if(cols1!=rows2){
//             System.out.print("Matrix multiplication is not possible.");
//             sc.close();
//             return;
//         }
//         int[][] matrix2 = new int[rows2][cols2];
//         System.out.println("Enter the elements of matrix 2 : ");
//         for(int i=0;i<rows2;i++){
//             for(int j=0;j<cols2;j++){
//                 matrix2[i][j]=sc.nextInt();
//             }
//         }
//         int[][] result = new int[rows1][cols2];
//         for(int i=0;i<rows1;i++){
//             for(int j=0;j<cols2;j++){
//                 for(int k=0;k<cols1;k++){
//                     result[i][j]+=matrix1[i][k]*matrix2[k][j];
//                 }
//             }
//         }
//         System.out.println("Result of matrix multiplication is : ");
//         for(int i=0;i<rows1;i++){
//             for(int j=0;j<cols2;j++){
//                 System.out.print(result[i][j] + " ");
//             }
//             System.out.println();
//         }
//         sc.close();
//     }
// }