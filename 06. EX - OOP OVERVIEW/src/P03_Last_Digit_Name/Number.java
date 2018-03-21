package P03_Last_Digit_Name;

public class Number {
   int num;

   public Number(int num) {
       this.num = num;
   }

   public int getNum() {
       return num;
   }

   public void setNum(int num) {
       this.num = num;
   }

   public String returnEnglishName() {
       String result = "";
       int lastNumber = this.getNum() % 10;

       switch (lastNumber)
       {
           case 0: result = "zero"; break;
           case 1: case -1: result = "one"; break;
           case 2: case -2: result = "two"; break;
           case 3: case -3: result = "three"; break;
           case 4: case -4: result = "four"; break;
           case 5: case -5: result = "five"; break;
           case 6: case -6: result = "six"; break;
           case 7: case -7: result = "seven"; break;
           case 8: case -8: result = "eight"; break;
           case 9: case -9: result = "nine"; break;
           default:
               break;
       }
       return result;
   }
}
