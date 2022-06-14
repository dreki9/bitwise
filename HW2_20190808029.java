import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author HUSEYIN EMRE UGDUL
 * @since 24.11.2021
 */
public class HW2_20190808029 {
    static int inPut;
    static int operation;

    /**
     *
     * @param text The integer form of the bit to be shifted is taken as a
     *         String parameter.
     * @param shift Number of shift operation
     * @return the state of bits after shift
     */
    public String ls(String text, int shift){
        String reText = Integer.toBinaryString(Integer.parseInt(text));
        int result = Integer.parseInt(text)<<shift;
        String reResult = Integer.toBinaryString(result);
        reResult =
                new String(new char[32 - reResult.length()]).replace('\u0000',
                        '0') + reResult;
        System.out.print(text + " << " + shift + " = ");
        return reResult + " = " + result;

    }

    /**
     *
     * @param text The integer form of the bit to be shifted is taken as a String parameter
     * @param shift Number of shift operation
     * @return state of bits after shift
     */
    public String rs(String text, int shift){
        String reText = Integer.toBinaryString(Integer.parseInt(text));
        int result = Integer.parseInt(text)>>shift;
        String reResult = Integer.toBinaryString(result);

        reResult =
                new String(new char[32 - reResult.length()]).replace('\u0000',
                        '0') + reResult;
        System.out.print(text + " >> " + shift + " = ");
        return reResult + " = " + result;
    }

    /**
     *
     * @param text The integer for which the complement is requested as a
     *             String.
     * @return state of bits after receiving the complement
     */
    public String complement(String text){
        String reText = Integer.toBinaryString(Integer.parseInt(text));
        int result = ~Integer.parseInt(text);
        String reResult = Integer.toBinaryString(result);
        reText =
                new String(new char[32 - reText.length()]).replace('\u0000', '0') + reText;
        reResult =
                new String(new char[32 - reResult.length()]).replace('\u0000',
                        '0') + reResult;
        System.out.print("~" + reText + " = ");
        return reResult + " = " + result;
    }

    /**
     *
     * @param text Double, Integer or String values to be converted into bits
     *            for comparison with xor operator as a String.
     * @param text2 Double, Integer or String values to be converted into bits
     *                for comparison with xor operator as a String.
     * @return The state of the bits obtained as a result of the operation with
     *                  xor operator
     */
    public String xor(String text, String text2){
        char[] textArray;
        char[] text2Array;
        char[] resultArray;

        if (inPut == 0) {
            String reText = Integer.toBinaryString(Integer.parseInt(text));
            String reText2 = Integer.toBinaryString(Integer.parseInt(text2));
            int result = Integer.parseInt(text) ^ Integer.parseInt(text2);
            String reResult = Integer.toBinaryString(result);
            reText =
                    new String(new char[32 - reText.length()]).replace('\u0000', '0') + reText;
            reText2 =
                    new String(new char[32 - reText2.length()]).replace('\u0000', '0') + reText2;
            reResult =
                    new String(new char[32 - reResult.length()]).replace('\u0000',
                            '0') + reResult;
            System.out.println(reText + " ^ ");
            System.out.println(reText2);
            System.out.println("-----------------------------------");
            return reResult + " = " + result;


        }
        else if (inPut == 1){
            textArray = text.toCharArray();
            text2Array = text2.toCharArray();
            StringBuilder textBuilder = new StringBuilder();
            StringBuilder text2Builder = new StringBuilder();
            String textS = "";
            String textS2 = "";
            int temp = 0;
            StringBuilder reResult = new StringBuilder();
            for(char c: textArray){
                textBuilder.append(String.format("%8s", Integer.toBinaryString(c)).replaceAll(" ", "0"));
            }
            for(char c: text2Array){
                text2Builder.append(String.format("%8s",
                        Integer.toBinaryString(c)).replaceAll(" ", "0"));
            }
            if (text2Builder.length() < textBuilder.length()){
                textS = textBuilder.toString();
                textS2 =
                        new String(new char[textBuilder.length() - text2Builder.length()]).replace('\u0000', '0') + text2Builder.toString();
                temp = textBuilder.length();

            }
            else{
                textS =
                        new String(new char[text2Builder.length() - textBuilder.length()]).replace('\u0000', '0')+ textBuilder.toString();
                textS2 = text2Builder.toString();
                temp = text2Builder.length();
            }
            textArray = textS.toCharArray();
            text2Array = textS2.toCharArray();
            for (int i = 0; i < temp; i++) {
                if (((textArray[i] == '0') && (text2Array[i]== '0')) || ((textArray[i] == '1') && (text2Array[i]== '1')) ){
                    reResult.append(0);
                }
                else{
                    reResult.append(1);
                }
            }
            String text3 =
                    new String(new BigInteger(reResult.toString(), 2).toByteArray());
            System.out.println(textS + " &");
            System.out.println(textS2);
            System.out.println("--------------------------------");
            return reResult.toString() + " = " + text3;


        }
        else {
            String reText =
                    Long.toBinaryString(Double.doubleToRawLongBits(Double.parseDouble(text)));
            String reText2 =
                    Long.toBinaryString(Double.doubleToRawLongBits(Double.parseDouble(text2)));
            reText =
                    new String(new char[64 - reText.length()]).replace('\u0000', '0')+ reText;
            reText2 =
                    new String(new char[64 - reText2.length()]).replace('\u0000', '0')+ reText2;
            textArray = reText.toCharArray();
            text2Array = reText2.toCharArray();
            StringBuilder reResult = new StringBuilder();
            for (int i = 0; i < 64; i++) {
                if (((textArray[i] == '0') && (text2Array[i]== '0')) || ((textArray[i] == '1') && (text2Array[i]== '1')) ){
                    reResult.append(0);
                }
                else{
                    reResult.append(1);
                }
            }
            System.out.println(reText + " ^");
            System.out.println(reText2);
            System.out.println(
                    "------------------------------------------------------------------------");
            return reResult.toString();
        }
    }

