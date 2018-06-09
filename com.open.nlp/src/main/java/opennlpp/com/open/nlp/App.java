package opennlpp.com.open.nlp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

public class App 
{
	static String sentence="Hi. How are you? Welcome to my github project. \" \r\n" + 
			"         + \"lets see how it unfolds";
	
	static InputStream inputSteam=null;
	static SentenceModel model=null;
    public static void main( String[] args )
    {
    	
    	try {
			 inputSteam =new FileInputStream("./model/en-sent.bin");
			  model=new SentenceModel(inputSteam);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
		}
    	SentenceDetectorME detector =new SentenceDetectorME(model);
        String sentences[] =detector.sentDetect(sentence);
        for(String sent:sentences) {
        	System.out.println(sent);
        }
    }
}
