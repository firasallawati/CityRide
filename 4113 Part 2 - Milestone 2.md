# IY4113 Part 2 Milestone 3

| Assessment Details | Please Complete All Details                                           |
| ------------------ | --------------------------------------------------------------------- |
| Group              | A                                                                     |
| Module Title       | IY4113 Applied Software Engineering using Object-Oriented Programming |
| Assessment Type    | P466146                                                               |
| Module Tutor Name  | Jonathan Shore                                                        |
| Student ID Number  | P466146                                                               |
| Date of Submission |                                                                       |
| Word Count         |                                                                       |
| GitHub Link        | https://github.com/firasallawati/T0466146_Firas_4113                  |

- [x] *I confirm that this assignment is my own work. Where I have referred to academic sources, I have provided in-text citations and included the sources in
  the final reference list.*

- [x] Where I have used AI, I have cited and referenced appropriately.

---

### Research

---

Conduct research to support your coding process, including use of code examples, tutortials, documentation and AI tools (if used).

Use the structure below to capture your evidence:

---

**Research 1 -**

**Title of research:** Writing / Reading JSON Files using .Gson & .GsonBuilder

**Reference (link):** [Read and Write JSON to File using Gson - Mkyong.com](https://mkyong.com/java/read-and-write-json-to-file-using-gson/)

**How does the research help with coding practise?:**

This research is helpful because it provides a great insight & demonstration on how to use the code required to save and load a rider's profile in CityRide Lite. It explains how a Java object can be turned to JSON and stored in a file before being retrieved from the file and turned back to a Java object, which matches the profile save / load requirement that the program must have in the brief. It also helps with file persistence, which should be met according to the brief of the project. This is also helpful regarding persistence of files, which is a crucial aspect since the project is not in-memory any more as it used to be during Part 1.

**Key coding ideas you could reuse in your program:**

- Creating a 'RiderProfile' object and converting it to JSON when the user saves their profile.

- Reading the JSON file back into a 'RiderProfile' object when the user loads a saved profile.

- Using 'GsonBuilder' with 'setPrettyPrinting()'' so the JSON file is easier to read and debug if needed.

- Storing profile details such as name, passenger type, and default payment option in one structured file.

- Reusing the same pattern later for config data or saved journey data if needed.

**Screenshot of research:**

<img title="" src="ReadJava.png" alt="IMAGE" width="405">

<img title="" src="WriteJava.png" alt="" width="395">

---

**Research 2 -**

**Title of research:** .TypeToken

**Reference (link):** [Gson TypeToken With Dynamic List Item Type | Baeldung](https://www.baeldung.com/gson-typetoken-dynamic-list-item-type)

**How does the research help with coding practise?:**

This research is very helpful and important since it describes the way 'TypeToken' is used by Gson during loading JSON into generic Java collections like lists / arrays. In Java, generic type information is removed at runtime, therefore, Gson library could not determine the actual types of objects which should be created when reading a JSON array without a 'TypeToken'. This makes the research relevant to CityRide Lite since it may be needed to load the lists of journeys or any other records from JSON files instead of a single object.

It also improves coding practice because it goes beyond basic JSON reading and introduces a more object-oriented way of handling saved data. With the help of 'TypeToken', it is possible to convert JSON arrays into Java collections like 'List' without manually rebuilding the records. This is useful for Milestone 2 because the project requires the rider’s journeys and settings to be stored between sessions, and that kind of data is likely to be easier to manage in a collection.

**Key coding ideas you could reuse in your program:**

- Use 'TypeToken' when reading a JSON array into a 'List'' or 'List'.

- Combine 'Gson' with 'TypeToken' to load multiple saved records from one file instead of only one object at a time.

- Store journeys in a collection so they can be added, edited and deleted much more easier.

- Use typed lists to support summary calculations such as totals, averages, and category counts after the JSON file has been read.

**Screenshot of research:**

<img src="JavaToken.png" title="" alt="" width="506">

---

**Research 3:**

**Title of research:** Error Handling For Corrupted Or Broken CSV Files

**Reference (link):** https://stackoverflow.com/questions/62452458/how-can-i-handle-invalid-data-rows-using-custom-exceptions-in-java

**How does the research help with coding practise?:**

The research is very useful since it provides ways to detect and handle the invalid rows in a CSV file and to not make the entire program fail in the process of doing so. It applies to the CityRide Lite program since it requires importing journeys through CSV and there is always a possibility that a file may contain missing values, unexpected formats, or invalid data such as incorrect zones or passenger types. It also demonstrates and shows how custom exceptions can be used to make the error handling more specific and easier to understand, which is helpful when building a fully functioning and professional program.

It helps with coding practice since it is not just about reading the file but also about making the process of importing safer. Instead of assuming that all the rows of the CSV are valid, the code can detect them and react accordingly.

**Key coding ideas you could reuse in your program:**

- Create a custom exception for invalid CSV journey rows.

- Validate each row during import before turning it into a 'Journey' object.

- Show where and in which specific line the error was caused so that the user knows what went wrong and where.

- Decide whether the program should stop the import immediately or skip the bad row and continue with valid rows.

- Use the same validation logic for fields such as zones, passenger type, date/time, and other journey data.

**Screenshot of research:**

<img src="JavaError.png" title="" alt="" width="506">

---

### Program Code

---

*Program code goes here:*

---

### Updated Gantt Chart

---

IMAGE

---

### Diary Entries (at least 4)

---

*Add diary entries here detailing what you have done, wny you have done it, and any problems encountered.*

---
