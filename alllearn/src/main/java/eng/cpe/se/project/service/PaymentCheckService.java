package eng.cpe.se.project.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pheerathach.ThaiQRPromptPay;
import com.google.zxing.WriterException;

import eng.cpe.se.project.model.Course;
import eng.cpe.se.project.model.Follower;
import eng.cpe.se.project.model.JoinCourse;
import eng.cpe.se.project.model.PaymentCheck;
import eng.cpe.se.project.model.User;
import eng.cpe.se.project.repository.PaymentCheckRepository;

@Service
public class PaymentCheckService {
	
	@Value("${external.resoures.path}")
	private String externalPath;
	@Autowired
	private PaymentCheckRepository checkRepository;
	@Autowired
	private CourseService courseService;
	
	public void save(PaymentCheck paymentCheck) {
		checkRepository.save(paymentCheck);
	}
	
	public List<PaymentCheck> findAll(){
		return (List<PaymentCheck>) checkRepository.findAll();
	}
	
	public PaymentCheck findById(int id) {
		return checkRepository.findById(id).get();
	}
	
	public void delete(int id) {
		checkRepository.deleteById(id);
	}
	
	public void init() {
		// TODO Auto-generated method stub
		File folder = new File(externalPath+File.separator+"Qrcode"+File.separator);
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}
	
	public Resource load(String filename) {
		// TODO Auto-generated method stub
		try {
			File file = new File(externalPath+File.separator+"Qrcode"+File.separator);
		      Resource resource = new UrlResource(file.toURI());

		      if (resource.exists() || resource.isReadable()) {
		        return resource;
		      } else {
		        throw new RuntimeException("Could not read the file!");
		      }
		    } catch (MalformedURLException e) {
		      throw new RuntimeException("Error: " + e.getMessage());
		    }
	}
	
	public String createQrcode(int courseId,User courseCreator,Course course,JoinCourse joinCourse) throws IOException, WriterException {
		File folder = new File(externalPath+File.separator+"Qrcode"+File.separator+"courseId"+courseId);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		String path = externalPath+File.separator+"Qrcode"+File.separator+"courseId"+courseId+File.separator+joinCourse.getJoinCourseId();
		final DecimalFormat df = new DecimalFormat("0.00");
		double sum = course.getMaximum()/course.getPrice();
		BigDecimal amount = new BigDecimal(df.format(sum));
		ThaiQRPromptPay qr = new ThaiQRPromptPay.Builder().dynamicQR().creditTransfer().mobileNumber(courseCreator.getPhoneNumber()).amount(amount).build();
		qr.draw(300, 300, new File(path+".png"));
		return path+".png";
	}
	
	public void saveimg(MultipartFile file,int paymentId) throws IOException {
		Course course =  courseService.findByPayment(paymentId);
		File folder = new File(externalPath+File.separator+"Slip"+File.separator+"courseId"+course.getCourseId());
		if (!folder.exists()) {
			folder.mkdirs();
		}
		PaymentCheck payment = findById(paymentId);
		String filename = externalPath+File.separator+"Slip"+File.separator+"courseId"+course.getCourseId()+File.separator+paymentId;
		String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
		filename = filename + "." + type;
		
		OutputStream outputStream = new FileOutputStream(filename);
		outputStream.write(file.getBytes());
		outputStream.close();
		payment.setSlipPath(filename);
		save(payment);
	  }
	
//	public String writeFile(MultipartFile file,int courseId,int JoinId) throws IOException {
//
//		
//		String filename = 
//
//		String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
//		
//		filename = filename + "." + type;
//
//		String path = externalPath + File.separator +"SurveyTargetPoint"+File.separator+ filename;
//		OutputStream outputStream = new FileOutputStream(path);
//		outputStream.write(file.getBytes());
//		outputStream.close();
//
//		return filename;
//
//	}
	
}
