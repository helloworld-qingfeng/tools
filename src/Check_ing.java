import java.io.*;
import java.util.Properties;

public class Check_ing {


    /*
        第一步过滤检测；
     */
    public String Check_ing_1(String img,String cizuya){

    String[] split = cizuya.split(",");
    String[] check_arry = split;
        for ( String i: check_arry) {
            img=img.replaceAll(i,"<span style=\"background:red;\">"+i+"</span>");
//            img=img.replaceAll(i,"<font color=\"red\">"+i+"</font>");
        }
      return img;
    }

    /*
        第二部过滤检测：
     */
    public String Check_ing_2(String img,String cizuya,String Yi_Cuo){
        String[] split = cizuya.split(",");
        String[] check_arry = split;
        for ( String i: check_arry) {
            img=img.replaceAll(i,"<span style=\"background:yellow;\">"+i+"</span>");
        }

        String[] split2 = Yi_Cuo.split(",");
        String[] check_arry2 = split2;
        for ( String i: check_arry2) {
            img=img.replaceAll(i,"<span style=\"background:red;\">"+i+"</span>");
        }
        return img;
    }

    /*
        说明书和权利要求书进行对照
     */
    public String Check_ing_3(String img,String img2,String QuanLiYaoQiu_CiZu,String ShuoMingShu_CiZu) throws IOException, InterruptedException {
        String[]  QuanLi_cizu = QuanLiYaoQiu_CiZu.split(",");
        String[]  ShuoMingShu_cizu = ShuoMingShu_CiZu.split(",");

        //数据过滤
        //1.权利要求书过滤
        for (String s:QuanLi_cizu) {
            img  = img.replaceAll(s,"");
        }
            //1.2 权利要求书过滤
            img  = img.replaceAll(",","，").replaceAll("^M","");


        //数据过滤
        //2. 说明书过滤
        for (String s:ShuoMingShu_cizu) {
            img2 = img2.replaceAll(s, "");
        }
            //2.1 说明书过滤
            img2 = img2.replaceAll(",", "，");

//        //获取配置文件
//        String path = test.class.getResource(File.separator).toString().replaceAll("%5c","");
//        String filename = "";
//        if(System.getProperty("os.name").indexOf("dows")!= -1){
//            filename = System.currentTimeMillis()+".conf";
//            path = path.replaceAll("file:/", "")+"resource"+File.separator+filename;
//        }else {
//            filename = System.currentTimeMillis()+".conf";
//            path = path.replaceAll("file:", "")+"resource"+File.separator+filename;
//        }

//        //输出 权利要求书  到本地文件
//        OutputStream out = new FileOutputStream(path);
//        out.write(img.replaceAll("\\n","").getBytes());
//        out.flush();
//        out.close();
//
//        //格式转化(文件如果存在)
//        File file = new File(path);
//        if(file.exists()){
//            String linux_cmd = "/bin/bash /java_pro_scripts/zhuanhuan.sh  "+"\""+path+"\"";
//            String linux_cmd2 = "/bin/bash /java_pro_scripts/echo.sh  "+"\""+path+"\"";
//            Process exec = Runtime.getRuntime().exec(linux_cmd);
//            exec.waitFor();
//            Runtime.getRuntime().exec(linux_cmd2).waitFor();
//        }
//
//
//        //读取(文件如果存在)
//        if(file.exists()){
//            InputStream  is = new FileInputStream(path);
//            byte b[]=new byte[1024*4];     //创建合适文件大小的数组
//            is.read(b);    //读取文件中的内容到b[]数组
//            is.close();
//            img = new String(b); //获取新的内容
//        }
//
//        //删除(文件如果存在)
//        if(file.exists()){
//            file.delete();
//        }

        //分割权利要求书
        String[] split = img.split("tts");


        //标红
        for (String str:split) {
            String buffer_str = str.substring(0, str.indexOf("其特征在于"));
            String new_str = str.replaceAll(buffer_str, "").replaceAll("其特征在于，","").replaceAll("其特征在于：","");
            img2=img2.replaceAll(new_str, "<span style=\"background:#ffb3ff;\">" + new_str + "</span>");
//          ShuoMing=ShuoMing.replaceAll(str, "<span style=\"background:#ffb3ff;\">" + str + "</span>");
        }
        return img2;
    }

    /*
         获取过滤词组;
     */
    public String get_cizu(String key){
        String cizu = "";

        //获取配置文件
        String path = test.class.getResource(File.separator).toString();
        if(File.separator.equals("\\")){
            path = path.replaceAll("file:/", "")+"resource"+File.separator+"GaoLiang.conf";
        }else {
            path = path.replaceAll("file:", "")+"resource"+File.separator+"GaoLiang.conf";
        }

        InputStream in = null;
        FileOutputStream oFile = null;
        try {
            in = new BufferedInputStream(new FileInputStream(path));
            Properties p=new Properties();
            p.load(new InputStreamReader(in, "utf-8"));
            cizu = p.getProperty(key);
//            cizu=new String(cizu.getBytes("utf-8"), "ISO-8859-1");//这一句是重点
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(in!=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cizu;
    }
}



