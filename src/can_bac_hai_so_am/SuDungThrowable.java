package can_bac_hai_so_am;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuDungThrowable {
    public static void main(String[] args) throws Exception {
        //Viết chương trình nhập vào 1 dãy không giới hạn các số nguyên
        //Nếu nhập vào là -1 thì kết thúc việc nhập và hiển thị danh sách số nguyên ra màn hihf
        //Nếu nhập vào là -10 thì kết thúc chương trình luôn (không in ra nữa)

        List<Integer> ds = new ArrayList<>();
        Scanner sc;

        int flag = 1;
        int number = 0;
        while(flag!=-1){
            sc = new Scanner(System.in);
            System.out.println("Nhập vào 1 số nguyên bất kỳ: ");
            try{
                number = sc.nextInt();
                ds.add(number);

                if(number==-1){
                    flag = -1;
                }else if(number==-10){
                    flag = -1; //Thoát khỏi vòng lặp
                }
            }catch (Exception ex){
                System.out.println("Có lõi xảy ra: "+ex.getMessage());
            }
        }
        if(number==-10){
            throw new Exception("Lỗi khi nhập vào số -10");
        }

        System.out.println("\nDanh sách các số vừa nhập: ");
        for(Integer n : ds){
            System.out.print(n+"\t");
        }
        System.out.println();
    }
}
