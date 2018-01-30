package org.srikanth.com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algorithmia.APIException;
import com.algorithmia.AlgorithmException;
import com.algorithmia.Algorithmia;
import com.algorithmia.AlgorithmiaClient;
import com.algorithmia.algo.AlgoResponse;
import com.algorithmia.algo.Algorithm;

@RestController
class Working {

	String input = "{"
			 + "  \"image\": \"https://s-media-cache-ak0.pinimg.com/originals/4b/5b/d0/4b5bd0741fee8a9d86e043352f580362.jpg\""
			 + "}";
			
				
	
	
			
			
			AlgorithmiaClient client = Algorithmia.client("simu4P0IUKn0EapbiFyGtNNaSTz1");
			Algorithm algo = client.algo("deeplearning/ColorfulImageColorization/1.1.7");
			AlgoResponse result;
			
			@RequestMapping("/print")
			public String imageProcessing(){
			try {
				result = algo.pipeJson(input);
				try {
					System.out.println("");
					String val="Image colorization Processed. Please Loginto https://algorithmia.com/data/hosted and check your repository";
					return val+ result.asJsonString();
				} catch (AlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (APIException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Image not Processed";
			}
}
