import numpy as np


def generate_location(count: int):
    x_locs = np.random.uniform(-180, 180, count)
    y_locs = np.random.uniform(-90, 90, count)
    coords = []
    for x, y in zip(x_locs, y_locs):
        coords.append({'x': x, 'y': y})
    return coords