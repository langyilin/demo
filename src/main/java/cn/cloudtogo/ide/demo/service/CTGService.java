package cn.cloudtogo.ide.demo.service;

import cn.cloudtogo.ide.demo.db.DBHelper;
import cn.cloudtogo.ide.demo.model.Template;
import com.alibaba.fastjson.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nero
 * @create 2018-02-09 17:47
 **/
public class CTGService {



    public JSONObject getShowParam(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version",getVersion());
        jsonObject.put("version_compile_os",getVersionCompileOs());
        jsonObject.put("version_comment",getVersionComment());
        jsonObject.put("Uptime",getUptime());
        jsonObject.put("Bytes_received",getBytesReceived());
        jsonObject.put("Bytes_sent",getBytesSent());
        jsonObject.put("data",getTableData());
        return jsonObject;
    }


    private String getVersion(){
        return getStrBySql("show variables like 'version'");
    }

    private String getVersionCompileOs(){
        return getStrBySql("show variables like 'version_compile_os'");
    }

    private String getVersionComment(){
        return getStrBySql("show variables like 'version_comment'");
    }

    private String getUptime(){
        return getStrBySql("show status like 'Uptime'");
    }

    private String getBytesReceived(){
        return getStrBySql("show status like 'Bytes_received'");
    }

    private String getBytesSent(){
        return getStrBySql("show status like 'Bytes_sent'");
    }

    private List<Template> getTableData(){
        List<Template> results = new ArrayList<Template>();
        String sql = "SELECT id,language,framework,create_time FROM template LIMIT 10";
        DBHelper dbHelper =  new DBHelper(sql);
        Template result ;
        ResultSet rs = null;
        try {
            rs = dbHelper.pst.executeQuery();
            while (rs.next()){
                result = new Template();
                result.setId(rs.getString(1));
                result.setLanguage(rs.getString(2));
                result.setFramework(rs.getString(3));
                result.setCreateTime(rs.getString(4));

                results.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (null != rs){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            dbHelper.close();
        }

        return results;
    }


    private String getStrBySql(String sql){
        String result = "";
        DBHelper dbHelper =  new DBHelper(sql);
        ResultSet rs = null;
        try {
            rs = dbHelper.pst.executeQuery();
            while (rs.next()){
                result = rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (null != rs){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            dbHelper.close();
        }
        return result;
    }

}
