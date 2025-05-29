package com.reward.application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reward.application.entity.CustomerEntity;
import com.reward.application.entity.PurchaseDetailsEntity;
import com.reward.application.repository.CustomerRepository;
import com.reward.application.repository.PurchaseRepository;
import com.reward.application.utility.Utility;

import jakarta.annotation.PostConstruct;
/**
 * This is the main class and starting point of the application.
 * This class is used as configuration class
 */
@SpringBootApplication
public class RewardApplication {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(RewardApplication.class, args);
	}
	
	/**
	 * This method used to store customer-related data into customer details table.
	 */
	@PostConstruct
	public void setCustomerDetails() {
		List<CustomerEntity> list = new ArrayList<>();
		list.add(new CustomerEntity("John", "Pune", 7788899955L, Utility.getDate(2024, Calendar.MAY, 28)));
		list.add(new CustomerEntity("Mery","Mumbai", 7788899956L, Utility.getDate(2023, Calendar.FEBRUARY, 22)));
		list.add(new CustomerEntity("Adrian","Bangalore",7788899957L, Utility.getDate(2022, Calendar.MARCH, 11)));
		list.add(new CustomerEntity("Michael","Hydrabad", 7788899958L, Utility.getDate(2021, Calendar.APRIL, 19)));
		list.add(new CustomerEntity("Lisa","Chennai", 7788899959L, Utility.getDate(2024, Calendar.MARCH, 17)));
		list.add(new CustomerEntity("Jorden","Pune", 7788899960L, Utility.getDate(2024, Calendar.DECEMBER, 31)));
		list.add(new CustomerEntity("David","Hydrabad", 7788899961L, Utility.getDate(2024, Calendar.OCTOBER, 12)));
		list.add(new CustomerEntity("Javed","Delhi", 7788899962L, Utility.getDate(2024, Calendar.DECEMBER, 9)));
		list.add(new CustomerEntity("Salman","Noida", 7788899963L, Utility.getDate(2024, Calendar.APRIL, 7)));
		list.add(new CustomerEntity("Subhash","Kolkata", 7788899964L, Utility.getDate(2025, Calendar.JANUARY, 17)));
		list.add(new CustomerEntity("Rajesh","Surat", 7788899965L, Utility.getDate(2024, Calendar.MARCH, 25)));
		list.add(new CustomerEntity("Arijit","Mumbai", 7788899966L, Utility.getDate(2024, Calendar.FEBRUARY, 22)));
		list.add(new CustomerEntity("Sowmya","Bangalore", 7788899967L, Utility.getDate(2025, Calendar.APRIL, 30)));
		list.add(new CustomerEntity("Jerry","Pune", 7788899968L, Utility.getDate(2024, Calendar.MAY, 2)));
		list.add(new CustomerEntity("Test1","TestCity1", 7788899981L, Utility.getDate(2024, Calendar.MAY, 2)));
		list.add(new CustomerEntity("Test2","TestCity2", 7788899982L, Utility.getDate(2024, Calendar.MAY, 2)));
		customerRepository.saveAllAndFlush(list);
	}
	
	/**
	 * This method used to store product-related data into purchase details table.
	 */
	@PostConstruct
	public void setProductDetails() {
		List<PurchaseDetailsEntity> list = new ArrayList<>();
		list.add(new PurchaseDetailsEntity(1L,"Freez", 180.00, Utility.getDate(2025, Calendar.MAY, 28)));
		list.add(new PurchaseDetailsEntity(2L,"TV", 130.00, Utility.getDate(2025, Calendar.FEBRUARY, 22)));
		list.add(new PurchaseDetailsEntity(3L,"Fan", 40.00, Utility.getDate(2025, Calendar.MARCH, 11)));
		list.add(new PurchaseDetailsEntity(4L,"Washing Machine", 70.00, Utility.getDate(2025, Calendar.APRIL, 19)));
		list.add(new PurchaseDetailsEntity(5L,"TV", 110.00, Utility.getDate(2025, Calendar.MARCH, 17)));
		list.add(new PurchaseDetailsEntity(2L,"Fan", 40.00, Utility.getDate(2025, Calendar.APRIL, 31)));
		list.add(new PurchaseDetailsEntity(3L,"Table", 90.00, Utility.getDate(2025, Calendar.JANUARY, 12)));
		list.add(new PurchaseDetailsEntity(4L,"Laptop", 120.00, Utility.getDate(2025, Calendar.MAY, 15)));
		list.add(new PurchaseDetailsEntity(3L,"Speaker", 130.00, Utility.getDate(2025, Calendar.JANUARY, 29)));
		list.add(new PurchaseDetailsEntity(6L,"Ear Buds", 80.00, Utility.getDate(2025, Calendar.MAY, 9)));
		list.add(new PurchaseDetailsEntity(3L,"Charger", 40.00, Utility.getDate(2025, Calendar.APRIL, 19)));
		list.add(new PurchaseDetailsEntity(2L,"Speaker", 130.00, Utility.getDate(2025, Calendar.MARCH, 27)));
		list.add(new PurchaseDetailsEntity(8L,"Freez", 180.00, Utility.getDate(2025, Calendar.MARCH, 12)));
		list.add(new PurchaseDetailsEntity(8L,"LED", 75.00, Utility.getDate(2025, Calendar.MARCH, 12)));
		list.add(new PurchaseDetailsEntity(9L,"Washing Machine", 70.00, Utility.getDate(2025, Calendar.MAY, 26)));
		list.add(new PurchaseDetailsEntity(10L,"Laptop", 120.00, Utility.getDate(2025, Calendar.MAY, 22)));
		list.add(new PurchaseDetailsEntity(7L,"Laptop", 120.00, Utility.getDate(2025, Calendar.MARCH, 13)));
		list.add(new PurchaseDetailsEntity(8L,"Ear Buds", 80.00, Utility.getDate(2025, Calendar.MARCH, 9)));
		list.add(new PurchaseDetailsEntity(2L,"Mobile", 100.00, Utility.getDate(2025, Calendar.APRIL, 31)));
		list.add(new PurchaseDetailsEntity(5L,"Fan", 40.00, Utility.getDate(2025, Calendar.APRIL, 17)));
		
		list.add(new PurchaseDetailsEntity(15L,"TestProduct1", 1.00, Utility.getDate(2025, Calendar.APRIL, 31)));
		list.add(new PurchaseDetailsEntity(16L,"TestProduct2", -1.00, Utility.getDate(2025, Calendar.APRIL, 17)));
		purchaseRepository.saveAllAndFlush(list);
	}
}
