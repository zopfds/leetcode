package leetcode;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/29
 */
public class DealWithProcedure {

    private static HashMap<String,String> openMap = new HashMap<>(16384 * 2);

    public static void main(String[] args) {
        try {
            //获得Workbook工作薄对象
            Workbook workbook = getWorkBook(new File("/Users/jianbopan/Desktop/user.xlsx"));
            //读取每行
            if (workbook != null) {
                for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
                    //获得当前sheet工作表
                    Sheet sheet = workbook.getSheetAt(sheetNum);
                    if (sheet == null) {
                        continue;
                    }
                    //获得当前sheet的开始行
                    int firstRowNum = sheet.getFirstRowNum();
                    //获得当前sheet的结束行
                    int lastRowNum = sheet.getLastRowNum();
                    //循环除了第一行的所有行
                    for (int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++) { //为了过滤到第一行因为我的第一行是数据库的列
                        //获得当前行
                        Row row = sheet.getRow(rowNum);
                        if (row == null) {
                            continue;
                        }
                        //获得当前行的开始列
                        int firstCellNum = row.getFirstCellNum();
                        if(row.getCell(firstCellNum).getStringCellValue() == null || row.getCell(firstCellNum).getStringCellValue().equals("")){
                            break;
                        }
                        //循环当前行
                        openMap.put(row.getCell(firstCellNum).getStringCellValue() , row.getCell(firstCellNum + 1).getStringCellValue());
                    }
                }
            }

            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File("/Users/jianbopan/Desktop/yywap.txt")));
            openMap.forEach((key , value) -> {
                try {
                    String thisLine = "update t_wechat_push_user_record set user_id = '" + key + "' where mobile = '" + value + "' and (user_id is null or user_id = 'null');";
                    writer.write(thisLine);
                    writer.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Workbook getWorkBook(File file) {
        //获得文件名
        String fileName = file.getName();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = new FileInputStream(file);
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith("xls")){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith("xlsx")){
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }

}
