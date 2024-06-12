package com.kshrd.btb_jwt_class_demo.service.cusServiceImp;


import com.kshrd.btb_jwt_class_demo.model.Customer;
import com.kshrd.btb_jwt_class_demo.model.request.CusRequest;
import com.kshrd.btb_jwt_class_demo.repository.CusRepository;
import com.kshrd.btb_jwt_class_demo.service.CusService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class cusServiceImp implements CusService {
    private final CusRepository cusRepository;

    public cusServiceImp(CusRepository cusRepository) {
        this.cusRepository = cusRepository;
    }

    @Override
    public List<Customer> getAllCus(int offset, int size) {
        return cusRepository.getAllStaff(offset,size);
    }

    @Override
    public Customer getCusByID(Integer id) {
        return cusRepository.getStaffByID(id);
    }

    @Override
    public Integer createCus(CusRequest cusRequest) {
        return cusRepository.createStaff(cusRequest);
    }

    @Override
    public Integer updateCusByID(Integer id, CusRequest cusRequest) {
        return cusRepository.editStaffByID(id,cusRequest);
    }

    @Override
    public Integer removeCusByID(Integer id) {
        return cusRepository.removeStaff(id);
    }

    @Override
    public Customer getCusByphonenumber(String cus_phonenumber) {
        return cusRepository.searchCusByphoneNumber(cus_phonenumber);
    }

}
