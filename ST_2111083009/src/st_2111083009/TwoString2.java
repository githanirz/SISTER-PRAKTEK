package st_2111083009;

class TwoStrings2 {
   static void print(String str1, String str2) {
      System.out.print(str1);
      try {
         Thread.sleep(500);
      } catch (InterruptedException ie) {
      }
      System.out.println(str2);
   }
 }
 class PrintStringsThread6 implements Runnable {
   Thread thread;
   String str1, str2;
   TwoStrings ts;
   PrintStringsThread6(String str1, String str2, TwoStrings ts) 
   { this.str1 = str1;
      this.str2 = str2;
      this.ts = ts;   
      thread = new Thread(this);
      thread.start();
   }
   public void run() {
      synchronized (ts) {
         ts.print(str1, str2);
      }
   }
 }
 class TestThread6 {
   public static void main(String args[]) {
      TwoStrings ts = new TwoStrings();
      new PrintStringsThread6("Hello ", "there.", ts);
      new PrintStringsThread6("How are ", "you?", ts);
      new PrintStringsThread6("Thank you ", "very much!", ts);
   }
 }