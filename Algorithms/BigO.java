// public class BigO {
// public static void printItems(int n) {
//     for (int i = 0; i < n; i++) {
//         System.out.print(i  + " ");
//     }
//     for (int j = 0; j < n; j++) {
//         System.out.print(j  + " ");
//     }
// }
// public static void main(String[] args) {
//     int n = 10;
//     printItems(n);
// }
// }

//Its time complexity is O(n) because the number of operations grows linearly with the input size n. The loop runs n times, and each iteration performs a constant amount of work (printing the number). Therefore, the overall time complexity is O(n).   
//Dropping the constant factor (2) and the lower order term (n) gives us O(n).  


// public class BigO{
//     public static void printItems(int n){
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 System.out.println(i + " " + j + " ");
//             }
//         }
//     }
//     public static void main(String[] args) {
//         int n = 10;
//         printItems(n);
//     }
//}

//Its time complexity is O(n^2) because the number of operations grows quadratically with the input size n. The outer loop runs n times, and for each iteration of the outer loop, the inner loop also runs n times. Therefore, the total number of iterations is n * n = n^2. Each iteration performs a constant amount of work (printing the numbers), so the overall time complexity is O(n^2).  
//Drop non dominant terms and constants, we get O(n^2).
// public class BigO{
//     public static void printItems(int n){
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                     System.out.println(i + " " + j );
                
//             }
//         }
//         for(int k=0;k<n;k++){
//                     System.out.println( k + " ");
//                 }
//     }
//     public static void main(String[] args) {
//         int n = 10;
//         printItems(n);
//     }
// }  //Its time complexity is O(n^2) because the number of operations grows quadratically with the input size n. The outer loop runs n times, and for each iteration of the outer loop, the inner loop also runs n times, resulting in n * n = n^2 iterations. The additional loop that runs n times contributes O(n) to the time complexity, but since O(n^2) dominates O(n), we drop the lower order term and constants to get O(n^2).   

// public class BigO {

//     public static int add(int n){
//         return n + n + n + n + n + n + n + n + n + n; // O(1) because it performs a constant number of operations regardless of the input size n.
//     }


// public static void main(String[] args) {
//     System.out.println(add(10));
// }} 


//Let's have an sorted array 1 2 3 4 5 6 7 8 if we have to find 1  so lets divide array in half 
// i.e, 1 2  3 4 in which 1 is there and now divide that also in half 
// i.e, 1 2 now divide that array in half and we find 1.
//These takes 3 steps to find 1 in the array of 8 elements.
// 2^3 = 8
//So the time complexity of this algorithm is O(log n) because with each step, we are halving the number of elements to check. The number of steps required to find an element in a sorted array using binary search grows logarithmically with the size of the input array, which is why we express it as O(log n).    
//you could have billions of elements in the array, but it would only take a few steps to find the target element using binary search, making it very efficient for large datasets. 

//O(nlog n) is the time complexity of sorting algorithms like Merge Sort and Quick Sort. This is because these algorithms divide the input array into smaller subarrays, sort them recursively, and then merge the sorted subarrays back together. The division and merging steps take O(n) time, while the recursive sorting of the subarrays takes O(log n) time due to the halving of the input size at each level of recursion. Therefore, the overall time complexity is O(n log n).   


//Big O different terms for inputs :
public class BigO {

    public static void printItems(int a,int b,int c){
        for(int i=0;i<a;i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int j=0;j<b;j++){
            System.out.print(j+" ");
        }
        System.out.println();
        for(int k=0;k<c;k++){
            System.out.print(k+" ");
        }

    }
    public static void main(String[] args) {
        printItems(5, 10, 15);
    }
}
