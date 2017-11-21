//package com.softserve.edu.opencart.tests.smoke;
//
//import com.softserve.edu.opencart.data.ProductShort;
//import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
//import com.softserve.edu.opencart.pages.Application;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.Test;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.List;
//
//public class TempTest {
//
//    @AfterClass
//    public void closedr() {
//        Application.remove();
//    }
//
//    @Test
//    public void fileWriter() throws IOException {
//        Application.get(ApplicationSourceRepository.get().chromeServer7());
//        List<ProductShort> list = Application.get().loginAdmin()
//                .validEnterAdminProfile(null)
//                .openProductAdminPage()
//                .getProductShortListAllPages();
//        File file = new File("productlist.txt");
//        FileWriter fw = new FileWriter(file.getAbsoluteFile());
//        BufferedWriter bw = new BufferedWriter(fw);
//        for (ProductShort current : list) {
//            bw.write(current.getName() + "," + current.getModel() + "," + current.getPrice() + ","
//                    + current.getQuantity() + "," + current.getStatusText() + "," + current.getImageText() + "\n");
//        }
//        bw.close();
//    }
//}
