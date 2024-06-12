package com.kshrd.btb_jwt_class_demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CusRequest {
    private String cus_first_name;
    private String cus_last_name;
    private String cus_phonenumber;
}
