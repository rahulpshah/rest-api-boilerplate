FROM golang

COPY main.go /go/src/main.go

WORKDIR /go/src

RUN go get -d

CMD ["go", "run", "main.go"]
