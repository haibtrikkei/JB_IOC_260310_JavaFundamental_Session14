package demo_xac_thuc_du_lieu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyTaiLieu {
    public static void main(String[] args) {
        List<Data> listData = new ArrayList<>();
        int n;

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Nhập vào số tài liệu: ");
            try{
                n = Integer.parseInt(sc.nextLine());
                if(n<1){
                    System.out.println("Phải nhập số tài liệu >0");
                }else{
                    break;
                }
            } catch (Exception e) {
                System.out.println("Số tài liệu phải nhập là số");
            }
        }

        for(int i=0;i<n;i++){
            System.out.println("Nhập thông tin tài liệu thứ "+(i+1));
            Data data = new Data();
            data.input(sc, listData);
            listData.add(data);
        }

        System.out.println("Thông tin các tài liệu: ");
        for(Data dt: listData){
            dt.info();
        }
    }
}
