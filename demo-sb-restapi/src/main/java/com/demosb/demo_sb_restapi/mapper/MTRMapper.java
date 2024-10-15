// package com.demosb.demo_sb_restapi.mapper;

// import com.demosb.demo_sb_restapi.model.MTRLineData;
// import com.demosb.demo_sb_restapi.model.MTRRawData;
// import com.demosb.demo_sb_restapi.model.MTRTrain;
// import com.fasterxml.jackson.databind.ObjectMapper;

// public class MTRMapper {
//     public static void main(String[] args) {
//         String json = "{...}";  // Your JSON data here
        
//         try {
//             ObjectMapper objectMapper = new ObjectMapper();
//             MTRRawData mtrData = objectMapper.readValue(json, MTRRawData.class);
            
//             // Example: Access some fields from the parsed data
//             System.out.println("Status: " + mtrData.getStatus());
//             System.out.println("Message: " + mtrData.getMessage());
//             System.out.println("System Time: " + mtrData.getSysTime());

//             // Access a specific line, e.g., "TML-DIH"
//             MTRLineData tmlDih = mtrData.getData().get("TML-DIH");
//             System.out.println("TML-DIH Current Time: " + tmlDih.getCurrTime());
            
//             // Access the first UP train in the list
//             if (!tmlDih.getUp().isEmpty()) {
//                 MTRTrain firstTrain = tmlDih.getUp().get(0);
//                 System.out.println("First UP Train Destination: " + firstTrain.getDest());
//             }

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }
// }
