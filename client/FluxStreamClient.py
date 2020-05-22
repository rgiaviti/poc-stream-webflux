#!/usr/bin/env python
from sseclient import SSEClient
import json

url = 'http://localhost:8080/books/subscribe'
messages = SSEClient(url)
for msg in messages:
    print(msg)

