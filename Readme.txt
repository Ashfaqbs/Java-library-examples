import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

// ...

@GetMapping("/createExcel")
public void createExcel(Map<String, Map<String, Integer>> yearTypeCounts, Map<String, Integer> yearTotalCounts) {
    String excelFilePath = "C:\\path\\to\\your\\output\\excel.xlsx";
    
    try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("Counts");
        
        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Year");
        headerRow.createCell(1).setCellValue("Type");
        headerRow.createCell(2).setCellValue("Count");
        
        for (Map.Entry<String, Map<String, Integer>> yearEntry : yearTypeCounts.entrySet()) {
            String year = yearEntry.getKey();
            Map<String, Integer> typeCounts = yearEntry.getValue();
            
            for (Map.Entry<String, Integer> typeEntry : typeCounts.entrySet()) {
                String type = typeEntry.getKey();
                int count = typeEntry.getValue();
                
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(year);
                row.createCell(1).setCellValue(type);
                row.createCell(2).setCellValue(count);
            }
            
            // Add total count row
            Row totalRow = sheet.createRow(rowNum++);
            totalRow.createCell(0).setCellValue(year);
            totalRow.createCell(1).setCellValue("Total");
            totalRow.createCell(2).setCellValue(yearTotalCounts.getOrDefault(year, 0));
        }
        
        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }
        
        System.out.println("Excel file created successfully.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}




















2 / 2

To send an email with two sets of data from different weeks in an HTML table format, you can modify the HTML template to display both sets of data side by side. Here's how you can achieve this:

Create HTML Template: Design an HTML template for the email content. In this template, you will have two separate tables, one for each week's data. Replace YOUR_TABLE_CONTENT_WEEK1 and YOUR_TABLE_CONTENT_WEEK2 with placeholders for the actual table content that you will generate dynamically.
html
Copy code
<!DOCTYPE html>
<html>
<head>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
        
        th {
            background-color: #f2f2f2;
        }
        
        .table-container {
            display: flex;
        }
        
        .table {
            flex: 1;
            margin: 10px;
        }
    </style>
</head>
<body>
    <div class="table-container">
        <div class="table">
            <table>
                <tr>
                    <th>Type</th>
                    <th>Year</th>
                    <th>Total</th>
                </tr>
                YOUR_TABLE_CONTENT_WEEK1
            </table>
        </div>
        <div class="table">
            <table>
                <tr>
                    <th>Type</th>
                    <th>Year</th>
                    <th>Total</th>
                </tr>
                YOUR_TABLE_CONTENT_WEEK2
            </table>
        </div>
    </div>
</body>
</html>
Generate Table Content: In your Java code, dynamically generate the table rows and cells for both weeks' data.
java
Copy code
private String generateTableContent(Map<String, Map<String, Integer>> yearTypeCounts, Map<String, Integer> yearTotalCounts) {
    StringBuilder tableContent = new StringBuilder();

    for (Map.Entry<String, Map<String, Integer>> yearEntry : yearTypeCounts.entrySet()) {
        String year = yearEntry.getKey();
        Map<String, Integer> typeCounts = yearEntry.getValue();

        for (Map.Entry<String, Integer> typeEntry : typeCounts.entrySet()) {
            String type = typeEntry.getKey();
            int count = typeEntry.getValue();
            int total = yearTotalCounts.getOrDefault(year, 0);

            tableContent.append("<tr>");
            tableContent.append("<td>").append(type).append("</td>");
            tableContent.append("<td>").append(year).append("</td>");
            tableContent.append("<td>").append(total).append("</td>");
            tableContent.append("</tr>");
        }
    }

    return tableContent.toString();
}
Replace Placeholders in Template: Replace YOUR_TABLE_CONTENT_WEEK1 and YOUR_TABLE_CONTENT_WEEK2 in your HTML template with the dynamically generated table content for both weeks.
java
Copy code
String htmlTemplate = ...; // Load the HTML template from file or string
String tableContentWeek1 = generateTableContent(week1YearTypeCounts, week1YearTotalCounts);
String tableContentWeek2 = generateTableContent(week2YearTypeCounts, week2YearTotalCounts);

String finalHtml = htmlTemplate
    .replace("YOUR_TABLE_CONTENT_WEEK1", tableContentWeek1)
    .replace("YOUR_TABLE_CONTENT_WEEK2", tableContentWeek2);
Sending Email: Use a library like JavaMail to send the email with the HTML content.
java
Copy code
// Configure email properties, session, and create MimeMessage

MimeMessage message = new MimeMessage(session);
MimeMessageHelper helper = new MimeMessageHelper(message, true);

helper.setTo(recipientEmail);
helper.setSubject("Your Data Report");

// Set HTML content
helper.setText(finalHtml, true); // Set true to indicate HTML content

// Send email using JavaMail











Map<String, Map<String, Integer>> allYearTypeCounts = new HashMap<>();
Map<String, Integer> allYearTotalCounts = new HashMap<>();

// Combine data from last week and this week
allYearTypeCounts.putAll(lastWeekYearTypeCounts);
allYearTypeCounts.putAll(thisWeekYearTypeCounts);
allYearTotalCounts.putAll(lastWeekYearTotalCounts);
allYearTotalCounts.putAll(thisWeekYearTotalCounts);



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

// ...

public void createCombinedExcel(Map<String, Map<String, Integer>> allYearTypeCounts, Map<String, Integer> allYearTotalCounts) {
    String excelFilePath = "C:\\path\\to\\your\\output\\combined_counts.xlsx";

    try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("CombinedCounts");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Type");
        headerRow.createCell(1).setCellValue("Year");
        headerRow.createCell(2).setCellValue("Total");

        for (Map.Entry<String, Map<String, Integer>> yearEntry : allYearTypeCounts.entrySet()) {
            String year = yearEntry.getKey();
            Map<String, Integer> typeCounts = yearEntry.getValue();

            for (Map.Entry<String, Integer> typeEntry : typeCounts.entrySet()) {
                String type = typeEntry.getKey();
                int count = typeEntry.getValue();
                int total = allYearTotalCounts.getOrDefault(year, 0);

                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(type);
                row.createCell(1).setCellValue(year);
                row.createCell(2).setCellValue(total);
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }

        System.out.println("Combined Excel file created successfully.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}


createCombinedExcel(allYearTypeCounts, allYearTotalCounts);









public void createCombinedExcel(Map<String, Map<String, Integer>> lastWeekYearTypeCounts, 
                                Map<String, Integer> lastWeekYearTotalCounts,
                                Map<String, Map<String, Integer>> thisWeekYearTypeCounts,
                                Map<String, Integer> thisWeekYearTotalCounts) {
    String excelFilePath = "C:\\path\\to\\your\\output\\combined_counts.xlsx";

    try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("CombinedCounts");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Year");
        headerRow.createCell(1).setCellValue("Total Dental (Last Week)");
        headerRow.createCell(2).setCellValue("Total Medical (Last Week)");
        headerRow.createCell(3).setCellValue("Total Dental (This Week)");
        headerRow.createCell(4).setCellValue("Total Medical (This Week)");

        for (String year : lastWeekYearTotalCounts.keySet()) {
            int lastWeekDental = lastWeekYearTypeCounts.getOrDefault(year, new HashMap<>()).getOrDefault("Dental", 0);
            int lastWeekMedical = lastWeekYearTypeCounts.getOrDefault(year, new HashMap<>()).getOrDefault("Medical", 0);
            
            int thisWeekDental = thisWeekYearTypeCounts.getOrDefault(year, new HashMap<>()).getOrDefault("Dental", 0);
            int thisWeekMedical = thisWeekYearTypeCounts.getOrDefault(year, new HashMap<>()).getOrDefault("Medical", 0);

            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(year);
            row.createCell(1).setCellValue(lastWeekDental);
            row.createCell(2).setCellValue(lastWeekMedical);
            row.createCell(3).setCellValue(thisWeekDental);
            row.createCell(4).setCellValue(thisWeekMedical);
        }

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }

        System.out.println("Combined Excel file created successfully.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

