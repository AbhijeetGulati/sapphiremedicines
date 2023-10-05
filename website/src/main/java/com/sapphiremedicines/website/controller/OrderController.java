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

@RestController
@RequestMapping("/orders")
public class OrderController {

//    @Autowired
//    private Order order;

    @Autowired
    private OrderService orderService;

    @PostMapping
    public int createDetails(@RequestBody Order order) throws IOException {
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
            data.put("orderid", order.getOrderId());
            data.put("orderDetails",order.getOrderDetails());
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

            // Data to append
            String dataToAppend = text;

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
        return order.getOrderId();
    }
}
