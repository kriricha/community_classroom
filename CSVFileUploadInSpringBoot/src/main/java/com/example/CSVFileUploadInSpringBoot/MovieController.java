package com.example.CSVFileUploadInSpringBoot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

@RestController
public class MovieController<CsvParserSettings, CsvParser> {
@Autowired
MovieRepository service;

@PostMapping("/upload")
public List<MovieDetails> uploadCsvData(@RequestParam("file") MultipartFile file) throws IOException, CsvException {
	try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

		// create csv bean reader
		CsvToBean<MovieDetails> csvToBean = new CsvToBeanBuilder<MovieDetails>(reader).withType(MovieDetails.class)
				.withIgnoreLeadingWhiteSpace(true).build();

		// convert `CsvToBean` object to list of users
		List<MovieDetails> users = csvToBean.parse();

		System.out.println("done");

//		return users;
		service.saveAll(users);

	} catch (Exception ex) {
		ex.printStackTrace(); // Log the exception
	}
	return null;
	
	

}


}
