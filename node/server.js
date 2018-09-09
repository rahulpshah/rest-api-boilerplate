const express = require('express');
const app = express();
const bodyParser = require("body-parser");
const router = express.Router();
const port = 8000;

// url: http://localhost:3000/
app.get('/', (request, response) => response.send('Hello World'));

app.use(bodyParser.urlencoded({
    extended: true
}));


// all routes prefixed with /api
app.use(bodyParser.json());
app.use('/', router);

// using router.get() to prefix our path
// url: http://localhost:3000/api/
router.post('/', (request, response) => {
        var result = undefined
	var a = request.body.a
	var b = request.body.b
	switch(request.body.operator) {
	    case "add":
		res = a + b
		break;
	    case "mul":
		res = a * b
		break;
	    default:
		res = a - b
	}
   response.json({result: res+""});
});

// set the server to listen on port 3000
app.listen(port, () => console.log(`Listening on port ${port}`));
