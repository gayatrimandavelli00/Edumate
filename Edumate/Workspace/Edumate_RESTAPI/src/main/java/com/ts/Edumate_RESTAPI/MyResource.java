package com.ts.Edumate_RESTAPI;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;*/

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.dao.AnswerDAO;
import com.dao.EBooksDAO;
import com.dao.InterviewQuestionsDAO;
import com.dao.ItemDAO;
//import com.dao.FileDetailsDAO;
import com.dao.OrganizerDAO;
import com.dao.QPostDAO;
import com.dao.StudentDAO;
import com.dao.TimeTableDAO;
import com.ts.dto.Answer;
import com.ts.dto.EBooks;
import com.ts.dto.InterviewQuestions;
import com.ts.dto.ItemDetails;
//import com.dao.TimeTableDAO;
/*import com.dao.UploadDAO;
import com.ts.dto.FileDetails;*/
import com.ts.dto.Organizer;
import com.ts.dto.QPost;
import com.ts.dto.Student;
import com.ts.dto.TimeTable;
/*import com.ts.dto.TimeTable;
import com.ts.dto.Upload;*/

@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	@Path("registerStudent")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerStudent(Student student) {
		System.out.println("Data Recieved in Emp Register : " + student);
		StudentDAO studentDAO = new StudentDAO();
		studentDAO.register(student);
	
	}
	
	/*@Path("addTimeTable")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addtimeTable(TimeTable timeTable) {
		System.out.println("Data Recieved in Emp Register : " + timeTable);
		TimeTableDAO timeTableDAO = new TimeTableDAO();
		timeTableDAO.register(timeTable);
	
	}*/
	
	@Path("registerOrganizer")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerOrganizer(Organizer organizer) {
		System.out.println("Data Recieved in Emp Register : " + organizer);
		OrganizerDAO organizerDAO = new OrganizerDAO();
		organizerDAO.register(organizer);
	
	}
	
	
	@Path("getStudents")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudents() {

		StudentDAO studentDAO = new StudentDAO();
		List <Student> stuList = studentDAO.getAllStudents();
		System.out.println(stuList);

		return stuList;
	}
	
	@Path("getStuByUserPass/{emailId}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStuByUserPass(@PathParam("emailId") String emailId,@PathParam("password") String password) {
		System.out.println("Recieved path params: "+emailId+" "+password); 
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.getStuByUserPass(emailId, password);
		System.out.println(student);
		return student;
	}
	
	@Path("getOrgByUserPass/{emailId}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Organizer getOrgByUserPass(@PathParam("emailId") String emailId,@PathParam("password") String password) {
		System.out.println("Recieved path params: "+emailId+" "+password); 
		OrganizerDAO organizerDAO = new OrganizerDAO();
		Organizer organizer = organizerDAO.getOrgByUserPass(emailId, password);
		System.out.println(organizer);
		return organizer;
	}
	@Path("getObjectByEmail/{emailId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Student getObjectByEmail(@PathParam("emailId") String emailId) {
		System.out.println("Recieved path params: " + emailId);
		StudentDAO studentDAO = new StudentDAO();
		Student student = studentDAO.getObjectByEmail(emailId);
		System.out.println(student);
		
		return student;
	}

   
	
	
	@Path("uploadImage")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void uploadImage(@FormDataParam("itemImage") InputStream fileInputStream,@FormDataParam("itemImage") FormDataContentDisposition
	formDataContentDisposition, @FormDataParam("itemName") String itemName) throws IOException {; 
		int read = 0;
		byte[] bytes = new byte[3072];
		
		String path = this.getClass().getClassLoader().getResource("").getPath();
		
		String pathArr[] = path.split("/WEB-INF/classes/");
		System.out.println(pathArr[0]);
		FileOutputStream out = new FileOutputStream(new File(pathArr[0]+"/image/", formDataContentDisposition.getFileName()));
				
				
		while((read = fileInputStream.read(bytes)) != -1){	
			
			out.write(bytes,0,read);
		}
		out.flush();
		out.close();
		
		ItemDetails item = new ItemDetails();
		item.setItemName(itemName);
		//item.setItemDescription(itemDescription);
		item.setItemImage(formDataContentDisposition.getFileName());
		ItemDAO itemDao = new ItemDAO();
		itemDao.additem(item);
	}
	
	@Path("getProducts/{value}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ItemDetails> getProducts(@PathParam("value") String x) {
	System.out.println(x);
	ItemDAO itemDAO = new ItemDAO();
	List <ItemDetails> itemList = itemDAO.getAllItemDetails(x);
	System.out.println(itemList);
	return itemList;
	}
	
	@Path("addTask")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addTask(TimeTable timetable) {
		System.out.println("Data Recieved for task : " + timetable);
		TimeTableDAO timeTableDAO = new TimeTableDAO();
		timeTableDAO.addTasks(timetable);
	
	}
