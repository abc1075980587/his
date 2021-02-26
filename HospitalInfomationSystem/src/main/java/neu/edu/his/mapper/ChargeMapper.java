package neu.edu.his.mapper;

import neu.edu.his.bean.ChargeListBean;
import neu.edu.his.bean.PrescriptionBean;
import neu.edu.his.bean.ReceiptBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ChargeMapper {

    List<PrescriptionBean> getPrescriptionWei();

    List<PrescriptionBean> getPrescriptionYi();

    int getIncrementReceiptId();

    int getIncrementReceiptSeqNum();

    void createChargeList(ChargeListBean chargeListBean);

    int getRegisIdByPrescriptionId(int prescriptionId);

    String getDrugsIdByPrescriptionId(int prescriptionId);

    double getDrugPriceByDrugId(String drugsId);

    void updateIsAddedToChargeList(int prescriptionId);

    List<ChargeListBean> getChargeListByRegisId(int regisId);

    void updateIsReturned(int regisId);

    int getReceiptIdByRegisId(int regisId);

    void createReceipt(ReceiptBean receiptBean);
}
