package com.ssafy.step03.annotation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;import org.springframework.stereotype.Component;
@Component("outputterFile")
public class OutputServiceImplFile implements OutputService {

	public void output(String msg) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("msg.txt",true),true);
			//append 모드임 filewriter
			out.println(msg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(out !=null)
				out.close();
		}

	}

}
