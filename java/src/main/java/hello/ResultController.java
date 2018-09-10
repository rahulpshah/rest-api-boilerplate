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
    public Result greeting(@RequestBody Operation operation) {
	    return new Result(operation.evaluate());
    }
}
