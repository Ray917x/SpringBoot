package com.ispan.demospringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ispan.demospringboot.model.Customer;
import com.ispan.demospringboot.model.CustomerRepository;

//@RestController
@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository cDao;

	// 網頁生成資料進database
	@ResponseBody
	@GetMapping(path = "/customer/insert")
	public Customer insert() {
		Customer c1 = new Customer();
		c1.setName("廖老大");
		c1.setLevel(5);

		Customer resCus = cDao.save(c1);

		return resCus;

	}

	// 反序列化 回傳Json 並儲存進database
	@ResponseBody
	@PostMapping(path = "/customer/insert2")
	public Customer insert2(@RequestBody Customer cus) {
		return cDao.save(cus);
	}

	// 存多筆 陣列
	@ResponseBody
	@PostMapping(path = "/customer/insert3")
	public List<Customer> insert3(@RequestBody List<Customer> cus2) {

		return cDao.saveAll(cus2);
	}

	// 查詢單筆
	@ResponseBody
	@GetMapping(path = "/customer/{id}") // 對應Integer id
	public Customer findById(@PathVariable Integer id) {
		Optional<Customer> optional = cDao.findById(id);

		if (optional.isPresent()) { // optional用isPresent判斷是否有取得物件(有會回傳true)
			return optional.get(); // 用get可取得optional的物件
		}

		Customer notfound = new Customer();
		notfound.setName("無此資料");
		return notfound;

	}

	// 查全部
	@ResponseBody
	@GetMapping("/customer/all")
	public List<Customer> findAllCustomer() {
		return cDao.findAll();
	}

	// 用id刪除
	@ResponseBody
	@GetMapping("/customer/delete")
	public String deleteById(@RequestParam Integer id) {
		try {
			cDao.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return "無資料";
		}

		return "做了一個刪除";
	}

	// 分頁查詢
	@ResponseBody
	@GetMapping("/customer/page/{pageNumber}")
	public List<Customer> findByPage(@PathVariable Integer pageNumber) {
		// 從哪頁開始 預設為0;一頁幾筆資料;排序方式
		Pageable pgb = PageRequest.of(pageNumber - 1, 2, Sort.Direction.ASC, "id");
		Page<Customer> page = cDao.findAll(pgb);
		List<Customer> list = page.getContent();
		return list;
	}

// 根據名字查詢 (需先在CustomerRepository加query)
	// 查詢單筆(不可同名)
//	@ResponseBody
//	@GetMapping("/customer/name")
//	public Customer findCustomerByName(@RequestParam String name) {
//		return cDao.findCustomerByName(name);
//	}

	// 查詢多筆同名
	@ResponseBody
	@GetMapping("/customer/name")
	// 用List回傳多筆同名資料
	public List<Customer> findCustomerByName(@RequestParam String name) {
		return cDao.findCustomerByName(name);
	}

	@ResponseBody
	@GetMapping("/customer/name2") // value name丟往String name再往repository :name
	public List<Customer> findCustomerByName2(@Param(value = "name") String name) {
		return cDao.findCustomerByName(name);
	}

	@ResponseBody
	@GetMapping("/customer/name3")
	public List<Customer> findCustomerByName3(@Param(value = "name") String name) {
		return cDao.findCustomerByName(name);
	}

	@ResponseBody
	@GetMapping("/customer/delete/{id}")
	public boolean deleteByid(@PathVariable Integer id) {
		cDao.deleteCustomerById(id);
		return true;
	}
	
	@ResponseBody
	@GetMapping("/customer/level/{level}")
	public List<Customer> findByLevel(@PathVariable Integer level){
		return cDao.findByLevelOrderById(level);
	}
}
