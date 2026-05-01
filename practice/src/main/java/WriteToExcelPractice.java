import utils.WriteToExcelUtil;


public class WriteToExcelPractice {
    public static void main(String[] args) throws Exception {

    	WriteToExcelUtil excel = new WriteToExcelUtil("testdata.xlsx", "Sheet1");

        excel.writeData(0, 0, "Username");
        excel.writeData(0, 1, "Password");

        excel.writeData(1, 0, "admin");
        excel.writeData(1, 1, "admin123");

        excel.save();

        System.out.println("Data written successfully!");
    }
}