    /**
     *
     * @param text Double, Integer or String values to be converted into bits
     *                  for comparison with and operator as a String.
     * @param text2 Double, Integer or String values to be converted into bits
     *                 for comparison with and operator as a String.
     * @return The state of the bits obtained as a result of the operation with
     *                       and operator
     */
    public String and(String text, String text2) {
        char[] textArray;
        char[] text2Array;

        if (inPut == 0) {
            String reText = Integer.toBinaryString(Integer.parseInt(text));
            String reText2 = Integer.toBinaryString(Integer.parseInt(text2));
            int result = Integer.parseInt(text) & Integer.parseInt(text2);
            String reResult = Integer.toBinaryString(result);
            reText =
                    new String(new char[32 - reText.length()]).replace('\u0000', '0') + reText;
            reText2 =
                    new String(new char[32 - reText2.length()]).replace('\u0000', '0') + reText2;
            reResult =
                    new String(new char[32 - reResult.length()]).replace('\u0000',
                            '0') + reResult;
            System.out.println(reText + " & ");
            System.out.println(reText2);
            System.out.println("-----------------------------------");
            return reResult + " = " + result;
        }
        else if (inPut == 1){
            textArray = text.toCharArray();
            text2Array = text2.toCharArray();
            StringBuilder textBuilder = new StringBuilder();
            StringBuilder text2Builder = new StringBuilder();
            String textS = "";
            String textS2 = "";
            int temp = 0;
            StringBuilder reResult = new StringBuilder();
            for(char c: textArray){
                textBuilder.append(String.format("%8s", Integer.toBinaryString(c)).replaceAll(" ", "0"));
            }
            for(char c: text2Array){
                text2Builder.append(String.format("%8s",
                        Integer.toBinaryString(c)).replaceAll(" ", "0"));
            }
            if (text2Builder.length() < textBuilder.length()){
                textS = textBuilder.toString();
                textS2 =
                        new String(new char[textBuilder.length() - text2Builder.length()]).replace('\u0000', '0') + text2Builder.toString();
                temp = textBuilder.length();

            }
            else{
                textS =
                        new String(new char[text2Builder.length() - textBuilder.length()]).replace('\u0000', '0')+ textBuilder.toString();
                textS2 = text2Builder.toString();
                temp = text2Builder.length();
            }
            textArray = textS.toCharArray();
            text2Array = textS2.toCharArray();
            for (int i = 0; i < temp; i++) {
                if ((textArray[i] == '0') && (text2Array[i]== '0')){
                    reResult.append(0);
                }
                else if ((textArray[i] == '0') || (text2Array[i]== '0')){
                    reResult.append(0);
                }
                else{
                    reResult.append(1);
                }
            }
            String text3 =
                    new String(new BigInteger(reResult.toString(), 2).toByteArray());
            System.out.println(textS + " &");
            System.out.println(textS2);
            System.out.println("--------------------------------");
            return reResult.toString() + " = " + text3 ;

        }
        else {
            String reText =
                    Long.toBinaryString(Double.doubleToRawLongBits(Double.parseDouble(text)));
            String reText2 =
                    Long.toBinaryString(Double.doubleToRawLongBits(Double.parseDouble(text2)));
            reText =
                    new String(new char[64 - reText.length()]).replace('\u0000', '0')+ reText;
            reText2 =
                    new String(new char[64 - reText2.length()]).replace('\u0000', '0')+ reText2;
            textArray = reText.toCharArray();
            text2Array = reText2.toCharArray();
            StringBuilder reResult = new StringBuilder();
            for (int i = 0; i < 64; i++) {
                if ((textArray[i] == '0') && (text2Array[i]== '0')){
                    reResult.append(0);
                }
                else if ((textArray[i] == '0') || (text2Array[i]== '0')){
                    reResult.append(0);
                }
                else{
                    reResult.append(1);
                }
            }
            System.out.println(reText + " &");
            System.out.println(reText2);
            System.out.println("--------------------------------");
            return reResult.toString();
        }

    }

