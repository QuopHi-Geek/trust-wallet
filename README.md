# Trust Wallet App Test

## Git Repo:  https://github.com/QuopHi-Geek/trust-wallet.git

## Setup and Run

Project contains how to set up the environment and run the automated tests for app test


### Prerequisites

*   **Java Development Kit (JDK)**:  Ensure the "JAVA_HOME" environments are setup 
*   **Apache Maven**: Ensure "mvn" is installed and the "MAVEN_HOME" environment is setup 


### Setup

## Clone the repository
    
    git clone https://github.com/QuopHi-Geek/trust-wallet.git
  


## Install Dependencies:**
    *  'npm install' - to install packages/dependencies in the `pom.xml` 
    *   mvn compile


### Executing Tests

     * 'mvn clean test'  - to run all the tests


### Notes

*   APK file in the project is a dummy since actual APK file is large for git.

*   Replace "app.apk" in the directory "/src/test/resources/app.apk" with the actual APK

*   In the DriverUtils class. Modify the initializeDriver() to suit testing environment. Modify app filepath and other capabilities to suit your testing environment.

    capabilities.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/app.apk");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("platformVersion", "PLATFORM_VERSION");
    capabilities.setCapability("deviceName", "DEVICE_NAME");
