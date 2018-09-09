import falcon
import operator

class QuoteResource:
    def on_post(self, req, resp):
        """Handles GET requests"""
        body = req.media
        a = body["a"]
        b = body["b"]
        op = getattr(operator, body["operator"])
        result = {"result": str(op(a, b))}
        resp.media = result

api = falcon.API()
api.add_route('/', QuoteResource())
