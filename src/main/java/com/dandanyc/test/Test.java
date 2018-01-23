package com.dandanyc.test;

import com.dandanyc.entity.CanadaDTO;
import com.dandanyc.entity.KenoDTO;
import com.dandanyc.util.HttpUtil;
import com.dandanyc.util.PropertiesUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by prothezou on 2016/10/29.
 */
public class Test {

    public static void main(String[] args) {
        // 连接Redis服务
//        Jedis jedis=new Jedis("139.196.112.87");
//        jedis.set("948812256","948812256");
//
//        String str=jedis.get("好好");
//        System.out.println(str);
//        PropertiesUtil pu = new PropertiesUtil("redis.properties");
//        String local = pu.getValue("redis.host");
//        System.out.println(local);
//        try {
//            Document pageDoc = Jsoup.connect(PropertiesUtil.getProperty("Keno_Url")).get();
//            Elements pageEle = pageDoc.select("td");
//            pageEle.remove(0);
//            // 总期数
//            int id = Integer.valueOf(pageEle.get(1).text());
//            // 总日期
//            String kenoDate = pageEle.get(4).text().substring(pageEle.get(4)
//                    .text().length() - 5);
//            SimpleDateFormat sdf_t = new SimpleDateFormat("HH:mm");
//            SimpleDateFormat sdf_y = new SimpleDateFormat("yyyy-MM-dd");
//            // 5分钟
//            long time = 5 * 60 * 1000;
//            Date date = sdf_t.parse(kenoDate);
//            String kenoTime = sdf_t.format(date);
//            String[] kenoInfo = pageEle.text().trim().split(" ");
//            List<KenoDTO> kenoDTOList = new ArrayList<KenoDTO>();
//            for (String keno : kenoInfo) {
//                if (keno.contains(",")) {
//                    String[] str = keno.split(",");
//                    Arrays.sort(str);
//                    int shu = 0;
//                    int[] threeShu = new int[3];
//                    KenoDTO kenoDTO = new KenoDTO();
//                    for (int i = 0; i < str.length; i++) {
//                        shu = Integer.valueOf(str[i]) + shu;
//                        if (i == 5) {
//                            threeShu[0] = (shu % 10);
//                            shu = 0;
//                        }
//                        if (i == 11) {
//                            threeShu[1] = (shu % 10);
//                            shu = 0;
//                        }
//                        if (i == 17) {
//                            threeShu[2] = (shu % 10);
//                            shu = 0;
//                        }
//                    }
//                    kenoDTO.setId(String.valueOf(id)); // 期数
//                    kenoDTO.setDate(sdf_y.format(new Date()) + " " + kenoTime);
//                    // 时间
//                    kenoDTO.setNumber
//                            (threeShu[0] + "+" + threeShu[1] +
//                                    "+" + threeShu[2]);
//                    // 区号
//                    kenoDTO.setResult(String.valueOf
//                            (threeShu[0] + threeShu[1] + threeShu[2])); // 开奖结果
//                    kenoDTOList.add(kenoDTO);
//
//                    Date afterDate = new Date(date.getTime() - time);
//                    kenoTime = sdf_t.format(afterDate);
//                    date = sdf_t.parse(kenoTime);
//                    id--;
//                }
//            }
//            System.out.println("PC蛋蛋30期开奖数据：");
//            for (KenoDTO k : kenoDTOList
//                    ) {
//                System.out.println(k.getId() + " " + k.getDate() + " " + k.getNumber
//                        () + " " + k.getResult());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        String result = HttpUtil.sendPost(PropertiesUtil.getProperty
//                ("Canada_Url"),null);
//        List<CanadaDTO> canadaDTOList = new ArrayList<CanadaDTO>();
//        String [] arrays = result.split("↑");
//        for (int i = 0;i<arrays.length;i++){
//            if(i==30){
//                break;
//            }else{
//                String [] canada = arrays[i].split("-");
//                CanadaDTO canadaDTO = new CanadaDTO();
//                canadaDTO.setId(canada[0]);
//                canadaDTO.setDate(canada[1]);
//                canadaDTO.setNumber(canada[2]);
//                String [] count = canada[2].split("\\+");
//                canadaDTO.setResult(String.valueOf(Integer.parseInt(count[0])+Integer.parseInt(count[1])+Integer.parseInt(count[2])));
//                canadaDTOList.add(canadaDTO);
//            }
//        }
//
//        for (CanadaDTO list:canadaDTOList
//             ) {
//            System.out.println(list.getId()+" "+list.getDate()+" "+list.getNumber()+" "+list.getResult());
//        }
//
//        String kenoResult = HttpUtil.sendPost(PropertiesUtil.getProperty
//                ("Keno_Url"),null);
//        String [] resultSplit = kenoResult.split("↑");
//        Random random = new Random(27);
//        List<KenoDTO> kenoDTOList = new ArrayList<KenoDTO>();
//        kenoDTOList.add(new KenoDTO(resultSplit[0].split("-")[0], "...", "...", "...", String.valueOf(random.nextInt(27))));
//        for (int i = 0;i<resultSplit.length;i++){
//            if(i==31){
//                break;
//            }else{
//                String [] kenoList =  resultSplit[i].split("-");
//                KenoDTO kenoDTO = new KenoDTO();
//                kenoDTO.setId(kenoList[0]);
//                kenoDTO.setDate(kenoList[3].substring(3));
//                String count = kenoList[4].replace(" ","");
//                kenoDTO.setNumber(count.substring(0,5));
//                kenoDTO.setResult(count.substring(6,8));
//                kenoDTO.setYuce(String.valueOf(random.nextInt(27)));
//                kenoDTOList.add(kenoDTO);
//            }
//        }
//        for (KenoDTO keno:kenoDTOList
//             ) {
//            System.out.println(keno.getId()+" "+keno.getDate()+" "+keno.getNumber()+" "+keno.getResult() + " " + keno.getYuce());
//        }
    }
}
