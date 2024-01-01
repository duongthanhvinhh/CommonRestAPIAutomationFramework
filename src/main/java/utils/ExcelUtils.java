package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ExcelUtils {

    public static List<LinkedHashMap<String,String>> getExcelDataAsListOfMap(String excelFileName, String sheetName) throws IOException {

        List<LinkedHashMap<String,String>> dataFromExcel = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(new File("src/test/resources/testdata/" + excelFileName + ".xlsx"));
        Sheet sheet = workbook.getSheet(sheetName);
        int totalRows = sheet.getPhysicalNumberOfRows();
        List<String> allKeys = new ArrayList<>();
        LinkedHashMap<String,String> mapData;
        DataFormatter dataFormatter = new DataFormatter();
        for (int i = 0; i < totalRows; i++){
            mapData = new LinkedHashMap<>();
            if (i==0){
                int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
                for (int j = 0; j < totalCols; j++){
                    allKeys.add(sheet.getRow(0).getCell(j).getStringCellValue());
                }
            } else {
                int totalCols = sheet.getRow(i).getPhysicalNumberOfCells();
                for (int j = 0; j < totalCols; j++){
                    String cellValue = dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));

                    //handle in case user want to get random data by put Random in the excel file
                    if (cellValue.contains("Random")){
                        cellValue = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FULLNAME);
                    }

                    mapData.put(allKeys.get(j),cellValue);
                }
                dataFromExcel.add(mapData);
            }
        }
        dataFromExcel = dataFromExcel.stream().filter(keyValuePair -> keyValuePair.get("Enabled").equalsIgnoreCase("Y")).collect(Collectors.toList());
        return dataFromExcel;
    }
}
