# Bug Report

## Overview
This document outlines the identified issues found during testing of the application. Each bug includes a description, steps to reproduce, expected result, and actual result.

---

## 1. Amenities Navigation Link Not Working

**Description:**  
The "Amenities" navigation link does not redirect or scroll to any section.

**Steps to Reproduce:**
1. Open the application
2. Click on the "Amenities" link in the navigation bar

**Expected Result:**  
User should be navigated or smoothly scrolled to the Amenities section.

**Actual Result:**  
Nothing happens when the link is clicked.

---

## 2. Booking Date Validation Missing

**Description:**  
The booking form accepts invalid or incorrectly formatted dates.

**Steps to Reproduce:**
1. Navigate to the booking section
2. Enter invalid date formats (e.g., "abc", "12345", or past dates)
3. Submit the form

**Expected Result:**  
The system should validate date inputs and reject invalid formats with an appropriate error message.

**Actual Result:**  
The system accepts any date format without validation.

---

## 3. Poor Form Validation Feedback

**Description:**  
Forms do not provide clear validation feedback when incorrect data is entered.

**Steps to Reproduce:**
1. Navigate to any form (e.g., contact or booking form)
2. Enter invalid or incomplete data
3. Submit the form

**Expected Result:**  
Clear validation messages should indicate what fields are incorrect and why.

**Actual Result:**  
No helpful error messages are displayed, making it unclear what needs to be corrected.

---

## 4. Navigation Links Do Not Scroll Consistently

**Description:**  
Navigation links do not consistently scroll to the correct sections.

**Steps to Reproduce:**
1. Click different navigation links multiple times

**Expected Result:**  
Each link should consistently scroll to its corresponding section.

**Actual Result:**  
Scrolling behavior is inconsistent or does not work every time.

---

## 5. Contact Form Submissions Not Visible in Admin

**Description:**  
Submitted contact form data does not appear in the admin messages section.

**Steps to Reproduce:**
1. Fill in and submit the contact form
2. Check the admin messages/dashboard

**Expected Result:**  
Submitted messages should be visible in the admin panel.

**Actual Result:**  
No messages are displayed in the admin panel.

---

## 6. Login Button Unresponsive

**Description:**  
The login button intermittently does not respond when clicked.

**Steps to Reproduce:**
1. Navigate to the login page
2. Enter valid credentials
3. Click the login button

**Expected Result:**  
User should be logged in or receive feedback if credentials are incorrect.

**Actual Result:**  
Button sometimes does nothing when clicked.

---

## 7. "Book Now" Button Not Working

**Description:**  
The "Book Now" button in the hero section does not trigger any action.

**Steps to Reproduce:**
1. Open the homepage
2. Click on the "Book Now" button in the hero section

**Expected Result:**  
User should be redirected to the booking section or page.

**Actual Result:**  
No action occurs when the button is clicked.

---

## Conclusion

The application has multiple usability and functional issues, particularly around navigation, form validation, and user interaction. These should be prioritized to improve user experience and system reliability.