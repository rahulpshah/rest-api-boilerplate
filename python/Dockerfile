FROM python:3.6-slim

COPY app.py app.py

COPY requirements.txt requirements.txt

RUN pip install -U -r requirements.txt

ENTRYPOINT ["gunicorn"]

CMD ["--log-level", "DEBUG", "--access-logfile", "-", "-b", "0.0.0.0:8000", "app:api"]


