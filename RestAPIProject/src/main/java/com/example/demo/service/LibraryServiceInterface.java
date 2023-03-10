package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Library;

public interface LibraryServiceInterface {

	//Interface ---> only method declaration
	//to save the records
	Library saveLibraryRecords(Library library);
	//to read all the records from the table
	List<Library>  getRecordsFromDb();
	//to read book by bookId
	Library getBookById(int BookId);
	//to update the book details by bookId
	Library updateLibraryDetails(Library value, int BookId);
	//to delete the record using bookId
	void deleteRecordById(int BookId);
	
	
}




