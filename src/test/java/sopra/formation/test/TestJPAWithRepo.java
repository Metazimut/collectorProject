package sopra.formation.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.formation.Application;
import sopra.formation.model.Message;
import sopra.formation.repository.IMessageRepository;

public class TestJPAWithRepo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

		IMessageRepository messageRepo = context.getBean(IMessageRepository.class);


		Message message1 = new Message();
		message1.setMessageTxt("lol");
		messageRepo.save(message1);
		
		Message message2 = new Message();
		messageRepo.save(message2);
		
		System.out.println(messageRepo.findById(1L).get());
		
		context.close();
	}

}
