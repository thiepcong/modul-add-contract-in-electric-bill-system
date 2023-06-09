package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import model.*;

public class HouseholdDAO extends DAO{

    public HouseholdDAO() {
    }
    
    public boolean addHousehold(ElectricHousehold h,ElectricalMeter m,MeterInfo mi, ContractDetail cd, ContractType t){
        String sqlh = "INSERT INTO tblElectricHousehold(houseId,address) VALUES(?,?)";
        String sqlm = "INSERT INTO tblElectricalMeter(meterCode,meterIndex) VALUES(?,?)";
        String sqlmi = "INSERT INTO tblMeterInfo(id,installDate, status, startIndex, readingIndex, readingDate, houseId, meterCode) VALUES(?,?,?,?,?,?,?,?)";
        String sqlcd = "INSERT INTO tblContractDetail(id,payment, paymentTerm, contractTypeId, houseId, contractId) VALUES(?,?,?,?,?,?)";
        String demmi = "select count(id) from tblMeterInfo";
        String demcd = "select count(id) from tblContractDetail";
        try{
            PreparedStatement psdem = con.prepareStatement(demmi);
            ResultSet rs = psdem.executeQuery();
            int d = 0;
            while(rs.next()){
                d = rs.getInt("count(id)");
            }mi.setId(d+1);
            psdem = con.prepareStatement(demcd);
            rs = psdem.executeQuery();
            d = 0;
            while(rs.next()){
                d = rs.getInt("count(id)");
            }
            cd.setId(d+1);
            PreparedStatement psh = con.prepareStatement(sqlh);
            psh.setString(1, h.getHouseId());
            psh.setString(2, h.getAddress());
            psh.execute();
            
            PreparedStatement psm = con.prepareStatement(sqlm);
            psm.setString(1, m.getMeterCode());
            psm.setInt(2,m.getMeterIndex());
            psm.execute();
            
            PreparedStatement psmi = con.prepareStatement(sqlmi);
            psmi.setInt(1, mi.getId());
            psmi.setDate(2,new java.sql.Date(mi.getInstallDate().getTime()));
            psmi.setString(3, mi.getStatus());
            psmi.setInt(4, mi.getStartIndex());
            psmi.setInt(5, mi.getReadingIndex());
            psmi.setDate(6, new java.sql.Date(mi.getReadingDate().getTime()));
            psmi.setString(7, h.getHouseId());
            psmi.setString(8, m.getMeterCode());
            psmi.execute();
            PreparedStatement pscd = con.prepareStatement(sqlcd);
            pscd.setInt(1, cd.getId());
            pscd.setString(2,cd.getPayment());
            pscd.setString(3, cd.getPaymentTerm());
            pscd.setString(5, h.getHouseId());
            pscd.setString(6, cd.getC().getContractID());
            int tt=1;
            switch (t.getType()) {
                case "Điện dân dụng":tt=1;break;
                case "Điện sản xuất":tt=2;break;
                case "Điện kinh doanh":tt=3;break;
                default:tt=4;
            }
            pscd.setInt(4, tt);
            pscd.execute();
        }catch(SQLIntegrityConstraintViolationException e){
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }       
        return true;
    }
    public boolean deleteHousehold(ElectricHousehold h){
        String sqlContractDetail = "DELETE FROM tblContractDetail WHERE houseId = ?";
        String sqlMeterInfo = "DELETE FROM tblMeterInfo WHERE houseId = ?";
        String sqlElectricHousehold = "DELETE FROM tblElectricHousehold WHERE houseId = ?";
        String sqlElectricalMeter = "DELETE FROM tblElectricalMeter WHERE meterCode NOT IN (SELECT meterCode FROM tblMeterInfo)";

        try{
            PreparedStatement psContractDetail = con.prepareStatement(sqlContractDetail);
            psContractDetail.setString(1, h.getHouseId());
            psContractDetail.execute();

            PreparedStatement psMeterInfo = con.prepareStatement(sqlMeterInfo);
            psMeterInfo.setString(1, h.getHouseId());
            psMeterInfo.execute();

            PreparedStatement psElectricHousehold = con.prepareStatement(sqlElectricHousehold);
            psElectricHousehold.setString(1, h.getHouseId());
            psElectricHousehold.execute();

            PreparedStatement psElectricalMeter = con.prepareStatement(sqlElectricalMeter);
            psElectricalMeter.execute();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }       
        return true;

    }
    
}
