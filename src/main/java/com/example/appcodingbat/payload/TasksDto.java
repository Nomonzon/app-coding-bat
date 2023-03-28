package com.example.appcodingbat.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TasksDto {

   private Long id;
   private String description;
   private String method;
}
