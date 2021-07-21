# songr
## Architecture 
The programming language was Java to build our web app using by the Spring MVC Data and Thymeleaf.  
Author:**Amara Al Balkhi**  
## Lab-11: Build Application
### Overview 
This lab about how to build web application with the Spring MVC Data and Thymeleaf. 
### Routers: 
#### HelloController
* @GetMapping("/hello") String helloWorld(): Go to the hello.html to display the result on the web app. 
* @GetMapping("/capitalize/{id}") String hello(Model model, @PathVariable("id") String id): This router goes to the HelloWorld.html page to display the result in uppercase style. 
#### AlbumController
* @GetMapping("/albums") public String. This is router goes to the album.html page to display the albums that we want. 

### Album class
Create a constructor that contains properities follows as:
* String title;
* String artist;
* int songCount;
* private long length;
* private String imageUrl;
> These properties that I have used to save the data for every album.
