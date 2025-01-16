package com.pevinskevin.dronepizza;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DroneControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void testGetAllDrones() throws Exception {
//        // Act & Assert: Perform GET request and validate response
//        mockMvc.perform(get("/drones")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.size()").value(4)) // Validate list size
//                .andExpect(jsonPath("$[0].id").value(1)) // Validate first drone's name
//                .andExpect(jsonPath("$[0].station").value(1)) // Validate first drone's status
//                .andExpect(jsonPath("$[0].UUID").value("Drone 2")) // Validate second drone's name
//                .andExpect(jsonPath("$[0].operationStatus").value("FLYING")); // Validate second drone's status
//    }
}
