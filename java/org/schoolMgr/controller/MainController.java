/**
 * 
 */
package org.schoolMgr.controller;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.schoolMgr.dao.FeesDao;
import org.schoolMgr.dao.StudentDao;
import org.schoolMgr.dao.UserDao;
import org.schoolMgr.entity.Account;
import org.schoolMgr.entity.Student;
import org.schoolMgr.model.DashBoardForm;
import org.schoolMgr.model.FeeForm;
import org.schoolMgr.model.FeeInfo;
import org.schoolMgr.model.FeeTypeForm;
import org.schoolMgr.model.FileUpload;
import org.schoolMgr.model.SignupForm;
import org.schoolMgr.model.StudentFeeForm;
import org.schoolMgr.model.StudentForm;
import org.schoolMgr.model.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author narajesh
 *
 */


import org.springframework.stereotype.Controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
// Enable Hibernate Transaction.
@Transactional
// Need to use RedirectAttributes
@EnableWebMvc
public class MainController {

	@Autowired
	private UserDao userDAO;
	
	@Autowired
	private FeesDao feesDAO;
	
	@Autowired
	private StudentDao studentDAO;
	
	@RequestMapping(value = {"/", "/login" }, method = RequestMethod.GET)
	public String login(Model model) {

		return "login";
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String homeScreen(Model model) {
     DashBoardForm dbForm = studentDAO.getDashBoardDet();
     
     model.addAttribute("dbForm", dbForm);
		return "home";
	}
	
	@RequestMapping(value = { "/403" }, method = RequestMethod.GET)
	public String errorScreen(Model model) {

		return "403";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public SignupForm signupForm(WebRequest request) {

		return new SignupForm();
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(Model model, @Validated SignupForm form, BindingResult formBinding, final WebRequest request) {
		String message = null;

		if (formBinding.hasErrors()) {
			form.setValid(false);
			return "signup";
		}

		form.setValid(true);

		try {
			userDAO.createAccount(form.createPerson());

		} catch (Exception e) {			
			message = e.getMessage();
			model.addAttribute("message", message);		
			return "403";
		}

		return "redirect:/userlist";
	}
	
	@RequestMapping(value = { "/userlist" }, method = RequestMethod.GET)
	public String userList(Model model) {
		ArrayList<Account> accountList = userDAO.listUsers();

		if (accountList != null) {
			model.addAttribute("accountList", accountList);
		}
		return "userList";
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String delUser(@RequestParam("userid") int user_id) {

		try {

			userDAO.deleteUser(user_id);
		} catch (Exception e) {

			return "403";
		}

		return "redirect:/userlist";
	}
	
	@RequestMapping(value = { "/viewAnnualFees" }, method = RequestMethod.GET)
	public String viewAnnualFees(Model model) {
		ArrayList<FeeInfo> feesList = feesDAO.listAnnualFees();

		FeeForm feeForm = new FeeForm();
		
		if (feesList != null) {
			feeForm.setFeeList(feesList);
			model.addAttribute("feeForm", feeForm);
		}
		
		return "viewAnnualFees";
	}
	
	
	
	@RequestMapping(value = { "/setAnnualFees" }, method = RequestMethod.GET)
	public String setAnnualFees(Model model) {
		ArrayList<FeeInfo> feesList = feesDAO.listAnnualFees();

		FeeForm feeForm = new FeeForm();
		
		if (feesList != null) {
			feeForm.setFeeList(feesList);
			model.addAttribute("feeForm", feeForm);
		}
		
		return "setAnnualFees";
	}
	
	@RequestMapping(value = "/saveFees", method = RequestMethod.POST)
	public String backupMonitoring(Model model, @Validated FeeForm form, BindingResult formBinding, final WebRequest request) {
		String message = null;
		boolean status=false;
		try {
			for(FeeInfo fee:form.getFeeList()){
				for(FeeTypeForm feeType :fee.getFee_types()){
				//	System.out.println("Value is ..."+feeType.getFee_value());
					System.out.println("id is..."+fee.getFee_id());
					System.out.println("name is.."+feeType.getFee_name());
					
					
				}
				//status=feesDAO.saveFees(fee);
			}
		} catch (Exception e) {
			// Need: Propagation.NEVER?
			message = e.getMessage();
			model.addAttribute("message", message);
			// Show product form.
			return "403";
		}
if(status)
		return "redirect:/setFees";
else 
	return "403";
	}
	
	

	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public StudentForm addStudent(WebRequest request) {

		return new StudentForm();
	}
	
	
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public String saveStudent(Model model, @Validated StudentForm form, BindingResult formBinding, final WebRequest request) {
		String message = null;
		boolean status=false;

		try {
			status = studentDAO.createStudent(form.createStudent());
		} catch (Exception e) {
			
			message = e.getMessage();
			model.addAttribute("message", message);
			
			return "403";
		}
if(status)
		return "redirect:/home";
else
	return "redirect:/403";
	}
	
	
	@RequestMapping(value = "/studentUpload", method = RequestMethod.GET)
	public String processStudentExcel(Model model, WebRequest request) {
		model.addAttribute("fileUploadStd", new FileUpload());
		return "fileUploadStudent";
	}
	
	@RequestMapping(value = "/studentUpload", method = RequestMethod.POST)
	public String processStudentExcel(@RequestParam("fileName") MultipartFile fileUpload,
			MultipartHttpServletRequest request) {
		boolean status = false;
		try {

			ArrayList<Student> stdList = new ArrayList<Student>();
			int i = 0;
			// MultipartFile multipartFile = request.getFile(fileUpload);
			// Creates a workbook object from the uploaded excelfile

			HSSFWorkbook workbook = new HSSFWorkbook(fileUpload.getInputStream());
			HSSFRow row;
			// Creates a worksheet object representing the first sheet
			HSSFSheet worksheet = workbook.getSheetAt(0);
		//	DataFormatter formatter = new DataFormatter();
			// Reads the data in excel file until last row is encountered
			while (i <= worksheet.getLastRowNum()) {

				// Creates an object for the UserInfo Model
				Student std = new Student();
				// Creates an object representing a single row in excel
				if (i == 0) {
					row = worksheet.getRow(i++);
				}
				row = worksheet.getRow(i++);

				// Sets the Read data to the model class
				// user.setId((int) row.getCell(0).getNumericCellValue());
				double adm_no = row.getCell(0).getNumericCellValue();
				std.setAdm_no((((int)adm_no)));
				std.setFirstName((row.getCell(1).getStringCellValue()));
				std.setLastName((row.getCell(2).getStringCellValue()));
				std.setStandard((row.getCell(3).getStringCellValue()));
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date date = 	sdf.parse(row.getCell(4).getStringCellValue());
				Date dt = new Date(date.getTime());
				std.setDob(dt);
				std.setSex(row.getCell(5).getStringCellValue());
				std.setGuardian_name(row.getCell(6).getStringCellValue());
				std.setContact((int)(row.getCell(7).getNumericCellValue()));
				// persist data into database in here
				stdList.add(std);
			}

			status=studentDAO.saveStdList(stdList);

		} catch (Exception e) {
			e.printStackTrace();
		}
if(status)
		return "redirect:/home";
else
	return "redirect:/home";
	}

	
	
	@RequestMapping(value = { "/lkgList" }, method = RequestMethod.GET)
	public String lkgListMethod(Model model) {
	
		ArrayList<StudentInfo> stdList = studentDAO.listStudents();
	
		model.addAttribute("stdList", stdList);
		
		return "lkgList";
	}
	
	@RequestMapping(value = { "/ukgList" }, method = RequestMethod.GET)
	public String ukgListMethod(Model model) {
	
		ArrayList<StudentInfo> stdList = studentDAO.listStudents();
	
		model.addAttribute("stdList", stdList);
		
		return "ukgList";
	}
	
	@RequestMapping(value = { "/istList" }, method = RequestMethod.GET)
	public String istListMethod(Model model) {
	
		ArrayList<StudentInfo> stdList = studentDAO.listStudents();
	
		model.addAttribute("stdList", stdList);
		
		return "istList";
	}
	
	@RequestMapping(value = { "/iindList" }, method = RequestMethod.GET)
	public String iindListMethod(Model model) {
	
		ArrayList<StudentInfo> stdList = studentDAO.listStudents();
	
		model.addAttribute("stdList", stdList);
		
		return "iindList";
	}
	
	@RequestMapping(value = { "/iiirdList" }, method = RequestMethod.GET)
	public String iiirdListMethod(Model model) {
	
		ArrayList<StudentInfo> stdList = studentDAO.listStudents();
	
		model.addAttribute("stdList", stdList);
		
		return "iiirdList";
	}
	
	@RequestMapping(value = { "/ivthList" }, method = RequestMethod.GET)
	public String ivthListMethod(Model model) {
	
		ArrayList<StudentInfo> stdList = studentDAO.listStudents();
	
		model.addAttribute("stdList", stdList);
		
		return "ivthList";
	}
	
	@RequestMapping(value = { "/vthList" }, method = RequestMethod.GET)
	public String vthListMethod(Model model) {
	
		ArrayList<StudentInfo> stdList = studentDAO.listStudents();
	
		model.addAttribute("stdList", stdList);
		
		return "vthList";
	}
	
	@RequestMapping(value = { "/vithList" }, method = RequestMethod.GET)
	public String vithListMethod(Model model) {
	
		ArrayList<StudentInfo> stdList = studentDAO.listStudents();
	
		model.addAttribute("stdList", stdList);
		
		return "vithList";
	}
	
	@RequestMapping(value = { "/viithList" }, method = RequestMethod.GET)
	public String viithListMethod(Model model) {
	
		ArrayList<StudentInfo> stdList = studentDAO.listStudents();
	
		model.addAttribute("stdList", stdList);
		
		return "viithList";
	}
	
	@RequestMapping(value = { "/viiithList" }, method = RequestMethod.GET)
	public String viiithListMethod(Model model) {
	
		ArrayList<StudentInfo> stdList = studentDAO.listStudents();
	
		model.addAttribute("stdList", stdList);
		
		return "viiithList";
	}
	
	@RequestMapping(value = { "/ixthList" }, method = RequestMethod.GET)
	public String ixthListMethod(Model model) {
	
		ArrayList<StudentInfo> stdList = studentDAO.listStudents();
	
		model.addAttribute("stdList", stdList);
		
		return "ixthList";
	}
	
	@RequestMapping(value = { "/xthList" }, method = RequestMethod.GET)
	public String xthListMethod(Model model) {
	
		ArrayList<StudentInfo> stdList = studentDAO.listStudents();
	
		model.addAttribute("stdList", stdList);
		
		return "xthList";
	}
	
	@RequestMapping(value = "/viewStudent", method = RequestMethod.GET)
	public String viewStudent(@RequestParam("stdid") int stdid, Model model) {

		try {

			StudentFeeForm stdFeeForm = studentDAO.getStudentFee(stdid);

			model.addAttribute("stdFeeForm", stdFeeForm);

		} catch (Exception e) {

			return "home";
		}

		return "viewStudentFee";
	}
	
	@RequestMapping(value = "/saveStudFees", method = RequestMethod.POST)
	public String saveStudFees(Model model, @Validated StudentFeeForm form, BindingResult formBinding, final WebRequest request) {
		String message = null;
		boolean status=false;

		try {
			status = studentDAO.savePaidFees(form);
		} catch (Exception e) {
			
			message = e.getMessage();
			model.addAttribute("message", message);
			
			return "403";
		}
if(status)
		return "redirect:/viewStudent?stdid="+form.getStd_id();
else
	return "redirect:/403";
	}
	
	
	@RequestMapping(value = { "/viewRemFees" }, method = RequestMethod.GET)
	public String viewRemFees(Model model) {
	
		ArrayList<StudentInfo> stdList = studentDAO.listRemStudents();
	
		model.addAttribute("stdList", stdList);
		
		return "viewRemFees";
	}
	
	@RequestMapping(value = { "/viewPaidFees" }, method = RequestMethod.GET)
	public String viewPaidFees(Model model) {
	
		ArrayList<StudentInfo> stdList = studentDAO.listPaidStudents();
	
		model.addAttribute("stdList", stdList);
		
		return "viewPaidFees";
	}
	
	@RequestMapping(value = "/addNewFees", method = RequestMethod.GET)
	public FeeTypeForm addNewFees(WebRequest request) {

		return new FeeTypeForm();
	}
	
	@RequestMapping(value = "/saveFeeType", method = RequestMethod.POST)
	public String saveFeeType(Model model, @Validated FeeTypeForm form, BindingResult formBinding, final WebRequest request) {
		String message = null;
		boolean status=false;

		try {
			status = feesDAO.saveFeeType(form);
		} catch (Exception e) {
			
			message = e.getMessage();
			model.addAttribute("message", message);
			
			return "403";
		}
if(status)
		return "redirect:/home";
else
	return "redirect:/403";
	}
	
}
