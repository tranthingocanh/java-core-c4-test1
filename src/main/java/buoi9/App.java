package buoi9;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        int flag = 1;
        int i;

        ArrayList<Container> containers = new ArrayList<>();
        ContainerController containerController = new ContainerController();

        while (flag == 1){
            System.out.println("\t\t\t\tVui long chon chuc nang cua chuong trinh: ");
            System.out.println("\t\t\t\t0. Thoat chuong trinh.");
            System.out.println("\t\t\t\t1. Nhap thong tin containers.");
            System.out.println("\t\t\t\t2. In thong tin containers.");
            System.out.println("\t\t\t\t3. In thong tin containers co ngay nho hon ngày được người dùng nhập vào " + containerController.getDateNow());
            System.out.println(">>>>>>Lua chon: ");
            i = sc.nextInt();
            sc.nextLine();
            switch (i){
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("1. Nhap thong tin containers.");
                    containerController.setDsThongTinContainers(containers);
                    System.out.println("----------------end----------");
                    break;
                case 2:
                    System.out.println("2. In thong tin containers.");
                    containerController.getDSThongTinContainers(containers);
                    System.out.println("----------------end----------");
                    break;
                case 3:
                    System.out.println("3. In thong tin containers co ngay nho hon ngày được người dùng nhập vào " + containerController.getDateNow());
                    ArrayList<Container> containersFilter = new ArrayList<>();
                    containersFilter = containerController.getDsThongTinContainersTheoDieuKien(containers);
                    containerController.getDSThongTinContainers(containersFilter);
                    System.out.println("----------------end----------");
                    break;

                default:
                    System.out.println("Nhap so lua chon sai!!!!!");
                    System.exit(0);

            }

        }
    }
}
