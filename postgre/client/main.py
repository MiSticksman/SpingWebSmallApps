import requests
import json

import random

from coordsGenerator import generate_location
from varsContainer import types
import names
import time
from threading import Thread
import string

URL = 'http://localhost:8080/boreholesOnArea/save'


def generate_random_names_and_numbers(count: int):
    area_names = []
    with open("area_names.txt", "w") as file:
        for i in range(count):
            # area_names.append(names.get_first_name())
            letters = string.ascii_lowercase
            result_str = ''.join(random.choice(letters) for i in range(10))
            area_names.append(result_str)
            if i == 1000:
                print("work")
            file.write(area_names[i] + ' ')
    return area_names


def execute(count):
    for i in range(count):
        area_loc = random.choice(areas_coords)
        borehole_loc = random.choice(boreholes_coords)
        area_name = random.choice(area_names)
        b_number = random.randint(1, 5*count)
        b_type = random.choice(types)

        data = {
            "areaName": area_name,
            "areaLocation": area_loc,
            "boreholeNumber": b_number,
            "boreholeType": b_type,
            "boreholeLocation": borehole_loc
        }
        data_json = json.dumps(data)
        # print(data_json)
        r = requests.post(url=URL, data=data_json, headers={'Content-Type': 'application/json'})
        if r.status_code != 200:
            print(r.status_code)
    print('end')

if __name__ == '__main__':
    start_time = time.time()
    count = 10000


    areas_coords = generate_location(count)
    boreholes_coords = generate_location(count)

    # area_names = generate_random_names_and_numbers(count)
    with open("area_names.txt", "r") as file:
        area_names = file.read().strip().split()

    for i in range(10):
        th = Thread(target=execute, args=(count,))
        th.start()

    print("--- %s seconds ---" % (time.time() - start_time))

