package com.ispan.demospringboot.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	//單筆資料(不可同名)
//	@Query(value = "from Customer where name = ?1")
//	Customer findCustomerByName(String name);
	
	//list可多筆同名
	@Query(value = "from Customer where name = ?1")
	List<Customer> findCustomerByName(String name);
	
	@Query(value = "from Customer where name = :name")
	List<Customer> findCustomerByName2(String name);
	
	//原生語法(不可跨資料庫 但資料庫如果複雜則使用)
	@Query(value = "select * from Customer where name = :name",nativeQuery = true)
	List<Customer> findCustomerByName3(String name);
	
	@Transactional  //預設為read only所以用來覆蓋
	@Modifying  	//客製化語法要加
	@Query(value="delete from customer where id = :id", nativeQuery = true) 
	void deleteCustomerById(@Param("id") Integer id);
	
	//特殊語法
	List<Customer> findByLevelOrderById(Integer level);
	
}