    /**
     *
     * @param text Double, Integer or String values to be converted into bits
     *                       for comparison with or operator as a String.
     * @param text2 Double, Integer or String values to be converted into bits
     *                       for comparison with or operator as a String.
     * @return The state of the bits obtained as a result of the operation with
     *                           or operator
     */
    public String or(String text, String text2){
        char[] textArray;
        char[] text2Array;

        if (inPut == 0){
            String reText = Integer.toBinaryString(Integer.parseInt(text));
            String reText2 = Integer.toBinaryString(Integer.parseInt(text2));
            int result = Integer.parseInt(text) | Integer.parseInt(text2);
            String reResult = Integer.toBinaryString(result);
            reText =
                    new String(new char[32 - reText.length()]).replace('\u0000', '0')+ reText;
            reText2 =
                    new String(new char[32 - reText2.length()]).replace('\u0000', '0')+ reText2;
            reResult =
                    new String(new char[32 - reResult.length()]).replace('\u0000',
                            '0') + reResult;
            System.out.println(reText+" | ");
            System.out.println(reText2);
            System.out.println("-----------------------------------");
            return reResult+" = "+result;

        }
        else if(inPut == 1){
            textArray = text.toCharArray();
            text2Array = text2.toCharArray();
            StringBuilder textBuilder = new StringBuilder();
            StringBuilder text2Builder = new StringBuilder();
            String textS = "";
            String textS2 = "";
            int temp = 0;
            StringBuilder reResult = new StringBuilder();
            for(char c: textArray){
                textBuilder.append(String.format("%8s", Integer.toBinaryString(c)).replaceAll(" ", "0"));
            }
            for(char c: text2Array){
                text2Builder.append(String.format("%8s",
                        Integer.toBinaryString(c)).replaceAll(" ", "0"));
            }
            if (text2Builder.length() < textBuilder.length()){
                textS = textBuilder.toString();
                textS2 =
                        new String(new char[textBuilder.length() - text2Builder.length()]).replace('\u0000', '0') + text2Builder.toString();
                temp = textBuilder.length();

            }
            else{
                textS =
                        new String(new char[text2Builder.length() - textBuilder.length()]).replace('\u0000', '0')+ textBuilder.toString();
                textS2 = text2Builder.toString();
                temp = text2Builder.length();
            }
            textArray = textS.toCharArray();
            text2Array = textS2.toCharArray();
            for (int i = 0; i < temp; i++) {
                if ((textArray[i] == '0') && (text2Array[i] == '0')){
                    reResult.append(0);
                }
                else{
                    reResult.append(1);
                }
            }
            String text3 =
                    new String(new BigInteger(reResult.toString(), 2).toByteArray());
            System.out.println(textS + " |");
            System.out.println(textS2);
            System.out.println("--------------------------------");
            return reResult.toString() + " = " + text3 ;
        }
        else{
            String reText =
                    Long.toBinaryString(Double.doubleToRawLongBits(Double.parseDouble(text)));
            String reText2 =
                    Long.toBinaryString(Double.doubleToRawLongBits(Double.parseDouble(text2)));
            reText =
                    new String(new char[64 - reText.length()]).replace('\u0000', '0')+ reText;
            reText2 =
                    new String(new char[64 - reText2.length()]).replace('\u0000', '0')+ reText2;
            textArray = reText.toCharArray();
            text2Array = reText2.toCharArray();
            StringBuilder reResult = new StringBuilder();
            for (int i = 0; i < 64; i++) {
                if ((textArray[i] == '0') && (text2Array[i]== '0')){
                    reResult.append(0);
                }
                else{
                    reResult.append(1);
                }
            }
            System.out.println(reText + " |");
            System.out.println(reText2);
            System.out.println("--------------------------------");
            return reResult.toString();
        }

    }

