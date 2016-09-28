/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstile.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Guinness
 */
public class XLSXReaderWriter {

    public static void main2(String[] args) throws IOException {

        String excelFilePath = "C:\\Users\\Guinness\\Documents\\Documents\\SILLIMAN IDSYS\\List of Enrolled Students, SY 2016-2017.csv";

        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(excelFilePath))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] list = line.split(cvsSplitBy);

                System.out.println("id: " + list[0] + " lname: " + list[1] + " first_name: " + list[2] + " middle_name: " + list[3] + " year_level: " + list[4] + " course: " + list[5]);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws IOException {

        String excelFilePath = "C:\\Users\\Guinness\\Documents\\Documents\\SILLIMAN IDSYS\\List of Teachers with Departments, SY 2016-2017.csv";

        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(excelFilePath))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] list = line.split(cvsSplitBy);

                System.out.println("id: " + list[0] + " lname: " + list[1] + " first_name: " + list[2] + " middle_name: " + list[3] + " college: " + list[4]);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
