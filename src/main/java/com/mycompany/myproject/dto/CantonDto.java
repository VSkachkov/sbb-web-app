package com.mycompany.myproject.dto;

import com.mycompany.myproject.persist.entity.Canton;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CantonDto {

    private Long cantonId;
    private String cantonName;

    public CantonDto(Canton canton) {
        this.cantonId = canton.getCantonId();
        this.cantonName = canton.getCantonName();
    }

    public CantonDto() {

    }
}
