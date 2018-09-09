package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {
    @RequestMapping(value = "/", headers="Content-Type=application/json", method=RequestMethod.POST)
    @ResponseBody
    public Result greeting(@RequestBody Operation responseBody) {
	int a = responseBody.getA();
	int b = responseBody.getB();
	String op = responseBody.getOp();
	int result = -1;
	switch 	(op) {
		case "add":
			result = a + b;
			break;
		case "sub":
			result = a - b;
			break;
		case "mul":
			result = a * b;
			break;
	}
        return new Result(result);
    }
}
