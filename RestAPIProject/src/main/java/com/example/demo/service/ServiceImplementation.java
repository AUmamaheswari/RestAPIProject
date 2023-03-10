package com.example.demo.service;


import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Library;
import com.example.demo.repository.LibraryRepo;





@Service
//Service class
public class ServiceImplementation implements LibraryServiceInterface {


	LibraryRepo libraryRepo;

	// constructor Injection to libraryRepo
	public ServiceImplementation(LibraryRepo  LibraryRepo, LibraryRepo libraryRepo) {
		this.libraryRepo = libraryRepo;
	}

	//Overriding the methods from service class
	@Override 
	public Library saveLibraryRecords(Library library) {
		return libraryRepo.save(library);
	}

	@Override 
	public List<Library> getRecordsFromDb() {
		return libraryRepo.findAll();	
	}

	@Override
	public Library getBookById(int bookId) {
		Optional<Library> library = libraryRepo.findById(bookId);
		if(library.isPresent()) {
			return library.get();
		}
		else {
			throw new ResourceNotFoundException("Library", "bookId", bookId);
		}
	}

	@Override
	public Library updateLibraryDetails(Library newValue, int bookId) {
		Optional<Library> library = libraryRepo.findById(bookId);
		if(library.isPresent()) {
			Library existingLibRecord = library.get();  
			existingLibRecord.setNoOfCopies(newValue.getNoOfCopies());
			libraryRepo.save(existingLibRecord);
			return existingLibRecord;
		}
		else {
			throw new ResourceNotFoundException("Library", "bookId", bookId);
		}
	}

	@Override
	public void deleteRecordById(int bookId) {
		Optional<Library> library = libraryRepo.findById(bookId);
		if(library.isPresent()) {
			libraryRepo.deleteById(bookId);		
		}
		else {
			throw new ResourceNotFoundException("Library", "bookId", bookId);

		}
	}
}







