pipeline {
 agent any
 tools{
 	jdk 'JDK17'
 	maven 'MAVEN3'
 }
 stages {	
	stage('Maven Compile'){
		steps{
			echo 'Project compile stage'
			sh 'mvn compile'
	       	}
	}
	
	stage('Unit Test') {
	   steps {
			echo 'Project Testing stage'
			sh 'mvn test'
	      
      		}
  	}
	stage('Jacoco Coverage Report') {
       	steps{
           		jacoco()
		}
	}      
     
     
     //stage('SonarQube'){
		//steps{
				//sh 'mvn sonar:sonar \
				//-Dsonar.host.url=http://localhost:9000 \
				//-Dsonar.login=squ_906da0c218c6b84f3b86c894632a3bc814004d51'
			//}
   //	}
   
   stage('build && SonarQube analysis') {
           steps {
               withSonarQubeEnv('sonarqube') {
                 
                       sh 'mvn sonar:sonar'
                 
               }
           }
       } 
 
   
	
	
	stage('Maven Package'){
		steps{
			echo 'Project packaging stage'
			sh 'mvn package'
		}
	} 
	
	
			
  
 }
}

