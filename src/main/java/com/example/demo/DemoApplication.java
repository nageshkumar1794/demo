package com.example.demo;

import com.example.demo.ehr.CaseReportPipeline;
import com.example.demo.ehr.Customer;
import com.example.demo.ehr.PracCollection;
import com.example.demo.override.*;
import com.example.demo.port.CalculateInterest;
import com.example.demo.port.Line;
import com.example.demo.port.PortThread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		List<Customer> customers = Arrays.asList(
				new Customer("Nagesh", "Kumar", 201),
				new Customer("Akhil", "Kumar", 202),
				new Customer("Kavya", "Shri", 203),
				new Customer("Nagesh", "Kumar", 204), // Duplicate
				new Customer("Shri", "Kavya", 205),
				new Customer("Akhil", "Kumar", 206) // Duplicate
		);

		List<Customer> customersList2 = Arrays.asList(
				new Customer("Unique", "Person", 207),
				new Customer("Another", "Unique", 208),
				new Customer("Kavya", "Shri", 209), // Duplicate
				new Customer("Different", "Person", 210),
				new Customer("Nagesh", "Kumar", 211), // Duplicate
				new Customer("Akhil", "Kumar", 212) // Duplicate
		);

		List<Customer> combinedList = new ArrayList<>(customersList2);
		combinedList.addAll(customers);

		PracCollection pracCollection = new PracCollection(customers);
		pracCollection.printNames();
		pracCollection.convertToSet();

		Set<Customer> set1 = new LinkedHashSet<>(customers);

		set1.addAll(new LinkedHashSet<>(customersList2));
		System.out.println("Combined Set after removing duplicates: " + set1);


		set1.stream().sorted(Comparator.comparing(Customer::getFirstName).thenComparing(Customer::getLastName)).forEach(System.out::println);

		List<Customer> finalList = set1.stream().collect(Collectors.toList());

		finalList.stream().sorted(Comparator.comparing(Customer::getFirstName).thenComparing(Customer::getLastName)).forEach(System.out::println);

		System.out.println("Creating Map from List:");
		Map<Integer, Customer> customerMap = new HashMap<>();
		for (Customer customer : finalList) {
			customerMap.put(customer.getId(), customer);
		}
		System.out.println("Customer Map: " + customerMap);

		System.out.println("Using Key Set:");

		customerMap.keySet().stream().sorted().forEach(key -> {
			System.out.println("Key: " + key + ", Value: " + customerMap.get(key));
		});


		Customer combinedCustomer = new Customer("Combined", "Customer", 999);
		int[] numbersvar = {1,2,3,4,5,10,12,20};
		int[] duplicate;
		duplicate = numbersvar;

		numbersvar = new int[]{100,200,300};

		combinedCustomer.doSomething(1,'x', "Shrimayi", duplicate);
		combinedCustomer.doSomething(1,'x', "Shrimayi", numbersvar);

		System.out.println("Using Entry Set:");
		customerMap.entrySet().stream().forEach(entry -> {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		});

		// Another way to remove duplicates

		List<Customer> mylist = new ArrayList<>(new HashSet<>(combinedList));



		System.out.println("Final List after removing duplicates: ");
		mylist.forEach(System.out::println);

//		Set<Customer> myset = new TreeSet<>(combinedList);

//		System.out.println("Final Set after removing duplicates using TreeSet: ");
//		myset.forEach(System.out::println);

//		CalculateInterest ci = new CalculateInterest(12, 5, 10000);

//		ci.computeComplexArea();

		//  ------------------------------------

//		SpringApplication.run(DemoApplication.class, args);

//		System.out.println("hello");
//		Test1 t1 = new Test1();
//		t1.genMeth();
		//  ------------------------------------
//		Logg ll = new LoggDer();
//		ll.logs("my Name is Nagesh");
//		ll.logs("   Level 2", "This is method overloading");
//		ll.logs("  Here is the exception", new Exception("  This is Exception"));
//		ll.logs(" Primitive Conversion" , 5);
//		ll.logsDer(5.5, 5);
//		ll.toString();
//
//		//  ------------------------------------
		Car onlyCar = new Electric("Auto", "Ford");
		String name = onlyCar.start();

		Car defaultCat = new Gas("Manual", "Chevy");
		defaultCat.stop();

		System.out.println("Name returned is " + name);

		onlyCar.changeGear();
//
		Car myCar1 = new Gas("Gear", "Honda");
		Car myCar2 = new Electric("Auto", "Tesla");

		myCar1.doOperations();
		System.out.println(myCar1.toString());

		myCar2.doOperations();
		System.out.println(myCar2.toString());

		//  ------------------------------------


//		lines.forEach(line->{
//			PortThread port = new PortThread(line);
//			Thread thread = new Thread(port); // Step 2: Pass it to Thread constructor
//			thread.start();
//		});
//
//		String fileName = "thread_outpu.txt";
//		Examone displayFile = new Examone(fileName);
//		List<Line> act_lines = Arrays.asList(
//				new Line("nag", "NYC", "9452679109"),
//				new Line("Akhil", "DFW", "8052982812"),
//				new Line("KAV", "DEN", "9452976143"),
//				new Line("Shri", "LA", "9452976153"));
//
//		ExecutorService executor = Executors.newFixedThreadPool(act_lines.size());
//		for (Line var : act_lines) {
//			executor.submit(() -> {
//				try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
//					writer.write(Thread.currentThread().getName() + ": " + var.toString() + "\n");
//					writer.flush(); // make sure data is actually written
////					System.out.println(Thread.currentThread().getName() + " finished writing");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			});
//		}
//		executor.shutdown();
//
//		try {
//			displayFile.readFile();
//		} catch (IOException e) {
//			System.out.println("caught..exception");
//		}
		//-------------------------------------------------------------------------------

//		HL7FunctionalParser parser = new HL7FunctionalParser();
//		parser.ParseHL7();
//
//		CaseReportTransformer transformer = new CaseReportTransformer();
//		transformer.transform();
//
//		CaseReportPipeline crp = new CaseReportPipeline();
//		crp.casereport();

	}
}
