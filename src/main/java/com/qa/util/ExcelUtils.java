package com.qa.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：表格操作
 * @ Author：duzhengjun
 * @ dateTime：2020/5/1 11:50
 */
public class ExcelUtils implements Iterator {
    //数据流：excel-->map-->Iterator<Object>-->DataProvider-->dateProvider

    int currentRow = 0;         //当前行
    int rowNumber = 0;          //总行数
    Sheet sheet = null;         //工作表
    int columnNumber = 0;       //总列数
    String title[] = null;      //用来存表头的数组

    //构造方法
    public ExcelUtils(String fileName) {
        readExcel(fileName);
    }

    public void readExcel(String fileName) {

        //根据文件路径获取Excel文件I/0流
        FileInputStream fileInputStream = null;
        Workbook workbook = null;
        try{
            //FileNotFindException(子类) -extends-> IOException (父类)
            fileInputStream = new FileInputStream("testdata/"+fileName+".xlsx");
            //I0Exception
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //工作表
        sheet = workbook.getSheet("Sheet1") ;
        //表头
        Row row = sheet.getRow(currentRow);
        //总行数
        rowNumber = sheet.getPhysicalNumberOfRows();
        //总列数
        columnNumber = row.getPhysicalNumberOfCells();

        title = new String[columnNumber];

        for (int i=0;i<columnNumber;i++) {
            //获取单元格
            Cell cell = row.getCell(i);
            //设置单元格格式
            cell.setCellType(Cell.CELL_TYPE_STRING);
            //获取单元格的内容
            String value = cell.getStringCellValue();
            //System.out.println(value);
            // 将单元格的内容依次放入表头数组
            title[i] = value;
        }
        currentRow++;
    }

    //判断是否存在下一个对象元素(判断是否继续循环)
    public boolean hasNext(){
        System.out.println("当前行为" + currentRow);
        System.out.println("总行数为" + rowNumber);
        if (currentRow>=rowNumber || rowNumber <=1) {
            return false;
        } else {
            return true;
        }
    }

    //下一个元素
    public Object[] next() {
        Row row = sheet.getRow(currentRow);
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < columnNumber; i++) {
            //获取第二行的单元格
            Cell cell = row.getCell(i);
            // 设置单元格格式
            cell.setCellType(Cell.CELL_TYPE_STRING);
            // 获取单元格数据
            String value = cell.getStringCellValue();
            map.put(title[i], value);
        }
        currentRow++;
        Object[] objects = new Object[1];
        objects[0] = map;
        return objects;
    }

    public void remove(){

    }
}
