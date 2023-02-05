package main;

import model.dao.DockDAO;
import model.dao.connection.MySQL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GenData {

    public static void main(String[] args) {
        MySQL mySQL = MySQL.getDriverConnection();
        DockDAO dockDAO = new DockDAO();
        ArrayList<String> address = new ArrayList<>(Arrays.asList(
                "671 Hoang Hoa Tham, Ba Dinh, Ha Noi",
                "2 Dai Co Viet, Ha Ba Trung, Ha Noi",
                "179 Ve Ho, Tay Ho, Ha Noi",
                "129 Nguyen Dinh Thi, Tay Ho, Ha Noi",
                "4 Tran Hung Dao, Hoan Kiem, Ha Noi",
                "Opera House Park, Hoan Kiem, Ha Noi",
                "82 Nguyen Dinh Hoan, Cau Giay, Ha Noi",
                "199 Lo Duc, Hai Ba Trung, Ha Noi",
                "2 Vuong Thua Vu, Thanh Xuan, Ha Noi",
                "224 Nguyen Trai, Thanh Xuan, Ha Noi",
                "129 Hoang Van Thai, Thanh Xuan, Ha Noi",
                "3 Ly Thai To, Hoan Kiem, Ha Noi",
                "21 Hang Khoai, Hoan Kiem, Ha Noi",
                "144 Xuan Thuy, Cau Giay, Ha Noi",
                "213 Nguyen Khang, Cau Giay, Ha Noi",
                "29 Lieu Giai, Ba Dinh, Ha Noi",
                "9 Ngoc Ha, Ba Dinh, Ha Noi",
                "3 Hoang Hoa Tham, Ba Dinh, Ha Noi",
                "376 Duong Buoi, Ba Dinh, Ha Noi",
                "354A Le Duan, Dong Da, Ha Noi",
                "1 Ton That Tung, Dong Da, Ha Noi",
                "614 Lac Long Quan, Tay Ho, Ha Noi",
                "121 Nhat Chieu, Tay Ho, Ha Noi",
                "199B Thuy Khue, Tay Ho, Ha Noi"
        ));
        ArrayList<String> licensePlate = new ArrayList<>(Arrays.asList(
                "29B1", "29C1", "29D1", "29F1",
                "30G1", "30H1", "30K1", "30B1",
                "18D1", "18B1", "17B2", "17B3"
        ));
        int license = 10000;
        int barcode0 = 12344;
        int barcode1 = 65431;
        int barcode2 = 23455;
        for (int i = 0; i < address.size(); i ++) {
            mySQL.insert("insert into dock (id, name, address, area, status, bikeAmount) " +
                    "values (" + (i + 1) + ", 'EcoBike " + i + "', '" + address.get(i) + "', " + Math.max(0.1f, (float) Math.random()) * 1000 + ", " +
                    i % 2 + ", 100)");
            for (int j = 0; j < 20; j ++) {
                barcode0 ++;
                barcode1 ++;
                barcode2 ++;
                mySQL.insert("insert into bike (id, type, barcode, value, status, dockID) " +
                        "values (" + (60 * i + 3 * j + 1) + ", 0, '" + barcode0 + "', 400000, " + Math.round(Math.random()) + ", " + (i + 1) + "" +
                        "), (" + (60 * i + 3 * j + 2) + ", 1, '" + barcode1 + "', 550000, " + Math.round(Math.random()) + ", " + (i + 1) + "" +
                        "), (" + (60 * i + 3 * j + 3) + ", 2, '" + barcode2 + "', 700000, " + Math.round(Math.random()) + ", " + (i + 1) + "" +
                        ")");
                mySQL.insert("insert into bicycle (id) values (" + (60 * i + 3 * j + 1) + ")");
                mySQL.insert("insert into tandem (id) values (" + (60 * i + 3 * j + 2) + ")");
                license += new Random().nextInt(1, 100);
                mySQL.insert("insert into electricbicycle (id, licensePlate, battery) values (" + (60 * i + 3 * j + 3) + ", '" +
                        licensePlate.get(new Random().nextInt(0, licensePlate.size())) + " - " + license + "', " +
                        Math.round(Math.random() * 100) + ")");
            }
        }
    }
}
