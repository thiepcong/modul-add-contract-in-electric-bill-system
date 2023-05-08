/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import model.Client;
import model.Contract;

public class ContractDAO extends DAO{

    public ContractDAO() {
    }
    public boolean addContract(Contract c,Client k){
        String sqlc = "INSERT INTO tblContract(contractId,signTime,duration,userId,clientId) VALUES(?,?,?,?,?)";
        String sqlk = "INSERT INTO tblClient(id,idCard,fullName,address,email,tel,note) VALUES(?,?,?,?,?,?,? )";
        String dem = "select count(id) from tblClient";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            PreparedStatement psdem = con.prepareStatement(dem);
            ResultSet rs = psdem.executeQuery();
            int d = 0;
            while(rs.next()){
                d = rs.getInt("count(id)");
            }k.setId(d+1);
            PreparedStatement psk = con.prepareStatement(sqlk);
            psk.setInt(1, k.getId());
            psk.setString(2, k.getIdCard());
            psk.setString(3, k.getFullName());
            psk.setString(4, k.getAddress());
            psk.setString(5, k.getEmail());
            psk.setString(6, k.getTel());
            psk.setString(7, k.getNote());
            psk.execute();
            PreparedStatement psc = con.prepareStatement(sqlc);
            psc.setString(1, c.getContractID());
            psc.setDate(2, new java.sql.Date(c.getSignTime().getTime()));
            psc.setDate(3, new java.sql.Date(c.getDuration().getTime()));
            psc.setInt(4, c.getUser().getId());
            psc.setInt(5, k.getId());
            psc.execute();
           
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }       
        return true;
    }
}
