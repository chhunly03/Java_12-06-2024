package com.kshrd.btb_jwt_class_demo.controller;

import com.kshrd.btb_jwt_class_demo.model.Customer;
import com.kshrd.btb_jwt_class_demo.model.request.CusRequest;
import com.kshrd.btb_jwt_class_demo.model.responce.CusResponse;
import com.kshrd.btb_jwt_class_demo.service.CusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class customerController {
    private final CusService cusService;

    public customerController(CusService cusService) {
        this.cusService = cusService;
    }

    @GetMapping("/All")
    public ResponseEntity<CusResponse<List<Customer>>> getAllBook(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int size
    ) {
        int offset = (page - 1) * size;
        CusResponse<List<Customer>> response = CusResponse.<List<Customer>>builder()
                .message("Get Customer Successfully")
                .payload(cusService.getAllCus(offset, size))
                .httpStatus(HttpStatus.OK)

                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CusResponse<?>> getBookById(Integer id) {
        Customer ID = cusService.getCusByID(id);
        CusResponse<Customer> response = CusResponse.<Customer>builder()
                .message("Get cus by id: " + id)
                .payload(cusService.getCusByID(id))
                .httpStatus(HttpStatus.OK)

                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("phone/{cus_phonenumber}")
    public ResponseEntity<CusResponse<?>> getCusByphonenumber(@PathVariable  String cus_phonenumber) {
        CusResponse<Customer> response = CusResponse.<Customer>builder()
                .message("Get cus by phone number: " + cus_phonenumber)
                .payload(cusService.getCusByphonenumber(cus_phonenumber))
                .httpStatus(HttpStatus.OK)
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    public ResponseEntity<CusResponse<?>> createCus(@RequestBody CusRequest cusRequest) {
        Integer ID = cusService.createCus(cusRequest);
        CusResponse<Customer> response = null;
        if (ID != null) {
            response = CusResponse.<Customer>builder()
                    .message("Create cus successfully")
                    .httpStatus(HttpStatus.CREATED)
                    .payload(cusService.getCusByID(ID))

                    .build();
        } else {
            response = CusResponse.<Customer>builder()
                    .message("Create cus not successfully")
                    .httpStatus(HttpStatus.CREATED)

                    .build();
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CusResponse<Customer>> updateStaff(@PathVariable Integer id, @RequestBody CusRequest cusRequest) {
        Integer Store = cusService.updateCusByID(id, cusRequest);
        if (Store != null) {
            CusResponse<Customer> response = CusResponse.<Customer>builder()
                    .message("Update cus successfully" + id)
                    .payload(cusService.getCusByID(id))
                    .httpStatus(HttpStatus.OK)

                    .build();
            return ResponseEntity.ok(response);
        }else {
            CusResponse<Customer> response = CusResponse.<Customer>builder()
                    .message("Update cus successfully" + id)
                    .httpStatus(HttpStatus.OK)

                    .build();
            return ResponseEntity.ok(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<CusResponse<?>> RemoveCusByID(@PathVariable Integer id) {
        Integer store = cusService.removeCusByID(id);
        CusResponse<Customer> response = CusResponse.<Customer>builder()
                .message("Delete cus successfully " + id)
                .payload(cusService.getCusByID(id))
                .httpStatus(HttpStatus.OK)

                .build();
        return ResponseEntity.ok(response);
    }

}
