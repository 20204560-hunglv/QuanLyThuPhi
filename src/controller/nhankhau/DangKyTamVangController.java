package controller.nhankhau;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.NhanKhauModel;
import models.TamVangModel;
import services.NhanKhauService;
import services.TamVangService;

public class DangKyTamVangController {

    @FXML
    private TextField tfCMT;
    @FXML
    private TextField tfMaTamVang;
    @FXML
    private DatePicker dateTuNgay;
    @FXML
    private DatePicker dateDenNgay;
    @FXML
    private TextArea taLyDo;

    public void addTamVang(ActionEvent event) throws ClassNotFoundException, SQLException {
        int idnhanKhauTamVang = 0;
        // khai bao mot mau de so sanh
        Pattern pattern;

        // kiem tra id nhap vao
        // id la day so tu 1 toi 11 chu so
        pattern = Pattern.compile("\\d{1,11}");
        if (!pattern.matcher(tfMaTamVang.getText()).matches()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Hãy nhập vào mã tạm vắng hợp lệ!", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }

        // check CMT/CMND co trung voi nhung CMT/CMND da ton tai hay khong
        List<NhanKhauModel> listNhanKhauModels = new NhanKhauService().getListNhanKhau();
        for (NhanKhauModel nhankhau : listNhanKhauModels) {
            if (nhankhau.getCmnd().equals(tfCMT.getText())) {
                idnhanKhauTamVang = nhankhau.getId();
            }
        }
        // kiem tra CMT/CMND 
        if (idnhanKhauTamVang == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Không thấy tìm thấy CMT/CMND như trên", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        // kiem tra ID them moi co bi trung voi nhung ID da ton tai hay khong
        List<TamVangModel> listTamVangModels = new TamVangService().getListTamVang();
        for (TamVangModel tamvang : listTamVangModels) {
            if (tamvang.getId_tam_vang() == Integer.parseInt(tfMaTamVang.getText())) {
                Alert alert = new Alert(AlertType.WARNING, "ID bị trùng!", ButtonType.OK);
                alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }
        }

        //kiem tra date bat dau, ket thuc
        if (dateTuNgay.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Hãy nhập ngày bắt đầu", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        if (dateDenNgay.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Hãy nhập ngày bắt đầu", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        //kiem tra text are ly do
        if (taLyDo.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Hãy nhập lý do", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        // ghi nhan gia tri ghi tat ca deu da hop le
        int idtamvang = Integer.parseInt(tfMaTamVang.getText());
        int idnhankhau = idnhanKhauTamVang;
        Date TuNgay = Date.valueOf(this.dateTuNgay.getValue());
        Date DenNgay = Date.valueOf(this.dateDenNgay.getValue());
        String lydo = taLyDo.getText();

        TamVangService tamVangService = new TamVangService();
        TamVangModel tamVangModel = new TamVangModel(idtamvang, idnhankhau, TuNgay, DenNgay, lydo);
        tamVangService.add(tamVangModel);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
