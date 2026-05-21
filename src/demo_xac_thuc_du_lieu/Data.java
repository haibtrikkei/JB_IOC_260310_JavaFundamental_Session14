package demo_xac_thuc_du_lieu;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Data {
    private String id;          // id phải là 6 kí tự, bắt đầu là SP hoặc HH, không trùng
    private String name;        // Tối thiểu 3 kí tự, không được trùng
    private Integer quantity;   // Phải là số và là số dương
    private Double money;       // Phải là số và là số dương

    public Data() {
    }

    public Data(String id, String name, Integer quantity, Double money) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    //Cài đặt hàm input() có validate dữ liệu nhập vào
    public void input(Scanner scanner, List<Data> list){
        id = inputId(scanner, list);
        name = inputName(scanner,list);
        quantity = inputQuantity(scanner);
        money = inputMoney(scanner);
    }

    //Cài đặt hàm hiển thị thông tin tài liệu
    public void info(){
        System.out.println("--------------------");
        System.out.println("Mã tài liệu: "+id);
        System.out.println("Tên tài liệu: "+name);
        System.out.println("Số lượng: "+quantity);
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
        System.out.println("Giá tiền: "+nf.format(money));
    }

    private Double inputMoney(Scanner scanner) {
        double money;
        while (true){
            System.out.println("Nhập vào giá tiền tài liệu: ");
            try{
                money = Double.parseDouble(scanner.nextLine());
                if(money<0){
                    System.out.println("Money phải là số dương");
                }else{
                    return money;
                }
            } catch (Exception e) {
                System.out.println("Giá tiền phải là số");
            }
        }
    }

    private Integer inputQuantity(Scanner scanner) {
        int quantity;
        while (true){
            System.out.println("Nhập vào số lượng dữ liệu: ");
            try{
                quantity = Integer.parseInt(scanner.nextLine());
                if(quantity<0){
                    System.out.println("Quantity phải là số dương");
                }else{
                    return quantity;
                }
            } catch (Exception e) {
                System.out.println("Quantity phải là số");
            }
        }
    }

    private String inputName(Scanner scanner, List<Data> list) {
        String name;
        while (true){
            System.out.println("Nhập vào tên dữ liệu: ");
            name = scanner.nextLine();
            if(name.length()<3){
                System.out.println("Tên tài liệu phải tối thiểu 3 kí tự");
            }else if(existedName(name, list)){
                System.out.println("Tên tài liệu đã tồn tại");
            }else{
                return name;
            }
        }
    }

    private boolean existedName(String name, List<Data> list) {
        for(Data dt : list){
            if(dt.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    public String inputId(Scanner scanner, List<Data> list) {
        String id;  // id phải là 6 kí tự, bắt đầu là SP hoặc HH
        while (true){
            System.out.println("Nhập vào id (không rỗng, không trùng): ");
            id = scanner.nextLine();
            if(id.length()!=6){
                System.out.println("Id phải chính xác 6 kí tự");
            }else if(!id.startsWith("SP") && !id.startsWith("HH")){
                System.out.println("Id phải bắt đầu là SP hoặc HH");
            }else if(idExisted(id, list)){
                System.out.println("Id đã tồn tại");
            }else{
                return id;
            }
        }
    }

    private boolean idExisted(String id, List<Data> list) {
        for(Data dt : list){
            if(dt.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
