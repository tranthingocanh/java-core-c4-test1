package buoi9;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ContainerController {
    public ContainerController(){

    }

    public void setDsThongTinContainers(ArrayList<Container> containers){
        Scanner sc = new Scanner(System.in);
        int flag = 1;
        try{

            while (flag == 1){
                containers.add(setThongTinContainer());
                System.out.println(">>>>>> Tiep tuc nhap Thong Tin Container? 1: co, 0: khong.");
                flag = sc.nextInt();
                sc.nextLine();
            }
        }catch(Exception e){
            System.out.println("Thong tin dau vao Lop Hoc sai!!!");
        }
    }

    public void getDSThongTinContainers(ArrayList<Container> containers){
        if (containers == null){
            System.out.println("Danh sach Thong tin container rong!!!!");
        } else{
            for(Container container: containers){
                System.out.println("- soContainer: " + container.soContainer +" - canNang: " + container.canNang);
                System.out.println("- ngoaiCang: " + container.ngoaiCang +" - coHang: " + container.coHang);
                System.out.println("- ngayVaoCang: " + container.ngayVaoCang +" - ngayRaCang: " + container.ngayRaCang);
                System.out.println("-------------------------//----------------------------");
            }
        }
    }

    public ArrayList<Container> getDsThongTinContainersTheoDieuKien(ArrayList<Container> containers){
        ArrayList<Container> containersFilter = new ArrayList<>();
        Date date = new Date();
        try {
            //Date date = convertStringToDate(getDateNow());

            for (int i = 0; i< containers.size(); i++){
                if ( checkDateBefore(containers.get(i).ngayVaoCang, date)) {
                    containersFilter.add(containers.get(i));
                }
            }
        }catch(Exception e){
            System.out.println("Loi" + e);
        }
        return containersFilter;
    }

    public String getDateNow(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }


    private static Container setThongTinContainer(){
        Scanner sc = new Scanner(System.in);

        Container container = new Container();

        try {
            System.out.println("Nhap thong tin Container: ");
            System.out.print("soContainer: ");
            container.soContainer = sc.nextInt();

            System.out.print("canNang: ");
            container.canNang = sc.nextFloat();
            sc.nextLine();
            System.out.print("ngoaiCang? (true or false) : ");
            container.ngoaiCang = sc.nextBoolean();
            System.out.print("coHang? (true or false) : ");
            container.coHang = sc.nextBoolean();
            sc.nextLine();
            System.out.print("ngayVaoCang (theo format yyyy-MM-dd): ");
            container.ngayVaoCang = convertStringToDate(sc.nextLine());
            System.out.print("ngayRaCang (theo format yyyy-MM-dd): ");
            Date ngayRaCangTmp = convertStringToDate(sc.nextLine());
            if ( checkDateBefore(container.ngayVaoCang, ngayRaCangTmp )){
                container.ngayRaCang = ngayRaCangTmp;
            } else{
                throw new Exception("Yeu cau ngayVaoCang < ngayRaCang");
            }


        } catch (Exception e){
            System.out.println("Nhap thong tin Container sai!!!!!" + e);
        }
        return container;
    }

    private static Date convertStringToDate (String date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(date);
        return d;
    }

    private  static boolean checkDateBefore(Date beforeDate, Date afterDate) {
        if ( beforeDate.compareTo(afterDate) < 0 ) {
                return true;
        }
        return false;
    }
}
