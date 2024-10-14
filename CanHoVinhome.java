
package com.test.canhovinhome;

import java.util.ArrayList;
import java.util.Scanner;

class CanHo{
    protected String id;
    protected int area;
    protected int Floor;
    protected double Price;
    
    public CanHo(){
        id = "";
        area = 0;
        Floor = 0;
        Price = 0.0;
    }
    
    public CanHo(String id, int area, int Floor, double Price) {
        this.id = id;
        this.area = area;
        this.Floor = Floor;
        this.Price = Price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getFloor() {
        return Floor;
    }

    public void setFloor(int Floor) {
        this.Floor = Floor;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    public double tinhgia(){
        return Price * area;
    }
}

class CanHoCaoCap extends CanHo{
    protected String view;

    public CanHoCaoCap() {
    }

    public CanHoCaoCap(String view, String id, int area, int Floor, double Price) {
        super(id, area, Floor, Price);
        this.view = view;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
    
    @Override
    public double tinhgia(){
        double hesohuong;
        switch(view){
            case "Bien":
                hesohuong = 1.4;
                break;
            case "HoBoi":
                hesohuong = 1.1;
                break;
            case "ThanhPho":
                hesohuong = 1.2;
                break;
            default:
                hesohuong = 1.0;
        }
        return Price * area * hesohuong;
    }
}
public class CanHoVinhome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<CanHo> danhsachcanho = new ArrayList<>();
        System.out.print("Nhap so luong can ho co ban: ");
        int socanhocoban = sc.nextInt();
        for(int i=0; i< socanhocoban; i++){
            System.out.print("Nhap ID can ho co ban: " + (i + 1) + ": ");
            String id = sc.next();
            System.out.print("Nhap dien tich can ho co ban: " + (i + 1) + ": ");
            int area = sc.nextInt();
            System.out.print("Nhap tang can ho co ban: " + (i + 1) + ": ");
            int floor = sc.nextInt();
            System.out.print("Nhap gia san can ho co ban: " + (i + 1) + ": ");
            double price = sc.nextDouble();
            CanHo canHo = new CanHo(id, area, floor, price);
            danhsachcanho.add(canHo); 
        }
        System.out.print("Nhap so luong can ho cao cap: ");
        int soluongcanhocc = sc.nextInt();
        for(int i=0; i<soluongcanhocc; i++){
            System.out.print("Nhap ID can ho cao cap: " + (i + 1) + ": ");
            String id = sc.next();
            System.out.print("Nhap dien tich can ho cao cap: " + (i + 1) + ": ");
            int area = sc.nextInt();
            System.out.print("Nhap tang can ho cao cap: " + (i + 1) + ": ");
            int floor = sc.nextInt();
            System.out.print("Nhap gia san can ho cao cap: " + (i + 1) + ": ");
            double price = sc.nextDouble();
            System.out.print("Nhap huong can ho cao cap: " + (i + 1) + " (Bien, Ho boi, Thanh pho, Khac): ");
            String view = sc.next();
            CanHoCaoCap CHCC = new CanHoCaoCap(view, id,area , floor, price);
            danhsachcanho.add(CHCC); 
        }
        double giaCaoNhat = 0;
        CanHo canHoGiaCaoNhat = null;
        for (CanHo canHo : danhsachcanho) {
            double Price = canHo.tinhgia();
            if (Price > giaCaoNhat) {
                giaCaoNhat = Price;
                canHoGiaCaoNhat = canHo;
            }
        }

        System.out.println("Can ho co gia cao nhat:");
        System.out.println("ID: " + canHoGiaCaoNhat.id);
        System.out.println("Dien tich: " + canHoGiaCaoNhat.area);
        System.out.println("Tang: " + canHoGiaCaoNhat.Floor);
        System.out.println("Gia: " + canHoGiaCaoNhat.Price);
    }
}
