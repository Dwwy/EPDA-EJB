package com.example.demo1.Util;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;

public class StaticVariable {
    public static double freightCost = 5.00;
    public enum Condition{
        and,
        or
    }
    public static String authenticator_secret(){
//        try {
//            File myObj = new File("secret.txt");
//            Scanner myReader = new Scanner(myObj);
//            String data = "";
//            while (myReader.hasNextLine()) {
//                data = myReader.nextLine();
//            }
//            myReader.close();
//            return data;
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        return "QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK";
    }
    public static void printFields(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                System.out.println(field.getName() + ": " + value);
            } catch (IllegalAccessException e) {
                // Handle the exception
            }
        }
    }
    private static String randomAlphanumeric(int targetStringLength) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
    public enum accountType{
        Customer,
        Seller,
        Staff
    }
    public enum prodCat{
        ClothingApparel,
        Footwear,
        ElecGadgets,
        GamesToys,
        Pet,
        Stationary
    }
    public enum orderStat{
        //Customer add to cart and proceed to checkout but havent fill in checkout detail
        Pending,
        //Completed checkout process, not paid
        Awaiting_Payment,
        //Waiting for seller's acceptance
        Awaiting_Acceptance,
        //Paid, waiting to deliver
        Awaiting_Shipment,
        Delivered,
        //Seller Cancel order
        Cancelled
    }
    public enum Payment_Type{
        credit_card,
        debit_card,
        ewallet,
        Default
    }
    public enum Payment_Status{
        Pending,
        Paid
    }

    public static Map<String,String> getRequestObject(HttpServletRequest req,String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Map<String, String> dict = new Hashtable<>();
        Class<?> clazz = Class.forName(className);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            dict.put(field.getName(),req.getParameter(field.getName()));
        }
        return dict;
    }
}
