package com.onlineshop.mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import net.sf.json.JSONObject;

import com.mapper.pojo.LatitudeAndLongitude;
import com.mapper.pojo.Warehouse;
import com.mapper.pojo.chooseWarehouseDao;
import com.service.IchooseWarehouseService;
@Component
public class chooseWarehouseDaoImpl implements chooseWarehouseDao {
	 /**

     * 根据地址获得经纬度

     */
        public LatitudeAndLongitude getLngAndLat(String address) {
        LatitudeAndLongitude latAndLng=new LatitudeAndLongitude();
        String url = "http://api.map.baidu.com/geocoding/v3/?address="+address+"&output=json&ak=IdStwMM26ox29xsgvvkxV8pWVnViglSv ";//GET请求
        String json = loadJSON(url);
        if (StringUtils.isEmpty(json))
        {
            return latAndLng;
        }

        int len = json.length();

        // 如果不是合法的json格式
        if (json.indexOf("{") != 0 || json.lastIndexOf("}") != len - 1) {
            return latAndLng;
        }

        JSONObject obj = JSONObject.fromObject(json);
        if (obj.get("status").toString().equals("0")) {
          
            double lng = obj.getJSONObject("result").getJSONObject("location").getDouble("lng");
            //System.out.println(lng+"1");

            double lat = obj.getJSONObject("result").getJSONObject("location").getDouble("lat");

            latAndLng.setLatitude(lat);
            latAndLng.setLongitude(lng);
           
        }
        
        return latAndLng;

    }

    public  String loadJSON(String url) {
        StringBuilder json = new StringBuilder();

        try {

            URL urlObj = new URL(url);

            URLConnection uc = urlObj.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));

            String inputLine = null;

            while ((inputLine = br.readLine()) != null) {

                json.append(inputLine);

            }

            br.close();

        } catch (MalformedURLException e) {

        } catch (IOException e) {

        }

        return json.toString();

    }

    /*

     * 测试方法 说明：把代码中的ak值（红色字部分）更改为你自己的ak值，在百度地图API中注册一下就有。
     * 百度路径：http://lbsyun.baidu.com/index.php?title=webapi/guide/changeposition

     */
/*        public static void main(String[] args) {

        LatitudeAndLongitude latAndLng = getLngAndLat.getLngAndLat("广东省清远市");
        LatitudeAndLongitude latAndLng2 = getLngAndLat.getLngAndLat("广东省湛江市");
        double distance=getLngAndLat.getDistance
        		(latAndLng.getLongitude(), latAndLng.getLatitude(), latAndLng2.getLongitude(), latAndLng2.getLatitude());
        System.out.println(distance);
        System.out.println("经度：" + latAndLng.getLongitude() + "---纬度：" + latAndLng.getLatitude());
        System.out.println("经度：" + latAndLng2.getLongitude() + "---纬度：" + latAndLng2.getLatitude());
    }

*/
 

    /**

     * 补充：计算两点之间真实距离

     * @return 米

     */

    public  double getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {

        // 维度

        double lat1 = (Math.PI / 180) * latitude1;
        double lat2 = (Math.PI / 180) * latitude2;

        // 经度

        double lon1 = (Math.PI / 180) * longitude1;
        double lon2 = (Math.PI / 180) * longitude2;
        // 地球半径

        double R = 6371;

        // 两点间距离 km，如果想要米的话，结果*1000就可以了

        double d = Math.acos
        (Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)) * R;
        return d ;
    }


}
