package com.product.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.product.exception.ResourceNotFoundException;
import com.product.external.services.UserService;
import com.product.model.Product;
import com.product.model.User;
import com.product.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{
   
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Product saveProduct(Product product) {

		Product result = productRepo.save(product);
		return result;
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepo.findAll();
	}

	public Product getProductById(int id) {
		
		Product p=productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Product Id", id));
		return productRepo.findById(id).get();
	}

	public String deleteProduct(int id) {
		Product product=productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Product Id", id));
	if(product!=null) {
		productRepo.delete(product);
		return "Product Deleted Successfully";
	}
	return "Something wrong on server";
		
	}

//***********************UPDATE PRODUCT****************************88
	
	public Product updateProduct(Product p, int id) {
	    // Retrieve the existing product from the repository
	    Optional<Product> product = productRepo.findById(id);
	    if(product.isPresent()) {
	    	Product product1= product.get();
	    	product1.setProductName(p.getProductName());
	    	product1.setDescription(p.getDescription());
	    	product1.setPrice(p.getPrice());
	    	product1.setStatus(p.getStatus());
	    	return productRepo.save(product1);
	    	
	    }
		throw new ResourceNotFoundException("Product", "Product Id", id);
	}


		
		//********************IMAGE UPLOAD*******************
	
	  @Transactional(rollbackFor = Exception.class)
	    public void uploadImage(MultipartFile image) throws IOException {
	        // Save the image to a directory
	        File directory = new File("C:\\Users\\ANJALSHA\\Downloads\\Product_Management_Backend 8\\Product_Management_Backend\\src\\main\\resources\\static\\image");
	        if (!directory.exists() && !directory.mkdirs()) {
	            throw new IOException("Failed to create directory for image upload.");
	        }

	        // Construct the file path where the image will be saved
	        String filePath = directory.getAbsolutePath() + File.separator + image.getOriginalFilename();
	        File convertedFile = new File(filePath);

	        // Write the image bytes to the file
	        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
	            fos.write(image.getBytes());
	        }

	        // Save the product with the updated image filename
	        Product product = new Product();
	        product.setImageFilename(image.getOriginalFilename());
	        productRepo.save(product);
	    }



	public ResponseEntity<?> getUserInProduct(int userId){
		return userService.getUserById(userId);
}

	public ResponseEntity<?> getAllUsers(){
		return userService.getAllUsers();
	}
	
	//for getting image
	
	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
	String fullPath=path+File.separator+fileName;
	InputStream is=new FileInputStream(fullPath);
	return is;
	}


//****************************************************************//
		
		
	
  
}
