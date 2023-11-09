
public class Lab2
{
  public static String stringh="“We realizes that while our workers were thriving, the\r\n" + //
          "surrounding villages were still suffering. It became our goal to uplift their\r\n" + //
          "quality of life as well. I remember seeing a family of 4 on a motorbike in the\r\n" + //
          "heavy Bombay rain — I knew I wanted to do more for these families who were\r\n" + //
          "risking their lives for lack of an alternative” The alternative mentioned here\r\n" + //
          "is the Tata Nano, which soon after came as the world’s cheapest car on retail\r\n" + //
          "at a starting price of only Rs 1 lakh. These were the words of Ratan Tata in a\r\n" + //
          "recent post by Humans of Bombay which formed the basis of his decision to come\r\n" + //
          "up with a car like Tata Nano.";
    public static String stringy="This is a breif introduction on tata nano";
    public static String stringf="THIS IS A breif introduction on tata nano";
   
    public static void main(String[] args) {
        System.out.println(stringh.length());
        //charAt()
        System.out.println(stringh.charAt(9));
        //compareTo
        System.out.println(stringh.compareTo(stringh));
        //concat
        System.out.println(stringh.concat(stringy));
        //contains()
        System.out.println(stringh.contains("Humans"));
        //endswith()
        System.out.println(stringh.endsWith("Nano."));
        //equals()
        System.out.println(stringy.equals(stringy));
        //equalsignorecase()
        System.out.println(stringy.equalsIgnoreCase(stringf));
        //format()
        System.out.println(String.format(stringh));
        //getbytes()
        System.out.println(stringh.getBytes());
        //getchars()
        char[] charArray = new char[15];
        stringh.getChars(7, 22, charArray, 0);
        System.out.println("getChars(): " + new String(charArray));
        // indexOf()
        int indexOfText = stringh.indexOf("villages");
        System.out.println("indexOf(\"villages\"): " + indexOfText);

        // intern()
        String internedText = stringh.intern();
        System.out.println("intern(): " + internedText);

        // isEmpty()
        boolean isEmptyText = stringh.isEmpty();
        System.out.println("isEmpty(): " + isEmptyText);

        // join()
        String[] words = stringh.split(" ");
        String joinedText = String.join("_", words);
        System.out.println("join(): " + joinedText);

        // lastIndexOf()
        int lastIndexOfText = stringh.lastIndexOf("villages");
        System.out.println("lastIndexOf(\"villages\"): " + lastIndexOfText);

        // length()
        int textLength = stringh.length();
        System.out.println("length(): " + textLength);
    }
}