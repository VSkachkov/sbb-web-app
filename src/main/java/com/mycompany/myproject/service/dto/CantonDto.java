package com.mycompany.myproject.service.dto;

import com.mycompany.myproject.persist.entity.Canton;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CantonAttribute {

    private Long canton_id;
    private String canton_name;

    public CantonAttribute(Canton canton) {
        this.canton_id = canton.getCanton_id();
        this.canton_name = canton.getCanton_name();
    }

    public CantonAttribute(){

    }
}
