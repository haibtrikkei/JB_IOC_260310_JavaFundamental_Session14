package can_bac_hai_so_am;

public class CanBacHai {
    public static void main(String[] args) {
        int n = -5;
        System.out.println("Căn bậc hai của n là: "+Math.sqrt(n));

        int a = 3, b = 0;
        try{
            System.out.println("Thương của a/b là: "+a/b);
        }catch (ArithmeticException ex){
            System.out.println("Đã có lỗi xảy ra");
//            ex.printStackTrace();
            System.out.println("Đây là lỗi: "+ex.getMessage());
        }


        Student obj = null;

        try{
            obj.show();
        }catch (NullPointerException ne){
            System.out.println("Đối tượng đang bị null");
        }finally {
            System.out.println("Kết thúc xử lý");
        }
    }
}
