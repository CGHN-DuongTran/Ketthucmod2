package view;

import enity.ImportedPhone;
import enity.OriginalPhone;
import enity.Phone;

import java.util.List;
import java.util.Scanner;

public class PhoneView {

    private Scanner scanner = new Scanner(System.in);

    // Hiển thị danh sách điện thoại
    public void displayPhones(List<Phone> phones) {
        System.out.println("+----+----------------------+----------------------+----------------------+----------------------+");
        System.out.println("| ID |       Tên Điện Thoại  |    Giá Bán    |  Số Lượng  |  Nhà Sản Xuất  |");
        System.out.println("+----+----------------------+----------------------+----------------------+----------------------+");
        for (Phone phone : phones) {
            System.out.printf("| %-2s | %-20s | %-15s | %-10d | %-15s |\n",
                    phone.getId(), phone.getName(), phone.getPrice(), phone.getQuantity(), phone.getManufacturer());
        }
        System.out.println("+----+----------------------+----------------------+----------------------+----------------------+");
    }

    // Chọn thêm điện thoại
    public Phone addPhoneInput(String phoneType, String phoneId) {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Tên điện thoại: ");
        String name = scanner.nextLine();
        System.out.print("Giá bán: ");
        double price = scanner.nextDouble();
        System.out.print("Số lượng: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Đọc dòng trống

        System.out.print("Nhà sản xuất: ");
        String manufacturer = scanner.nextLine();

        if (phoneType.equals("Chính Hãng")) {
            System.out.print("Thời gian bảo hành: ");
            String warrantyPeriod = scanner.nextLine();
            System.out.print("Phạm vi bảo hành (trong nước, quốc tế): ");
            String warrantyScope = scanner.nextLine();
            return new OriginalPhone(id, name, price, quantity, manufacturer, warrantyPeriod, warrantyScope);
        } else if (phoneType.equals("Xách Tay")) {
            System.out.print("Quốc gia xách tay: ");
            String importCountry = scanner.nextLine();
            System.out.print("Trạng thái (Mới, Cũ): ");
            String condition = scanner.nextLine();
            return new ImportedPhone(id, name, price, quantity, manufacturer, importCountry, condition);
        }

        return null; // Chỉ có thể là Chính Hãng hoặc Xách Tay, không bao giờ trả về null
    }
}