package com.kshrd.btb_jwt_class_demo.repository;

import com.kshrd.btb_jwt_class_demo.model.Customer;
import com.kshrd.btb_jwt_class_demo.model.request.CusRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CusRepository {

    @Select("SELECT * FROM customer LIMIT #{size} OFFSET #{page}")
    List<Customer> getAllStaff(@Param("page") Integer page, @Param("size") Integer size);

    @Select("SELECT * FROM customer WHERE cus_id = #{cus_id}")
    Customer getStaffByID(Integer cus_phonenumber);

    @Select("""
            INSERT INTO customer (cus_first_name, cus_last_name, cus_phonenumber)
            VALUES (#{req.cus_first_name}, #{req.cus_last_name}, #{req.cus_phonenumber}) RETURNING cus_id
            """)
    Integer createStaff(@Param("req") CusRequest cusRequest);

    @Update("""
            UPDATE customer
            SET cus_first_name = #{req.cus_first_name}, cus_last_name = #{req.cus_last_name}, cus_phonenumber = #{req.cus_phonenumber}
            WHERE cus_id = #{id} RETURNING cus_id
            """)
    Integer editStaffByID(@Param("id") Integer id, @Param("req") CusRequest cusRequest);

    @Delete("DELETE FROM customer WHERE cus_id = #{id}")
    Integer removeStaff(@Param("id") Integer id);

    @Select("""
    SELECT DISTINCT *
    FROM customer
    WHERE cus_phonenumber ILIKE '%' || #{cus_phonenumber} || '%'
    """)
    Customer searchCusByphoneNumber(String cus_phonenumber);

}
