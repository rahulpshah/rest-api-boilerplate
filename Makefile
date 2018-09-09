.PHONY: build

build:
	docker build -t ${LANG} ${LANG}

run:
	docker run -p 8000:8000 ${LANG}
