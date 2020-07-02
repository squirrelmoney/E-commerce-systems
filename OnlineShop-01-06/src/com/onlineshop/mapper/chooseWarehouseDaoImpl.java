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

     * ���ݵ�ַ��þ�γ��

     */
        public LatitudeAndLongitude getLngAndLat(String address) {
        LatitudeAndLongitude latAndLng=new LatitudeAndLongitude();
        String url = "http://api.map.baidu.com/geocoding/v3/?address="+address+"&output=json&ak=IdStwMM26ox29xsgvvkxV8pWVnViglSv ";//GET����
        String json = loadJSON(url);
        if (StringUtils.isEmpty(json))
        {
            return latAndLng;
        }

        int len = json.length();

        // ������ǺϷ���json��ʽ
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

     * ���Է��� ˵�����Ѵ����е�akֵ����ɫ�ֲ��֣�����Ϊ���Լ���akֵ���ڰٶȵ�ͼAPI��ע��һ�¾��С�
     * �ٶ�·����http://lbsyun.baidu.com/index.php?title=webapi/guide/changeposition

     */
/*        public static void main(String[] args) {

        LatitudeAndLongitude latAndLng = getLngAndLat.getLngAndLat("�㶫ʡ��Զ��");
        LatitudeAndLongitude latAndLng2 = getLngAndLat.getLngAndLat("�㶫ʡտ����");
        double distance=getLngAndLat.getDistance
        		(latAndLng.getLongitude(), latAndLng.getLatitude(), latAndLng2.getLongitude(), latAndLng2.getLatitude());
        System.out.println(distance);
        System.out.println("���ȣ�" + latAndLng.getLongitude() + "---γ�ȣ�" + latAndLng.getLatitude());
        System.out.println("���ȣ�" + latAndLng2.getLongitude() + "---γ�ȣ�" + latAndLng2.getLatitude());
    }

*/
 

    /**

     * ���䣺��������֮����ʵ����

     * @return ��

     */

    public  double getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {

        // ά��

        double lat1 = (Math.PI / 180) * latitude1;
        double lat2 = (Math.PI / 180) * latitude2;

        // ����

        double lon1 = (Math.PI / 180) * longitude1;
        double lon2 = (Math.PI / 180) * longitude2;
        // ����뾶

        double R = 6371;

        // �������� km�������Ҫ�׵Ļ������*1000�Ϳ�����

        double d = Math.acos
        (Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)) * R;
        return d ;
    }


}
