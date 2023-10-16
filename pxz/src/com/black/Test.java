package com.black;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {     static    Inventory f=new Inventory();
    public static void main(String[] args) throws Exception {

    /*    File v=new File("库存文件.txt");
        v.createNewFile();*/
        kaishi();
        System.out.println("------------欢迎来到库存管理系统----------");
       ll:
        while (true) {
            huanying();
            Scanner sc=new Scanner(System.in);
            int e= sc.nextInt();
            switch (e){
                case 1:
                    try {
                        zhanshi();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                    case 2:shanruku();
                    break;
                    case 3:shanpinchuku();
                    break;
                    case 4:chankanzhi();
                    break;
                    case 5:tuichu();
                    break ll;
            }
        }
    }

    private static void zhanshi() {
        System.out.println(f.zhanshi());

    }

    private static void kaishi() throws Exception {
     /*   File v=new File("库存文件.txt");
        v.createNewFile();*/
        BufferedReader h=null;
        try {
            h=new BufferedReader(new FileReader("库存文件.txt"));
            String line;
            while ((line=h.readLine())!=null){
              String[] spilt=line.split(",");
               f.addku(new Product(spilt[0], Double.valueOf(spilt[1]), Integer.valueOf(spilt[2])));
            }
        } finally {
               h.close();
        }
    }

    private static void tuichu() throws IOException {
       BufferedWriter x=null;
        try {
             x=new BufferedWriter(new FileWriter("库存文件.txt"));
              List<Product> j=f.getAllProducts();
            for (int i = 0; i < j.size(); i++) {
                x.write(j.get(i).toString());
                if (i==j.size()-1){
                    continue;
                }
                x.newLine();
            }
            x.flush();
        } finally {
            x.close();
        }


    }

    private static void chankanzhi() {
        System.out.println("------------请输入商品名称----------");
        Scanner sc=new Scanner(System.in);
        String name = sc.nextLine();
        f.chaxun(name);
    }

    private static void shanpinchuku() throws Exception {
        System.out.println("------------请依次输入商品名称,价格,数量（用英文逗号隔开）----------");
        String[] productArr=inputInfo();
        Product p=new Product(productArr[0],Double.valueOf(productArr[1]),Integer.valueOf(productArr[2]));
   f.jianshaokucuns(p);
    }

    public static void huanying(){

        System.out.println( "1.查询所有商品信息，2.商品入库，3.商品出库，4.查看指定商品库存数量，5.退出系统");
    }
    public static void shanruku() throws Exception {
        System.out.println("------------请依次输入商品名称,价格,数量（用英文逗号隔开）----------");
        String[] productArr=inputInfo();
        Product p=new Product(productArr[0],Double.valueOf(productArr[1]),Integer.valueOf(productArr[2]));
f.addku(p);
    }
    private static String[] inputInfo() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] productArr = line.split(",");
        if (productArr.length != 3) {
            List<String> stringList = Arrays.stream(productArr).collect(Collectors.toList());
            throw new Exception("输入:" + stringList + "数据格式不对");
        }
        return productArr;
    }
}
