package com.example.appcodingbat.payload;

import com.example.appcodingbat.entity.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {

    private Long id;
    private String name;
    private String description;

    public Long languageId;

}
