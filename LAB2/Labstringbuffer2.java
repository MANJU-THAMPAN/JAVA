public class Labstringbuffer2
{


public static void main(String[] args) {
    // create a string buffer in java
    StringBuffer sb = new StringBuffer();
    System.out.println("Before appending: " + sb);
    // append method
    sb.append("Hellooo the is the sentence for text");
    System.out.println("\nAfter appending 'Hello': " + sb);
    // insert method
    sb.insert(0, "Welcome ");
    System.out.println("\nAfter inserting 'Welcome' at index 0 :" + sb);
    // replace method
    sb.replace(0, 5, "Hi");
    System.out.println("\nAfter replacing with 'Hi':" + sb);
    // delete method
    sb.delete(0, 5);
    System.out.println("\nAfter deleting from index 0 to 5:" + sb);
    // charAt method
    System.out.println("\nCharacter at index 5 is :" + sb.charAt(5));
    // setCharAt
    sb.setCharAt(5, '*');
    System.out.println("\nSet Character at index 5 to * :" + sb.charAt(5));
    // length
    int length = sb.length();
    System.out.println("\nLength of the stringbuffer is :" + length);
    // capacity
    int capacity = sb.capacity();
    System.out.println("\nCapacity of the stringbuffer is :" + capacity);
    // ensureCapacity
    sb.ensureCapacity(100);
    System.out.println("\nEnsured Capacity of the stringbuffer is :" + sb.capacity());
    // toString
    System.out.println("\nThe string after ensuring capacity is :" + sb.toString());
    // Substring
    System.out.println("\nSubstring starting from index 5 till end is :" + sb.substring(5));

}
}
    

