package com.kshrd.btb_jwt_class_demo.service;



import com.kshrd.btb_jwt_class_demo.model.Customer;
import com.kshrd.btb_jwt_class_demo.model.request.CusRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CusService {
    List<Customer> getAllCus(int offset, int size);

    Customer getCusByID(Integer id);

    Integer createCus(CusRequest cusRequest);

    Integer updateCusByID(Integer id, CusRequest cusRequest);

    Integer removeCusByID(Integer id);

    Customer getCusByphonenumber(String cus_phonenumber);
}
