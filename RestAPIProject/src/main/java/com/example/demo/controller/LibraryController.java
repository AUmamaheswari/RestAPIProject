package com.example.demo.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Library;
import com.example.demo.service.ServiceImplementation;

@RestController//@ResponseBody and @Controller
@RequestMapping("/RestAPIproject")
//RestAPIproject/saveLibRecord
public class LibraryController {

	private static Scanner scan=new Scanner(System.in);
  
	// libServ attribute
	public ServiceImplementation libServ;
	// constructor Injection to libServ
	public LibraryController(ServiceImplementation libServ) {
		this.libServ = libServ;
	}

	// Mapping to save the record into the table
	@PostMapping("/saveLibRecord")
	public ResponseEntity<Library> saveLibraryRecords(@RequestBody Library library){
		return new ResponseEntity<Library>(libServ.saveLibraryRecords(library), HttpStatus.CREATED);
	}

	// Mapping to update a record in the table
	@PutMapping("/updateLibrary/{bookId}")
	public ResponseEntity<Library> updateLibraryDetails(@PathVariable("bookId") int id,@RequestBody Library library){
		System.out.println("Enter the bookId you need to update: "); 
		return new ResponseEntity<Library>(libServ.updateLibraryDetails(library,scan.nextInt()), HttpStatus.OK);
	}

	// Mapping to read all the records in the table
	@GetMapping("/readAllRecords")
	public List<Library> getRecordsFromDb(){
		return libServ.getRecordsFromDb();
	}

	//localhost:8080/readRecord/5
	// Mapping to read a particular record using the bookId
	@GetMapping("/readRecord/{bookId}")
	public ResponseEntity<Library>  getBookById(@PathVariable("bookId")  int bookId){
		System.out.println("Enter the bookId you need to display: "); 
		return new ResponseEntity<Library>(libServ.getBookById(scan.nextInt()), HttpStatus.OK);
	}
 
	//Mapping to delete a particular record using the bookId 
	@DeleteMapping("/deleteEmp/{bookId}")
	public ResponseEntity<String> deleteRecordById(@PathVariable("bookId")  int Id){
		System.out.println("Enter the bookId you need to display: "); 
		libServ.deleteRecordById(scan.nextInt());
		return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
	}
}


