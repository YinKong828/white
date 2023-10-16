package com.black;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Inventory {
    private List<Product> a;
    public  Inventory(){

        a=new ArrayList<>();
    }

    public  void  addku(Product b){
        for (Product product : a) {
            if (product.getName().equals(b.getName())&&product.getPrice()==b.getPrice()){
                product.addkuncun(b.getInventorys());
                return;
            }
        }
         a.add(b);
    }
public void  jianshaokucuns(Product b){
    for (Product product : a) {
        if (product.getName().equals(b.getName())&&product.getPrice()==b.getPrice()){
            product.jianshaokucun(b.getInventorys());
return;
        }
    }
    throw new RuntimeException("双拼不存在");
}
public  String chaxun(String name){
 
        List<Product> a2 = a.stream().filter(s->s.getName().equals(name)).collect(Collectors.toList());
   StringBuffer c=new StringBuffer();
    for (Product product : a2) {
    c.append(product.xinxi()).append("\n").append("============").append("\n");
    }
    return c.toString().length() ==0 ? "商品不存在~":c.toString();
    
}
public  String  zhanshi(){
        StringBuffer d=new StringBuffer();
    for (Product product : a) {
        d.append(product.xinxi()).append("\n").append("==========").append("\n");
    }
 return  d.toString().length()==0?"仓困为空，请添加": d.toString();
}
    public List<Product> getAllProducts() {
        return a;
    }

}
