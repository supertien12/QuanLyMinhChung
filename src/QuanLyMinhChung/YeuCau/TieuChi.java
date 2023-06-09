package QuanLyMinhChung.YeuCau;

import QuanLyMinhChung.CauHinh.CauHinh;
import QuanLyMinhChung.MinhChung.MinhChung;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class TieuChi extends YeuCau {
    private static int countTieuChi;

    private TieuChuan thuocTieuChuan;
    private ArrayList<MinhChung> dsMinhChung = new ArrayList<>();


    {
        super.maYeuCau = String.format("TChi%05d", ++countTieuChi);
    }

    public TieuChi(String tenYeuCau, String noiDung, TieuChuan tieuChuan) {
        super(null, tenYeuCau, noiDung);
        this.thuocTieuChuan = tieuChuan;
    }

    public void sapXepMinhChungNgayBanHanh() {
        this.dsMinhChung.sort(Comparator.comparing(MinhChung::getNgayBanHanh));
    }
    @Override
    public void display(){
        // Hiển thị Tiêu chí
        System.out.printf("| %-10s | %-5s |", getMaYeuCau(), getTenYeuCau());
        System.out.printf(" %-10s |\n", getNoiDung());

        // Hiển thị danh sách Minh chứng
        System.out.println("Danh sách Minh chứng");
        System.out.printf("| %-3s | %-10s | %-20s | %-15s | %-20s |\n",
                "STT", "Mã minh chứng", "Tên minh chứng", "Ngày ban hành", "Nơi ban hành");
        int index = 1;
        if (dsMinhChung.size() == 0) {
            System.out.println("Không có danh sách minh chứng ");
        } else {
            for (MinhChung minhChung : dsMinhChung) {
                System.out.printf("| %-3d | %-10s | %-20s | %-15s | %-20s |\n",
                        index++, minhChung.getMaMinhChung(),
                        minhChung.getTenMinhChung(),
                        CauHinh.f.format(minhChung.getNgayBanHanh()), minhChung.getNoiBanHanh());
            }
        }
    }


    //Kiem Tra Minh Chung da duoc them
    public boolean isCheckMinhChungAdd(MinhChung... minhChungs) {
        return this.dsMinhChung.contains(minhChungs);
    }

    // ham them Minh Chung
    public void addMinhChung(MinhChung... minhChungs) {
        if (!isCheckMinhChungAdd(minhChungs)) {
            this.dsMinhChung.addAll(Arrays.asList(minhChungs));
        } else {
            System.out.println("Minh chứng đã tồn tại trong danh sách");
        }
    }
    // ham xoa minh chung theo ten
    public boolean removeMinhChung(String kw) {
        return this.dsMinhChung.removeIf(x -> x.getTenMinhChung().contains(kw));
    }
    public void showMinhChung(){
        dsMinhChung.forEach(e->e.display());
    }
    public boolean tonTai(MinhChung name){
        for(MinhChung e : this.dsMinhChung){
            if(e.equals(name)){
                return true;
            }
        }
        return false;
    }

    public TieuChuan getThuocTieuChuan() {
        return thuocTieuChuan;
    }

    public void setThuocTieuChuan(TieuChuan thuocTieuChuan) {
        this.thuocTieuChuan = thuocTieuChuan;
    }

    public ArrayList<MinhChung> getDsMinhChung() {
        return dsMinhChung;
    }

    public void setDsMinhChung(ArrayList<MinhChung> dsMinhChung) {
        this.dsMinhChung = dsMinhChung;
    }

}
