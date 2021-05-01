# Smart-Toilet-Management-System
Object Oriented Programming MINI PROJECT

Instructions for schema and table generation


-> 	For schema generation and table, there is no extra effort needed for execution 
	of any type of scripts.Because We have added that in the code itself, 
	so that it creates an EMBEDDED DATABASE if there is no database.
	With the help of some derby library files ( that we have included in the project folder itself ), 
	I have created a DatabaseHandler ( included this into the code ),
	It creates a table in the database also if there is no table or the database folder is missing
	The names of database is  'database' and the tables present are:
		■	LOGIN
		■	MAINTENANCE
		■	TOILET
		■	THRESHOLD
		■	TL01 …..  TL24
		■	TL01M …… TL24M



Instructions for execution and specific requirements


-> 	The folder named 'ToiletManagement' is the project folder.

->	All the codes of classes are present in the packages of the 'src' folder of the project folder itself.

->	We have provided the shortcut of the executable jar file in the zip file itself.

->	But actually the excecutable jar file named 'ToiletManagement.jar' is located in the 'dist' folder of the project folder.

Note:   If ‘database’ folder is missing in the 'dist' folder. Run the jar file first then close it .This will create a ‘database’ folder
 	in the 'dist' folder along with some readme files . Then replace the ‘database’ folder in 'dist' folder (/ToiletManagement/dist) with 
	the ‘database’ folder from root folder of the project (/ToiletManagement/database)

ABOVE IS NOT NECESSARY BUT FOR BETTER USAGE OF THE PROJECT PLEASE COMPLY . 

->	While registration please enter 'A VALID EMAIL ID'.


SYSTEM REQUIREMENTS


* Operating System: Any 
* jdk latest version 
* Proper internet connection .
* Email account of user ( Not a system requirement , but still ) .

Guide to use the Smart Toilet Management System project


->	Open the jar file using 'java openjdk platform binary' to run the jar file.

->	The registration button in the MAIN MENU redirects you to the REGISTRATION PAGE.

->	While registration please enter 'A VALID EMAIL ID'.

->	In the REGISTRATION PAGE after entering your details and submitting, it will send a confirmation
        code which you will need to register . Following this you will also receive an email regarding successful registration.
	While registration please enter 'A VALID EMAIL ID', you can't register with the same email id for more than one time.

->	Sending the Mail will take sometime so be Patient

->	After Registartion you will be redirect to LOGIN PAGE

->	Enter the UNIQUE ID provided in the MAIL and Name for LOGIN

-> 	After logging in Successfully you will be redirected to the Cleaning System Page.

->	Cleaning System Page displays the NTU and MQ2 of Toilets Present [Bottom Table Presents Current Values and Status]
	[TOP Table Presents log of Values of tables with time]

->	You can NAVIGATE to any page once you have loggged In .

-> 	Maintenance System Page This page contains information regarding the consumables like hand wash liquid dispenser ,
 	tissue towel quantity along with toilet paper quantity (Quantity in Grams) . It also contains the percentage of trash bin
 	occupied . Toilet codes with red color denote either any of the consumables are empty / less or the trash bin is full / about to be filled .
	Table at top denotes the values of every consumable and trash at particular time intervals while the bottom table
 	contains current values of consumables and trash capacity


->	UPDATING INFORMATION can be done from MAIN PAGE or after Login too.

->	First Confirm Your Login Identity By providing the Fields and PRESSING THE TICK BUTTON

->	Below Fields will automatically filled if ID is confirmed . CHANGE any VALUES and click the RIGHT ARROW to VERFIY and UPDATE

->	DELETE ACCOUNT : Log In first go to UPDATE INFO Page . Click on the Blue Question Icon (TOP RIGHT) 
	CONFIRM IDENTY TO DELETE the Account

->      After Account Deletion You will be Directed to THE MAIN PAGE .


FEATURES


* Registration of user 
* Updation of user details
* Login feature.
* Mailing Functionality which uses the jar files named activation.jar , javax.mail.jar .
* Color Gradient Funtionality which uses KGradientPanel.jar
* The Personal Details in the registration will automatically be sent to the user to the provided Email ID.
* Display Tables directly from Database which uses rs2xml.jar 
* Checking status of Toilets.
* Maintenance of Toilets
* Display log of Sensor Values of all the Toilets for Cleaning and Maintenance
* Changing of Threshold NTU and MQ2 Values as per requirement .
 

DEVELOPMENT TOOLS


* Java GUI Frameworks such as Swing & AWT API.
* Java Derby Database 
* Abstract Window Toolkit
* Extra Libraries:- 
	( Already exist in the project folder itself )
	used for Mail Functionality, creating an embedded database.
* Use the netbeans or any similar platform and open the project folder named ‘ToiletManagement’ for further development.

