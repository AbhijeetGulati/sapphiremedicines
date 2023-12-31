package com.sapphiremedicines.website.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapphiremedicines.website.entity.Order;
import com.sapphiremedicines.website.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;

@RestController
@RequestMapping("/orders")
public class OrderController {

//    @Autowired
//    private Order order;

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> createDetails(@RequestBody Order order) throws IOException {
        // Assigning the content of the file




/*
//        //String text
//                = order1.toString();

        // Defining the file name of the file
        Path fileName = Path.of(
                "C:\\Users\\abhig\\OneDrive\\Desktop\\sapphiredata\\order.txt");

        // Writing into the file
        Files.writeString(fileName, text);

        // Reading the content of the file
        String file_content = Files.readString(fileName);

        // Printing the content inside the file
        System.out.println(file_content);

 */
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            // Set the file path where you want to append data
            String filePath = "C:/Users/abhig/OneDrive/Desktop/sapphiredata/order.txt";

            // Create a FileWriter in append mode
            fileWriter = new FileWriter(filePath, true);

            // Wrap the FileWriter in a BufferedWriter
            bufferedWriter = new BufferedWriter(fileWriter);

            java.util.Map<String, Object> data = new java.util.HashMap<>();
            //data.put("orderid", order.getOrderId());
            //we are just returing order details which will also contain the order id
            //we are just returning the http response code

            data.put("orderDetails", order.getOrderDetails());
//            data.put("quantity", order.getQuantity());
//            data.put("skuid",order.getSkuid());
//            data.put("address",order.getAddress());
//            data.put("couponcode",order.getCouponcode());
//            data.put("name",order.getName());


            // Create an ObjectMapper instance (from Jackson)
            ObjectMapper objectMapper = new ObjectMapper();
            //String jsonString = objectMapper.writeValueAsString(data);
            String text = null;

            try {
                // Convert the JSON object to a JSON-formatted string
                text = objectMapper.writeValueAsString(data);

                // Print the JSON string
                // System.out.println("JSON String: " + text);
            } catch (Exception e) {
                e.printStackTrace();
            }


//            String formattedDateTime = null;
//            try {
//                Instant currentInstant = Instant.now();
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm:ss z");
//                formattedDateTime = formatter.format(currentInstant);
//
//                System.out.println("Formatted Date and Time: " + formattedDateTime);
//            } catch (DateTimeParseException e) {
//                System.err.println("Error formatting date and time: " + e.getMessage());
//            }

//            Instant currentInstant = Instant.now();
//            DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss Z");
//            String formattedDateTime = dateTimeFormatter.format(currentInstant);

            //String t1=obj.toString();
             String date=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());

            // Data to append
            String dataToAppend = text + " order id : "+date;
            System.out.println(dataToAppend);

            // Append the data to the file
            bufferedWriter.write(dataToAppend);
            bufferedWriter.newLine(); // Add a newline if needed

            // You can append more data here if needed

            System.out.println("Data appended successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the BufferedWriter and FileWriter when done
                if (bufferedWriter != null)
                    bufferedWriter.close();
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(order.getOrderDetails());
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
