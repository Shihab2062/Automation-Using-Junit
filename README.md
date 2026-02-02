# **Selenium Automation & Web Scraping Suite**

**This project contains a series of automated test cases and data extraction scripts developed using Java, Selenium WebDriver, and JUnit.** It demonstrates proficiency in handling complex web elements, file uploads, synchronization, and data persistence.

## 🚀 Project Overview
## The suite is divided into two core automation tasks:

**Webform Automation (Digital Unite):** A complete end-to-end test for a multi-input webform, including file upload handling and success message validation.

**Web Scraping (DSEBD):** A data extraction script that scrapes live stock market data, processes it, and exports it to a structured text file.

## 🛠️ Prerequisites

**Before running the scripts, ensure you have the following installed and configured:**

Java Development Kit (JDK): **Version 8 or higher.**

IDE: **IntelliJ IDEA, Eclipse, or VS Code.**

Dependencies: 
- **Selenium WebDriver (v4.x recommended)**
- **JUnit 5 (Jupiter)**

Browser Drivers: **ChromeDriver or GeckoDriver (Firefox) matching your browser version.**

Test Data: **A sample file (e.g., sample.pdf or image.png) under 2MB for the upload test.**

## 📂 Project Structure

```
├── src/test/java/
│   ├── WebformTest.java        # Task 1: Digital Unite Form Automation
│   └── ScrapData.java          # Task 2: DSEBD Table Scraping
├── data/
│   └── scraped_data.txt        # Output file for scraped stock data
├── build.gradle                # Gradle build configuration
└── README.md                   # Project documentation
```

## 📝 Implementation Details

### 1. Webform Automation

**Target:** Digital Unite Practice Form

**Automated Inputs:** Handled text fields, numbers, dates, and text areas.

**File Upload:** Implemented robotic file path injection for elements of type="file".

**Verification:** Used JUnit Assertions to validate the success message: "Thank you for your submission!"

**Challenge Solved:** Managed synchronization using WebDriverWait to handle page transitions.

### 2. Web Scraping for Stock Prices

**Target:** DSEBD Latest Share Price

**Data Extraction:** Iterated through dynamic web tables using tr and td locators.

**Console Output:** Real-time printing of all cell values for debugging.

**File I/O:** Implemented FileWriter to save the scraped data into a .txt file for permanent storage.

## ⚙️ Setup & Execution

### Clone the Repository:

```bash
git clone https://github.com/Shihab2062/Automation-Using-Junit.git
```

### Configure Build Path:

**Import the project into your IDE.**

**Add Selenium and JUnit libraries to your project dependencies (via Maven or manual JAR addition).**

### Run Tests:

**Right-click WebformTest.java -> Run as JUnit Test.**

**Right-click ScrapData.java -> Run as Java Application/Test.**