//	@Path("timetable")
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public void timeTable() {
//		TimeTable timeTable1 = new TimeTable();
//		TimeTableDAO timeDAO = new TimeTableDAO();
//		timeTable1.setEvent("work");
//		timeTable1.setDate("20-20-20");
//		timeTable1.setTime("3:40");
//		timeTable1.setRegNo(1);
//		timeDAO.addTasks(timeTable1);
//	}
	
	@Path("getAllTasks/{regNo}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TimeTable> getAllTasks(@PathParam("regNo") int regNo) {
		System.out.println(regNo);
		TimeTableDAO timeDAO = new TimeTableDAO();
		List <TimeTable> taskList = timeDAO.getAllTasks(regNo);
		System.out.println(taskList);

		return taskList;
	}
	
	@Path("editTask")
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void editTask(TimeTable timetable) {		
		System.out.println("Data Received in update : " + timetable);
		TimeTableDAO timetableDAO = new TimeTableDAO();
		timetableDAO.editTask(timetable);		
		System.out.println("Employee Record Updated Successfully!!!");
    }
	
	@Path("deleteTask/{tid}")
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteEmp(@PathParam("tid") int tid) {		
		System.out.println("Data Received in delete : " + tid);		
		TimeTableDAO timetableDAO = new TimeTableDAO();
		System.out.println(tid);
		TimeTable time = timetableDAO.getOneTask(tid);		
		timetableDAO.deleteTask(time);
		System.out.println("Employee Record Deleted Successfully!!!");
    }
	
	@Path("iUpload")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void iUpload(InterviewQuestions iq) {
		InterviewQuestionsDAO q = new InterviewQuestionsDAO();
		q.register(iq);
	}
	@Path("getAllQ")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<InterviewQuestions> getAllQ() {
		//System.out.println(regNo);
		InterviewQuestionsDAO iqDAO = new InterviewQuestionsDAO();
		List <InterviewQuestions> taskList = iqDAO.getAllQuestions();
		System.out.println(taskList);

		return taskList;
	}
	
	@Path("editProfile")
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void editProfile(Student student) {		
		System.out.println("Data Received in update : " + student);
		StudentDAO studentDAO = new StudentDAO();
		studentDAO.editProfile(student);		
		System.out.println("Employee Record Updated Successfully!!!");
    }
	
	@Path("uploadEbook")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void uploadEbook(@FormDataParam("itemImage") InputStream fileInputStream,@FormDataParam("itemImage") FormDataContentDisposition
	formDataContentDisposition,@FormDataParam("pdf") InputStream fileInputStream1,@FormDataParam("pdf") FormDataContentDisposition
	formDataContentDisposition1, @FormDataParam("depName") String depName,@FormDataParam("bookName") String bookName,@FormDataParam("bookdecs") String bookdecs,@FormDataParam("aname") String aname) throws IOException {; 
		int read = 0;
		byte[] bytes = new byte[3072];
		byte[] bytes1 = new byte[3072];
		
		String path = this.getClass().getClassLoader().getResource("").getPath();
		
		String pathArr[] = path.split("/WEB-INF/classes/");
		System.out.println(pathArr[0]);
		FileOutputStream out = new FileOutputStream(new File(pathArr[0]+"/image/", formDataContentDisposition.getFileName()));
				
		FileOutputStream out1 = new FileOutputStream(new File(pathArr[0]+"/image/", formDataContentDisposition1.getFileName()));
				
		while((read = fileInputStream.read(bytes)) != -1){	
			
			out.write(bytes,0,read);
		}
		out.flush();
		out.close();
		read=0;
		while((read = fileInputStream1.read(bytes1)) != -1){	
			
			out1.write(bytes1,0,read);
		}
		out1.flush();
		out1.close();

		EBooks ebook = new EBooks();
		ebook.setBname(bookName);
		ebook.setDep(depName);
		ebook.setAname(aname);
		ebook.setBdec(bookdecs);
		ebook.setImg(formDataContentDisposition.getFileName());
		ebook.setPdf(formDataContentDisposition1.getFileName());
		EBooksDAO ed = new EBooksDAO();
		ed.additem(ebook);
		System.out.println("haii");
	}
	
	@Path("getAllBooks")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EBooks> getAllBooks() {
		//System.out.println(dept);
		EBooksDAO bookDAO = new EBooksDAO();
		List <EBooks> bookList = bookDAO.getAllBooks();
		System.out.println(bookList);

		return bookList;
	}
	
	@Path("mail")
    @POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
   public String mail(@FormDataParam("subject") String suggestion,@FormDataParam("emailId") String emailId) throws MessagingException {
		System.out.println(suggestion);
       String email="edumate.replies@gmail.com";
       String host = "smtp.gmail.com";
       String from = "edumate.replies@gmail.com";
       String pass = "Edumate123@";
       System.out.println(emailId+"Received in mail");
       Properties props = System.getProperties();
    
       props.put("mail.smtp.starttls.enable", "true"); // added this line
       props.put("mail.smtp.host", host);
       props.put("mail.smtp.user", from);
       props.put("mail.smtp.password", pass);
       props.put("mail.smtp.port", "587");
       props.put("mail.smtp.auth", "true");
    
       String[] to = {email}; // added this line
    
       Session session = Session.getDefaultInstance(props, null);
       MimeMessage message = new MimeMessage(session);
       message.setFrom(new InternetAddress(from));

       InternetAddress[] toAddress = new InternetAddress[to.length];

       // To get the array of addresses

       for( int i=0; i < to.length; i++ ) {
	       toAddress[i] = new InternetAddress(to[i]);
       }
   
       for( int i=0; i < toAddress.length; i++) {
           // changed from a while loop
           message.addRecipient(Message.RecipientType.TO, toAddress[i]);
       }
   
       message.setSubject(emailId + " sent this suggestion.");
       message.setText(suggestion);

       Transport transport = session.getTransport("smtp");

       transport.connect(host, from, pass);
       transport.sendMessage(message, message.getAllRecipients());

       transport.close();

       return "Successful";
	}
	
	@Path("qpost")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void qpost(@FormDataParam("q") String ques,@FormDataParam("user") String user) {
		System.out.println("Data Recieved for task : " + ques);
		QPost qpost = new QPost();
		qpost.setQuestion(ques);
		qpost.setUserName(user);
		QPostDAO qpostDAO = new QPostDAO();
		qpostDAO.postq(qpost);
	
	}
	
	@Path("getAllfQ")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<QPost> getAllfQ() {
		//System.out.println(dept);
		QPostDAO qpostdao = new QPostDAO();
		List <QPost> qlist = qpostdao.getAllQs();
		System.out.println(qlist);

		return qlist;
	}
	
	@Path("replya")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void replya(Answer answers) {
		System.out.println("Data Recieved in Emp Register : " + answers);
		AnswerDAO answersDAO = new AnswerDAO();
		//Answer answer = new Answer();
		answersDAO.replypost(answers);
	
	}
	
	@Path("getAllRep/{value}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Answer> getAllRep(@PathParam("value") int x) {
	System.out.println("heyyyyy\n");
	AnswerDAO answersDAO = new AnswerDAO();
	List <Answer> itemList = answersDAO.getAllReplies(x);
	System.out.println(itemList);
	return itemList;
	}
	
	@Path("uploadProfilePic")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void uploadProfilePic(@FormDataParam("itemImage") InputStream fileInputStream,@FormDataParam("itemImage") FormDataContentDisposition
	formDataContentDisposition, @FormDataParam("regdNo") int regdNo) throws IOException {; 
		int read = 0;
		byte[] bytes = new byte[3072];
		System.out.println("hey i am in uploadProfilePic");
		String path = this.getClass().getClassLoader().getResource("").getPath();
		
		String pathArr[] = path.split("/WEB-INF/classes/");
		//System.out.println(pathArr[0]);
		FileOutputStream out = new FileOutputStream(new File(pathArr[0]+"/image/", formDataContentDisposition.getFileName()));
				
				
		while((read = fileInputStream.read(bytes)) != -1){	
			
			out.write(bytes,0,read);
		}
		out.flush();
		out.close();
		StudentDAO student = new StudentDAO();
		System.out.println(regdNo);
		List<Student> st = student.getStudent(regdNo);
		System.out.println(st);
		Student s = st.get(0);
		s.setStudentImg(formDataContentDisposition.getFileName());
		student.editProfile(s);
		System.out.println("Success");
		//s
		//s.setFirstName(st[0].firstName);
	}
	@Path("deleteProfilePic")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteProfilePic(Student student) {
		StudentDAO studentDAO = new StudentDAO();
		student.setStudentImg("");
		//System.out.println(tid);
		//Student s = new Student();
		studentDAO.editProfile(student);
		System.out.println("Employee Record Deleted Successfully!!!");
	}
	@Path("getStudent/{reg}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudent(@PathParam("reg") int reg) {

		StudentDAO studentDAO = new StudentDAO();
		List <Student> stuList = studentDAO.getStudent(reg);
		System.out.println("Imag"+stuList);

		return stuList;
	}
	
	@Path("getCount")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public long getCount() {
	StudentDAO studentDAO = new StudentDAO();
	long result = studentDAO.getCount();
	System.out.println(result);
	return result;
	}

	@Path("getCount1")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public long getCount1() {
	EBooksDAO ebooksDAO = new EBooksDAO();
	long result = ebooksDAO.getCount();
	System.out.println(result);
	return result;
	}

	@Path("getCount2")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public long getCount2() {
	InterviewQuestionsDAO interviewQuestionsDAO = new InterviewQuestionsDAO();
	long result = interviewQuestionsDAO.getCount();
	System.out.println(result);
	return result;
	}

	@Path("getCount3")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public long getCount3() {
	ItemDAO itemDAO = new ItemDAO();
	long result = itemDAO.getCount3();
	System.out.println(result);
	return result;
	}

		
}