    /**
     *
     * @param args main
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Give the type of input? int=0, string=1, "
                           + "double=2");
        inPut = scan.nextInt();

        System.out.println("Give the type of operation? or=0, and=1, xor= 2, "
                           + "complement=3, right shift=4, left shift=5");
        operation = scan.nextInt();
        HW2_20190808029 object = new HW2_20190808029();
        switch(operation){
            case 0:
                if (inPut == 0){
                    System.out.println("First Integer Number: ");
                    String text = scan.next();
                    System.out.println("Second Integer Number: ");
                    String text2 = scan.next();
                    System.out.println(object.or(text,text2));
                    break;
                }
                else if (inPut == 1){
                    System.out.println("First String: ");
                    String text = scan.next();
                    System.out.println("Second String: ");
                    String text2 = scan.next();
                    System.out.println(object.or(text,text2));
                    break;
                }
                else {
                    System.out.println("First Double Number: ");
                    String text = scan.next();
                    System.out.println("Second Double Number: ");
                    String text2 = scan.next();
                    System.out.println(object.or(text,text2));
                    break;
                }
            case 1:
                if (inPut == 0){
                    System.out.println("First Integer Number: ");
                    String text = scan.next();
                    System.out.println("Second Integer Number: ");
                    String text2 = scan.next();
                    System.out.println(object.and(text,text2));
                    break;
                }
                else if (inPut == 1){
                    System.out.println("First String: ");
                    String text = scan.next();
                    System.out.println("Second String: ");
                    String text2 = scan.next();
                    System.out.println(object.and(text,text2));
                    break;
                }
                else {
                    System.out.println("First Double Number: ");
                    String text = scan.next();
                    System.out.println("Second Double Number: ");
                    String text2 = scan.next();
                    System.out.println(object.and(text,text2));
                    break;
                }
            case 2:
                if (inPut == 0){
                    System.out.println("First Integer Number: ");
                    String text = scan.next();
                    System.out.println("Second Integer Number: ");
                    String text2 = scan.next();
                    System.out.println(object.xor(text,text2));
                    break;
                }
                else if (inPut == 1){
                    System.out.println("First String: ");
                    String text = scan.next();
                    System.out.println("Second String: ");
                    String text2 = scan.next();
                    System.out.println(object.xor(text,text2));
                    break;
                }
                else {
                    System.out.println("First Double Number: ");
                    String text = scan.next();
                    System.out.println("Second Double Number: ");
                    String text2 = scan.next();
                    System.out.println(object.xor(text,text2));
                    break;
                }
            case 3:
                if (inPut == 0){
                    System.out.println("Integer Number: ");
                    String text = scan.next();
                    System.out.println(object.complement(text));
                    break;
                }
            case 4:
                if (inPut == 0){
                    System.out.println("Integer Number: ");
                    String text = scan.next();
                    System.out.println("Shift Number: ");
                    int shift = scan.nextInt();
                    System.out.println(object.rs(text, shift));
                    break;
                }
            case 5:
                if (inPut == 0){
                    System.out.println("Integer Number: ");
                    String text = scan.next();
                    System.out.println("Shift Number: ");
                    int shift = scan.nextInt();
                    System.out.println(object.ls(text, shift));
                    break;
                }

        }




    }



}
