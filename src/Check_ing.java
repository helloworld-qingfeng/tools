public class Check_ing {


    public String Check_ing_1(String img){
    String[] check_arry = {"连接","链接","铰接","转动","固定设","轴接","旋转","滑动","移动","固定在","固定于","固定"};
        for ( String i: check_arry) {
            img=img.replaceAll(i,"<span style=\"background:red;\">"+i+"</span>");
//            img=img.replaceAll(i,"<font color=\"red\">"+i+"</font>");
        }
      return img;
    }


    public String Check_ing_2(String img){
        String[] check_arry = {"部件","机","机构","装置","组件","器"};
        for ( String i: check_arry) {
            img=img.replaceAll(i,"<span style=\"background:yellow;\">"+i+"</span>");
        }
        return img;
    }




}



