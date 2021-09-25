# Hibernate-MangaCategory
Pet Project to learn Hibernate

# Commands 	
	mvn clean compile - Compile the Java classes
	mvn exec:java - Execute the program  
	mvn test - Test 
# Tasks 
	
- [x] Return all manga with determinated categories 
- [x] Return all manga in reverse order of alter date 
	
# TODO 
	
Fix the VSCode not debuging 

Forgot about the database and make the class without it 

Change names:
* loadById -> saveById

* AppTest -> HibernateTest 

Who handle session creation ?
* https://stackoverflow.com/questions/9367886/session-management-with-java-hibernate
	* SessionFactory - Expensive 
	* Session - Small unit
	* Transaction - Need 

Make a save method 
	
@Id

@GeneratedValue(strategy=GenerationType.IDENTITY)

private Long id;

Test 

Insert 1 

Insert 1 

Insert 2 

Ids should be 1 and 2 
	
Check if unique is reinforced - ConstraintViolateException

name - nullable false 

OrderCategorys 

https://vladmihalcea.com/how-to-optimize-unidirectional-collections-with-jpa-and-hibernate/"
		
# Sources 
	
	https://docs.jboss.org/hibernate/orm/5.5/userguide/html_single/Hibernate_User_Guide.html