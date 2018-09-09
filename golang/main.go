package main;
import (
        "fmt"
	"github.com/gorilla/mux"
	"net/http"
	"io/ioutil"
	"strconv"
	"encoding/json"
)

type Operator func (int,int) int

func Add(a,b int) int {
        return a + b
}
func Sub(a,b int) int {
        return a - b
}

func Mul(a,b int) int {
	return a*b
}

func Div(a,b int) int {
	return a/b
}

type Operation struct{
        A int
        B int
        Op Operator
}

func (o *Operation) PerformOperation() int {
        return o.Op(o.A, o.B)
}

var operationMap = map[string]Operator{
	"add": Add,
	"sub": Sub,
	"mul": Mul,
	"div": Div,
}

func (o *Operation) UnmarshalJSON(data []byte) error {
	var v map[string]interface{}
	if err := json.Unmarshal(data, &v); err != nil {
		return err
	}
	o.A = int(v["a"].(float64))
	o.B = int(v["b"].(float64))
        o.Op = operationMap[v["operator"].(string)]
	return nil
}

func main() {

    router := mux.NewRouter().StrictSlash(true)
    router.HandleFunc("/", PerformOperation)
    fmt.Println("Listening on :8081")
    fmt.Println(http.ListenAndServe(":8081", router))
}

func PerformOperation(w http.ResponseWriter, r *http.Request) {
    body, _ := ioutil.ReadAll(r.Body)
    defer r.Body.Close()
    var m Operation
	if err := json.Unmarshal(body, &m); err != nil {
		fmt.Println(err)
		return
    }
    data := map[string]string{"result": strconv.Itoa(m.PerformOperation())}
    w.Header().Set("Content-Type", "application/json")
    w.WriteHeader(http.StatusOK)
    jsonString, _ := json.Marshal(data)
    fmt.Fprintln(w, string(jsonString))
}

