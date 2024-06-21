package in.kanha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Application {

	public static String url = "http://localhost:8080/ticket{ticketNumber}";
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//-----------------------------------------------------------------------		

//		WebClient client = WebClient.create();
//		System.out.println("Request sanding start.....");
//		String block = client.get()
//		      .uri(url, 1)
//		      .retrieve()
//		      .bodyToMono(String.class)
//		      .block();		
//		System.out.println(block);
//		System.out.println("Request sanding end.....");
//		
//	}	
//	Request sanding start.....
//	{"ticketNumber":5,"status":"CONFIRMED","price":500.0,"name":"kanha","form":"Delhi","doj":"12-12-2012","trainNumber":"5588"}
//	Request sanding end.....

//----------------------------------------------------------------------------------	
		WebClient client = WebClient.create();
		System.out.println("Request sanding start.....");
		           client.get()
			      .uri(url, 1)
			      .retrieve()
			      .bodyToMono(String.class)
			      .subscribe(Application::handleResponse);
		System.out.println("Request sanding end.....");          
	}	
	public static void handleResponse(String res)
	{
		System.out.println(res);
    }
	
//	Request sanding start.....
//	Request sanding end.....
//	{"ticketNumber":5,"status":"CONFIRMED","price":500.0,"name":"kanha","form":"Delhi","doj":"12-12-2012","trainNumber":"5588"}

}
