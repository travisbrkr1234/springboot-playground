//package com.datamigration;

import java.io.*;

/**
 * Created by carlos.ochoa on 8/28/2015.
 */
public class Bookworm {
    //File Reading class
    public static void main(String[] args) throws IOException {
        String myFile = "C:\\Users\\carlos.ochoa\\Desktop\\order.csv";
        String splitBy = ",";
        BufferedReader br = new BufferedReader(new FileReader(myFile));
        String line = br.readLine();
        while((line = br.readLine()) !=null) {
            String[] b = line.split(splitBy);
            System.out.println("id: " + b[0]);
            System.out.println("email: " + b[1]);
            System.out.println("total: " + b[2]);
            System.out.println(b[3]);
            System.out.println(b[4]);
            System.out.println(b[5]);
            System.out.println(b[6]);
            System.out.println(b[7]);
            System.out.println(b[8]);
            System.out.println(b[9]);
            System.out.println(b[10]);
            //code to import data from template
        }
        br.close();
    }
}

//public String(privateKey, contactID, cardID, planID, productIDs, subscriptionIDs, processSpecials, promoCodes, leadAffiliateID, saleAffiliateID) {
//}
//Use properties file to form these
//
//
//

