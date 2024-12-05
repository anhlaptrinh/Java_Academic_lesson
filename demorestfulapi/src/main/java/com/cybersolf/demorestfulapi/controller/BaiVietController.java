package com.cybersolf.demorestfulapi.controller;

import com.cybersolf.demorestfulapi.model.BaiViet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/baiviet")
public class BaiVietController {
    @GetMapping
    public ResponseEntity<?> getAllBaiViet(){
        List<BaiViet> baiViets=new ArrayList<BaiViet>();
        BaiViet baiViet=new BaiViet();
        baiViet.setTieuDe("Thành viên tổ chức khủng bố 'Chính phủ quốc gia Việt Nam lâm thời' bị bắt");
        baiViet.setHinhAnh("abc.jpg");
        baiViet.setNoiDung("Huỳnh Nhật Phương, 42 tuổi, bị cáo buộc tham gia tổ chức khủng bố \"Chính phủ quốc gia Việt Nam lâm thời\", được phong chức, rải truyền đơn kích động. ");
        baiViet.setSoLuotXem(500);

        BaiViet baiViet1=new BaiViet();
        baiViet1.setTieuDe("Philippines sẽ tuân thủ nếu Interpol muốn bắt ông Duterte");
        baiViet1.setHinhAnh("abc.jpg");
        baiViet1.setNoiDung("Chính phủ Philippines nói sẽ không cản trở nếu ông Duterte muốn nộp mình cho ICC cũng như tuân thủ nếu Interpol phát lệnh bắt ông. ");

        baiViet1.setSoLuotXem(200);
        baiViets.add(baiViet);
        baiViets.add(baiViet1);
        return new ResponseEntity<>(baiViets, HttpStatus.OK);
    }
}
