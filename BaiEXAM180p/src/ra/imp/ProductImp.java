package ra.imp;

import ra.entity.Product;

import java.util.Scanner;

public class ProductImp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product[] productList = new Product[100];
        productList[0] = new Product("001","Kem",100,200,100,20,"SIU SIU NGON",true);
        productList[1] = new Product("002","Kem2",200,400,0,20,"SIU SIU NGON",true);
        productList[2] = new Product("003","Kem3",300,600,0,20,"SIU SIU NGON",false);

  
        do {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    System.out.println("1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)");
                    Product newProduct = new Product();
                    newProduct.input(scanner);
                    for (int i = 0; i < 100; i++) {
                        if ( productList[i] == null) {
                            productList[i] = newProduct;
                            System.out.println("Sản phẩm :" + i);
                            break;
                        }
                    }

                    break;
                case 2:
                    System.out.println("2. Hiển thị thông tin các sản phẩm");            
                    for (int i = 0; i < 100; i++) {
                        if (productList[i] != null) {
                            productList[i].display();
                            System.out.println();
                        }
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("3. Tính lợi nhuận các sản phẩm");
                    System.out.println("Hãy nhập sản phẩm muốn tính lợi nhuận");
                    int selectProduct = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < 100; i++) {
                        if (productList[i] != null && selectProduct == i){
                            float total = productList[i].calProfit();
                            break;
                        }

                    }
                    break;
                case 4:
                    System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
                    for (int i = 0; i < productList.length - 1; i++) {
                        for (int j = i + 1; j < productList.length; j++) {
                            if (productList[i] != null && productList[j] != null && productList[i].getProfit() < productList[j].getProfit()) {
                                Product temp = productList[i];
                                productList[i] = productList[j];
                                productList[j] = temp;
                            }
                        }
                    }
                    break;                                                
                case 5:
                    System.out.println("5. Thống kê các sản phẩm theo giá");
                    System.out.println("Giá thống kê từ :");
                    int fromPrice = Integer.parseInt(scanner.nextLine());
                    System.out.println("Giá thống kê đến :");
                    int toPrice = Integer.parseInt(scanner.nextLine());
                    int count = 0;
                    for (int i = 0; i < 100 - 1; i++) {
                        for (int j = i + 1; j < 100; j++) {
                            if (productList[i] != null &&productList[j] != null && productList[i].getExportPrice() >= fromPrice && productList[i].getExportPrice() <= toPrice ) {
                                Product temp = productList[i];
                                productList[i] = productList[j];
                                productList[j] = temp;
                                System.out.printf("Thống kê từ ( %d ) đến ( %d )",fromPrice,toPrice);
                                System.out.println();
                                count++;
                            }
                        }
                    }
                    if (count > 0) {
                        System.out.printf("Có %d sản phẩm có giá từ %2d đến %2d:\n", count, fromPrice, toPrice);
                        for (int i = 0; i < count; i++) {
                            assert productList[i] != null;
                            productList[i].display();
                            System.out.println();
                        }
                    }
                    break;
                case 6:
                    System.out.println("Nhập tên sản phẩm cần tìm: ");
                    String searchByName = scanner.nextLine();
                {
                    int i = 0;
                    while (i < productList.length) {

                        if (productList[i] != null && productList[i].getProductName().equalsIgnoreCase(searchByName)) {
                            productList[i].display();
                           break;
                        }
                        i++;
                    }
                }
                    break;
                case 7:
                     System.out.println("7. Nhập sản phẩm");
                     System.out.println("Nhập mã sản phẩm: ");
                     String inputProductId = scanner.nextLine();
                     System.out.println("Nhập số lượng sản phẩm cần nhập: ");
                     int inputQuantity = Integer.parseInt(scanner.nextLine());
                     boolean foundinput = false;
                    for (Product product : productList) {
                        assert product != null;
                        if (product.getProductId().equals((inputProductId))) {
                            product.setQuantity(product.getQuantity() + inputQuantity);
                            System.out.println("Đã nhập thêm số lượng " + inputQuantity + "sản phẩm có mã: " + inputProductId);
                            boolean foundInput = true;
                            break;
                        }
                        if (!foundinput) {
                            System.out.println("Không tìm thấy sản phẩm có mã: " + inputProductId);
                        }
                    }
                     
                    break;
                case 8:
                     System.out.println("8. Bán sản phẩm");
                     System.out.println("Nhập tên sản phẩm cần bán: ");
                     String productNameToSell = scanner.nextLine();
                     System.out.println("Nhập số lượng cần bán:");
                     int quantityToSell = Integer.parseInt(scanner.nextLine());
                     boolean foundSell = false;
                     for (Product value : productList) {
                         if (value != null && value.getProductName().equals(productNameToSell)) {
                             value.setQuantity(value.getQuantity() - quantityToSell);
                             System.out.println("Đã bán ( " + quantityToSell + " ) sản phẩm có tên là :" + productNameToSell);
                             foundSell = true;
                         }
                     }
                    break;
                case 9:
                    System.out.println("Nhập mã sản phẩm cần cập nhật trạng thái (true - Đang bán, false - Không bán): ");
                    String productUpdateStatus = scanner.nextLine();
                    boolean productUpdated = false;
                    for (Product product : productList) {
                        assert product != null;
                        if (product.getProductId().equals(productUpdateStatus)){
                            boolean newStatus = !product.isStatus();
                            product.setStatus(newStatus);
                             System.out.println("Cập nhật trạng thái thành công!");  
                           productUpdated = true;
                           break;
                        }
                    }
                     if (!productUpdated){
                         System.out.println("Không tìm thấy sản phẩm có mã: "+productUpdateStatus);
                    }
                    break;
                case 10:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ, vui lòng chọn lại từ 1-10.");

            }

        }
        while (true);
    }
}
