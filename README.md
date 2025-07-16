               # Android Calculator App UI Test Automation for Pixel 9 Pro Emulator (Espresso)

This repository contains an automated UI test suite for a simple Android Calculator application. The tests are developed using **Espresso**,
Google's official UI testing framework for Android, and **JUnit**. This project demonstrates robust mobile test automation practices, including
handling dynamic UI elements and ensuring test stability across multiple scenarios. 

## Key Features & Test Scenarios

This test validates various functionalities of the Calculator app, covering both basic and scientific operations, and demonstrates resilience
to common UI challenges. 

* **Basic Arithmetic Operations:**
    * Addition (`2 + 2 = 4`)
    * Subtraction (`3 - 1 = 2`)
    * Multiplication (`5 * 8 = 40`)
    * Division (`20 / 4 = 5`)
* **Chained Operations:** Verifies multi-step calculations (`60 + 5 - 10 = 55`)
* **Decimal Point Handling:** Ensures correct input and calculation with decimal numbers (`2.5 + 3.2 = 5.7`)
* **Clear Functionality:** Tests the 'Clear' button to ensure the display resets correctly.
* **Percentage Calculation:** Validates percentage operations (`10 * 50% = 5`).
* **Scientific Calculator Functions (Landscape Mode):**
    * Trigonometric functions (`sin(90) = 1`)
    * Power/Square functions (`sqrt(25) = 5`) 

## Technologies Used

* **Espresso:** Google's official UI testing framework for Android.
* **Java:** Primary programming language for test development.
* **JUnit:** Testing framework for structuring and running tests.
* **Android Studio:** Integrated Development Environment (IDE).
* **Gradle:** Build automation tool.
* **Android Emulator:** For simulating various Android devices (Pixel 9 Pro).

## Key Learnings & Challenges Overcome

Developing this test suite involved navigating several common challenges in mobile test automation, which provided valuable insights into creating robust and reliable tests:

* **Gradle & Android Gradle Plugin (AGP) Compatibility:** Successfully updated an older project's build configuration to be compatible with modern Android Studio versions, resolving `NoSuchMethodError` and `Namespace not specified` errors.
* **Dynamic UI Element Handling (First Run Pop-up):** Implemented a robust strategy to conditionally dismiss a "First Run" update pop-up that randomly appeared on app launch. This involved:
    * Overcame flakiness due to a random 'First-run' pop-up by discovering its underlying `isFirstRun` logic and `setCancelable(false)` property. This led to implementing a precise click on its 'Ok' button within a `try-catch` block, ensuring reliable test continuation. 
    * Understanding `setCancelable(false)` implications (preventing `pressBack()` dismissal).
* **Test Isolation & Flakiness:** Addressed test flakiness experienced when running multiple tests concurrently. This was resolved by:
    * Understanding the importance of independent test methods to prevent shared state issues.
* **Precise UI Element Identification:** Utilized **Android Studio's Layout Inspector** extensively to accurately identify UI element IDs and their exact text content (e.g., `newNumber` for the result display, and the precise text of the "Ok" button), crucial for reliable Espresso matchers.
* **Device Configuration Testing:** Integrated device rotation into tests to validate UI behavior and functionality in different orientations (e.g., accessing scientific calculator features in landscape mode).

## Setup and Run Instructions

To run these tests locally, follow these steps:

1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/jdanielv00/Android-Calculator-Espresso-Tests.git](https://github.com/jdanielv00/Android-Calculator-Espresso-Tests.git)
    ```
2.  **Open in Android Studio:**
    * Launch Android Studio.
    * Select `Open` or `Open an existing Android Studio project`.
    * Navigate to the cloned `Android-Calculator-Espresso-Tests` directory and click `Open`.
    * Android Studio will likely prompt you to "Trust Project" and perform a Gradle sync. Allow it to complete.
3.  **Create an Android Virtual Device (AVD):**
    * Go to `Tools > Device Manager` (or `AVD Manager`).
    * Click `Create Device`.
    * Choose a `Pixel 9 Pro` phone profile.
    * Select a recent `Google Play` system image (e.g., API 34+).
    * Click `Finish`.
4.  **Run the Tests:**
    * Ensure your AVD (emulator) is running.
    * In the Project pane, navigate to `app > src > androidTest > java > com.sourav.mohanty.calculator > CalculatorEspressoTest.java`.
    * Click the green "Play" icon next to the `CalculatorEspressoTest` class name to run all tests, or next to an individual `@Test` method to run a specific test.
    * Monitor the "Run" tab at the bottom of Android Studio for test results.

## Contribution

Feel free to fork this repository, explore the code, and suggest improvements or additional test cases!

---