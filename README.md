Instructions to execute the automation script
1.	From the shared Git location download the zipfile .
2.	Unzip the folder
3.	Replace the ‘baseUrl’ in ‘global.properties’ with the new mock service url which will be created using ‘APITestingYolo.postman_collection.JSON’
4. Run mvn clean
5. Run mvn install and the project should be ready
6. Execute the APITest.java class and view the results