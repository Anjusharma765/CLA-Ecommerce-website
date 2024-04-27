package com.product.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.product.model.Product;
import com.product.model.User;

import com.product.service.ProductServiceImpl;

import jakarta.servlet.http.HttpServletResponse;


@RestController           
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/req")
public class ProductController {
	//*********Autowiring service class
   @Autowired
   private ProductServiceImpl productService;
   private String path="C:\\Users\\sgorkhe\\Desktop\\09-04case-studyUpdate\\Product_Management_Backend 4\\Product_Management_Backend 4\\Product_Management_Backend\\src\\main\\resources\\static\\image";
 
  
 //*******************************ADD PRODUCT*************************************************//

   @PostMapping("/saveProduct")
   public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
       Product savedProduct = productService.saveProduct(product);
       if (savedProduct != null) {
           return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
       } else {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }

          
      
  //****************************UPLOAD IMAGE*********************************************//
	 
	  @PostMapping("/saveImage")
	 public ResponseEntity<String> uploadImage( @RequestParam("file") MultipartFile image) {
	     try {   
		 productService.uploadImage( image);
			}
	     catch(Exception e) {
	    	 e.printStackTrace();
	     }
	     return ResponseEntity.status(HttpStatus.OK).body("Image uploaded successfully");
	    }
	 
	 
//**************************************************************************************//


//************************Fetch Image****************************************************//
	@GetMapping(value="/images/{imageName}" ,produces=MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable("imageName")String imageName,HttpServletResponse response) throws IOException {
		
		
		InputStream resource=this.productService.getResource(path, imageName);
		
		
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		
		StreamUtils.copy(resource, response.getOutputStream());
		
		
		
	}

 //************************For Fetching All  The Product*****************************//
  
	@GetMapping("/getAllProducts")
  public ResponseEntity<List<Product>>getAllProducts(){
	  return new ResponseEntity<List<Product>>(productService.getAllProduct(),HttpStatus.OK);
  }
  
  //************************For Fetching Product By Id*********************************//
  
	
  @GetMapping("/getProductById/{id}")
  public ResponseEntity<Product>getProductById(@PathVariable int id){
	  return new ResponseEntity<Product>(productService.getProductById(id),HttpStatus.OK);
  }
  
  
  //***********************For Deleting Product****************************************//
  
  @DeleteMapping("/deleteProduct/{id}")
  public ResponseEntity<String>deleteProduct(@PathVariable int id){
	  return new ResponseEntity<String>(productService.deleteProduct(id),HttpStatus.OK);
	  }
  
  
  //********************For Updating Product***************************//
  @PutMapping("/updateProduct/{id}")
  public ResponseEntity<Product>updateProduct(@RequestBody Product product,@PathVariable int id){
	  return new ResponseEntity<Product>(productService.updateProduct(product, id),HttpStatus.OK);
  }
  
  //*********************For Getting User By Id***********************//
  
  @GetMapping("/view/{userId}")
  public ResponseEntity<?> getUserById(@PathVariable int userId){
	  return productService.getUserInProduct(userId);
  }
  
  
  //******************For Getting All Users*******************************//
  @GetMapping(path = "/getAllUsers")
  public ResponseEntity<?> getAllUsers(){
	  return productService.getAllUsers();
  }



}
  
  
  
  
  
  
  
  
  
  
  
  
  
  

