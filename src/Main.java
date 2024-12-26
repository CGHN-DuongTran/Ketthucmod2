import controller.PhoneController;
import enity.Phone;
import view.PhoneView;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneController controller = new PhoneController();
        PhoneView view = new PhoneView();

        while (true) {
            // Cập nhật nội dung menu mà không có chức năng cập nhật
            System.out.println("===== Chương trình Quản lý Điện thoại =====");
            System.out.println("1. Thêm điện thoại");
            System.out.println("2. Xóa điện thoại");
            System.out.println("3. Xem danh sách điện thoại");
            System.out.println("4. Tìm kiếm điện thoại");
            System.out.println("5. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống

            switch (choice) {
                case 1:
                    System.out.println("Chọn loại điện thoại:");
                    System.out.println("1. Chính Hãng");
                    System.out.println("2. Xách Tay");
                    System.out.print("Chọn loại: ");
                    int typeChoice = scanner.nextInt();
                    scanner.nextLine(); // Đọc dòng trống
                    String phoneType = (typeChoice == 1) ? "Chính Hãng" : "Xách Tay";

                    // Kiểm tra ID điện thoại
                    String phoneId = null;
                    boolean validId = false;
                    while (!validId) {
                        System.out.print("Nhập ID điện thoại: ");
                        phoneId = scanner.nextLine();
                        // Kiểm tra xem ID có phải là số không
                        if (!phoneId.matches("\\d+")) {
                            System.out.println("ID phải là một số. Mời bạn nhập lại.");
                        } else {
                            // Kiểm tra ID đã tồn tại chưa
                            String finalPhoneId = phoneId;
                            boolean idExists = controller.getAllPhones().stream().anyMatch(phone -> phone.getId().equals(finalPhoneId));
                            if (idExists) {
                                System.out.println("ID đã tồn tại. Mời bạn nhập lại.");
                            } else {
                                validId = true; // ID hợp lệ
                            }
                        }
                    }

                    // Tiến hành nhập thông tin điện thoại
                    Phone phone = view.addPhoneInput(phoneType, phoneId);
                    controller.addPhone(phone);

                    // Thông báo thêm điện thoại thành công
                    System.out.println("Thêm điện thoại thành công.");
                    break;


                case 2:
                    System.out.print("Nhập ID điện thoại cần xóa: ");
                    String idToDelete = scanner.nextLine();
                    if (controller.removePhone(idToDelete)) {
                        System.out.println("Xóa thành công.");
                    } else {
                        System.out.println("Không tìm thấy điện thoại với ID: " + idToDelete);
                    }
                    break;

                case 3:
                    List<Phone> phones = controller.getAllPhones();
                    view.displayPhones(phones);
                    break;

                case 4:
                    System.out.print("Nhập tên điện thoại cần tìm kiếm: ");
                    String nameToSearch = scanner.nextLine();
                    List<Phone> foundPhones = controller.searchPhone(nameToSearch);
                    view.displayPhones(foundPhones);
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}